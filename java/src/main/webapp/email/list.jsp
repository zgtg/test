<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>邮件</title>

    <style>
        table,td, th {
            border: 1px grey solid;
        }
    </style>

    <script>
        /**
         * 全选
         */
        function checkAll() {
            var checkboxArr = document.getElementsByName('email-checkbox');

            for(var i=0; i<checkboxArr.length; i++) {
                checkboxArr[i].checked=true;
            }
        }

        /**
         * 取消全选
         */
        function uncheckAll() {
            var checkboxArr = document.getElementsByName('email-checkbox');

            for(var i=0; i<checkboxArr.length; i++) {
                checkboxArr[i].checked=false;
            }
        }

        /**
         * 反选
         */
        function reverseCheck() {
            var checkboxArr = document.getElementsByName('email-checkbox');

            for(var i=0; i<checkboxArr.length; i++) {
                checkboxArr[i].checked = !checkboxArr[i].checked;
            }
        }

        /**
         * 删除选中邮件
         */
        function deleteCheckedEmail() {
            var checkboxArr = document.getElementsByName('email-checkbox');

            for(var i=checkboxArr.length-1; i>=0; i--) {
                if(checkboxArr[i].checked) {
                    var trEle = checkboxArr[i].parentNode.parentNode;
                    trEle.remove();
                }
            }
        }

    </script>
</head>
<body>
    ${msg}124
    <table>
        <thead>
        <tr>
            <th><input type="checkbox">全选</th>
            <th>发件人</th>
            <th>邮件名称</th>
            <th>邮件附属信息</th>
        </tr>
        </thead>

        <tbody>
            <c:forEach items="${emailList}" var="email">
                <tr>
                    <td><input type="checkbox" name="email-checkbox"></td>
                    <td>${email.senderName}</td>
                    <td>${email.title}</td>
                    <td>${email.content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<button onclick="checkAll();">全选</button><br/>
<button onclick="uncheckAll();">取消全选</button><br/>
<button onclick="reverseCheck();">反选</button><br/>
<button onclick="deleteCheckedEmail();">删除选中邮件</button><br/>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 13126
  Date: 2020/3/18
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script type="text/javascript">
        function studentAdd() {
            // 判断名字是否为空
            var nameEle = document.getElementById("name");
            var name = nameEle.value;
            if (name == null || name.length <= 0){
                alert('名字不能为空');
                return;
            }

            // 判断出生日期是否为空
            var birthdayEle = document.getElementById("birthday");
            var birthday = birthdayEle.value;
            if (birthday == null || birthday.length <= 0){
                alert('出生日期不能为空');
                return;
            }

            // 判断性别不能为空
            var sex = 0;
            var sexArr = document.getElementsByName("sex");
            for (var i = 0; i < sexArr.length; i++){
                if (sexArr[i].checked){
                    sex = sexArr[i].value;
                }
            }
            if (sex == 0){
                alert('性别不能为空');
                return;
            }

            // 判断省份不能为空
            var provinceEle = document.getElementById("province");
            var province = provinceEle.value;
            if (province == ""){
                alert('省份不能为空');
                return;
            }

            //判断爱好是否为空
            var str = "";
            var sportArr = document.getElementsByName("sport");
            for (var i = 0; i < sportArr.length; i++){
                if (sportArr[i].checked){
                    str += sportArr[i]+",";
                }
            }
            if (str.length <= 0){
                alert("爱好不能为空");
                return;
            }

            str = str.substring(0, str.length-1);

            return true;
        }


    </script>

    <form action="/student/addPost" method="post">
        名字:<input type="text" name="name" id="name"/><br/>
        出生日期：<input type="text" name="birthday" id="birthday"/><br/>
        性别：<input type="radio" name="sex" value="1" />男
              <input type="radio" name="sex" value="2" />女<br/>
        省份：<select id="province" name="province">
                <option value="">--请选择--</option>
                <option value="1">北京</option>
                <option value="2">河南</option>
              </select><br/>
        爱好：<input type="checkbox" name="sport" value="1" />蓝球
            <input type="checkbox" name="sport" value="2" />足球<br/>
        <input type="submit" value="提交" onclick="return studentAdd()">
    </form>
</body>
</html>

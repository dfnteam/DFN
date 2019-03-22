<%--
  Created by IntelliJ IDEA.
  User: Anisworth
  Date: 2019/3/12
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    // $(function () {
    //     $("#submit").click(function b(){
    //         $.ajax({
    //             url: "/list",//请求地址
    //             type: "POST",
    //             dataType: "json",
    //             success: function(data) {//data是默认的，接收后台返回的数据
    //                 alert("success");
    //
    //             }
    //         });
    //     });})

    function a() {
        $.ajax({
            url: "/getAllUser",//请求地址
            type: "GET",
            dataType: "json",
            success: function(data) {//data是默认的，接收后台返回的数据
                // var jsonObj =  JSON.parse(data);//转换为json对象
                //
                // for(var i=0;i<jsonObj.length;i++){
                //     alert(jsonObj[i].userName);  //取json中的值
                // }
                alert("ok");
                alert(data);
            }
        });
    }
</script>
<body>

<input type="button" value="获取" onclick="a()"/>
</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

</html>

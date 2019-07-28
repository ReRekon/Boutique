<%--
  Created by IntelliJ IDEA.
  Date: 2019/7/20
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        var orderId=null;
        var commentContent=null;
        $(function(){
            $("#ok").click(function(){
                $.ajax({
                    url: "/comment/findbyid",
                    dataType: 'json',
                    type: 'POST',
                    contentType: "application/json",
                    data: JSON.stringify({userId: 1}),
                    async: true,
                    success: function (data) {
                        $("#show").html(

                        )
                    }
                });
            });
        });
    </script>
</head>
<body>
<center>
    <div id="show"></div>
    <h1>11111111111111111</h1>
    <button type="button" id="ok">OK</button>
</center>
</body>
</html>

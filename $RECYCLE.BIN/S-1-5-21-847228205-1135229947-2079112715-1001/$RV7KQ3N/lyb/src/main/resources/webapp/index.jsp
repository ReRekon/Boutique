<%--
  Created by IntelliJ IDEA.
  User: LLLLLLi
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
        $(function(){
            $("#ok").click(function(){
                $.ajax({
                    url: "/comment/find",
                    dataType: 'json',
                    type: 'POST',
                    contentType: "application/json",
                    data: JSON.stringify({comment: null}),
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

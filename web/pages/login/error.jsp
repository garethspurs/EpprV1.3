
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fail</title>
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
    <script src="${pageContext.request.contextPath}/js/javaScript.js"></script>
</head>
<body>

<p align="center">
    Please, check your login and password
</p>
<p align="center"><input type="button" value="Back" class="button_class highlighting_class" onclick="Back()"></p>
<script language="JavaScript">
    function Back(){
        document.location.href='/pages/login/login.jsp';
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/javaScript.js"></script>
    <title>Authentication</title>
</head>
<body>
<form name="authorization_form" action="j_security_check" method="post" id="autorization_form" >
    <h1 align="center">Login </h1>
    <div class="container " align="center">
        <input type="email" id="login_editbox" name="j_username" class="container" required/>
        <label for="login_editbox">Email</label>
    </div>
    <div class="container " align="center">
        <input type="password" id="password_editbox" name="j_password" class="container"  required/>
        <label for="password_editbox">Password</label>
    </div>
    <p align="center" >
        <input class="button_class " type="submit" value="Submit" id="submit_btn">
        <input class="button_class " value="Registration" id="registration_button" type="button" onclick="registr()">
    </p>
</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/javaScript.js"></script>
</head>
<body>
    <form id="reg_form_id" name="registration_user_form" action="${pageContext.request.contextPath}/dispatch/addUser/registration"
          method="post">
        <p align="center">Registration</p>
        <jsp:include page="${pageContext.request.contextPath}/pages/modify.jsp"/>
        <p align="center">
            <c:set var="str" value="/dispatch/addUser/registration"/>
            <input type="button" value="Save" class="button_class" onclick="validate('#reg_form_id')">
        </p>

    </form>
    <form action="${pageContext.request.contextPath}/dispatch/redirect/login">
        <p align="center">
            <input type="button" value="Cancel" class="button_class" id="cancel_registrationpage" onclick="cancelRegPage()">
        </p>
    </form>
</body>
</html>

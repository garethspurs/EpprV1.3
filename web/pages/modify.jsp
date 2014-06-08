<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/javaScript.js"></script>
</head>
<body>
<div class="container" align="center">
    <input type="text" name="email" id="add_email_id" class="container" value="${user.email}" required oninput="emailValidate()">
    <div id="required_email_pattern_info" class="additional_info"></div>
    <label for="add_email_id">Email</label>
</div>
<div class="container highlighting_class" align="center">
    <input type="password" name="password" id="add_password_id" class="container" value="${user.password}" required oninput="passwordValidate()">
    <div id="required_password_pattern_info" class="additional_info"></div>
    <label for="add_password_id">Password</label>
</div>
<c:set value="name" var="name_info"/>
<div class="container highlighting_class" align="center">
    <input type="text" name="name" id="add_name_id" class="container" value="${user.name}"required oninput="nameValidate(${name_info})">
    <div id="required_name_pattern_info" class="additional_info"></div>
    <label for="add_name_id">Name</label>
</div>
<div class="container highlighting_class" align="center">
    <input type="text" name="surname" id="add_surname_id" class="container" value="${user.surname}"required oninput="nameValidate(${surname_info})">
    <div id="required_surname_pattern_info" class="additional_info"></div>
    <label for="add_surname_id">Surname</label>
</div>
<c:set value="surname" var="surname_info"/>
<div class="container highlighting_class" align="center">
    <input type="text" name="phone" id="add_phone_id" class="container" value="${user.phone}" required oninput="phoneValidate()">
    <div id="required_phone_pattern_info" class="additional_info"></div>
    <label for="add_phone_id">Phone</label>

</div>
</body>
</html>

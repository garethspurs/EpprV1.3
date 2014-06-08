<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Add User</title>
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
</head>
<body>
<tags:role-access role="user">
    <c:set var="role" value="user"/>
</tags:role-access>
<tags:role-access role="admin">
    <c:set var="role" value="admin"/>
</tags:role-access>
    <form id="add_form_id" name="add_user_form" action="${pageContext.request.contextPath}/dispatch/addUser/byAdmin" method="post">
        <p align="center">Add new user</p>
        <jsp:include page="${pageContext.request.contextPath}/pages/modify.jsp"/>
            <c:if test="${role == 'admin'}">
                <p align="center">
                    Admin
                        <input type="checkbox" name="checkAdmin">
                </p>
            </c:if>
        <p align="center">
            <input type="submit" value="Add" class="button_class">
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/dispatch/redirect/list" method="post">
        <p align="center">
            <input type="submit" value="Cancel" class="button_class" id="cancel_addpage" onclick="validate('#add_form_id')">
        </p>
</form>
</body>
</html>

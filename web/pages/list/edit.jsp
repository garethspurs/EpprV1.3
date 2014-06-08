<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Edit User</title>
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/javaScript.js"></script>
</head>
<body>
    <tags:role-access role="user">
        <c:set var="role" value="user"/>
    </tags:role-access>
    <tags:role-access role="admin">
        <c:set var="role" value="admin"/>
    </tags:role-access>
    <tags:email>
        <c:set var="email" value="${email}"/>
    </tags:email>


    <form id="edit_form_id" name="edit_panel" action="${pageContext.request.contextPath}/dispatch/modify?id=${user.getId()}" method="post">
        <p align="center">Edit data</p>

        <jsp:include page="${pageContext.request.contextPath}/pages/modify.jsp"/>
        <c:if test="${role == 'admin' && user.email != email}">
            <p align="center">
                Admin
            </p>
            <c:if test="${user.role == 'admin'}">
                <p align="center">
                    <input type="checkbox" name="check" checked>
                </p>
            </c:if>
            <c:if test="${user.role == 'user'}">
                <p align="center">
                    <input type="checkbox" name="check">
                </p>
            </c:if>
        </c:if>
        <p align="center">
            <input type="submit" value="Save" class="button_class">
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/dispatch/redirect/list" method="post">
        <p align="center">
            <input type="submit" value="Cancel" class="button_class" id="cancel_editpage" onclick="validate('#edit_form_id')">
        </p>
    </form>
</body>
</html>

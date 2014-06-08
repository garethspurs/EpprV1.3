<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>List</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../../resources/images/Apps-icon-template-file-icon.png" type="image/png"/>
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
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
        <c:set value="${email}" var="email"/>
    </tags:email>
    <c:out value="${role}"/>
    <c:out value="${email}"/>
    <table  class="usersTable_class" cellpadding="5"  align="center" id="listUsers">
        <caption align="center">Users</caption>
        <tr class="usersTableTitle_class ">
            <th>First name</th>
            <th> Last name</th>
            <th> Email</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${users_set}" var="user">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.surname}"/></td>
                <td><c:out value="${user.email}"/></td>

                <c:if test="${role == 'user'}">
                    <c:if test="${email == user.email}">
                        <td></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dispatch/redirect/edit?id=${user.id}">
                                <img src="${pageContext.request.contextPath}/resources/images/pen-128.png" class="table_image_class">
                            </a>
                        </td>
                    </c:if>
                </c:if>
                <c:if test="${role == 'admin'}">
                    <c:if test="${email != user.email}">
                        <td>
                            <a href="${pageContext.request.contextPath}/Delete?id=${user.id}">
                                <img src="${pageContext.request.contextPath}/resources/images/buttondelete.png" class="table_image_class">
                            </a>
                        </td>
                    </c:if>
                    <c:if test="${email == user.email}">
                        <td></td>
                    </c:if>
                    <td>
                        <a href="${pageContext.request.contextPath}/dispatch/redirect/edit?id=${user.id}">
                            <img src="${pageContext.request.contextPath}/resources/images/pen-128.png" class="table_image_class">
                        </a>
                    </td>
                </c:if>
                <c:if test="${role == 'user'}">
                    <c:if test="${email != user.email}">
                        <td></td>
                        <td></td>
                    </c:if>
                </c:if>
                <c:set var="idinfo" value="idinfo${user.id}"/>
                <c:set var="phone" value="${user.phone}"/>
                <td>
                    <c:if test="${email == user.email}">
                            <button class="info" id="${idinfo}" onclick="editUserInfo('${phone}')">
                            <img src="${pageContext.request.contextPath}/resources/images/info.png" class="table_image_class">
                        </button>
                        <c:set var="currId" value="${user.id}"/>
                    </c:if>
                    <c:if test="${email != user.email}">
                        <button class="info" id="${idinfo}" onclick="checkInfo('${phone}')">
                            <img src="${pageContext.request.contextPath}/resources/images/info.png" class="table_image_class">
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align="center" id="userInfo"></div>
    <input type="text" id="ownInfoEditBox" class="ownInfoHidden" align="center">
    <br><input type="button" id="submitInfo" onclick="submitInfo('${currId}')" align="center" value="sss" class="ownInfoHidden">
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <input type="submit"  value="Logout" class="button_class" id="logout_btn">
    </form>
    <c:if test="${role == 'admin'}">
    <form action="${pageContext.request.contextPath}/dispatch/redirect/add" method="post" >
        <input type="submit" value="Add User" class="button_class" id="add_user_btn">
    </form>
</c:if>

</body>
</html>
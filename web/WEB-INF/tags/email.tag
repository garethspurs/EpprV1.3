<%@tag body-content="scriptless" pageEncoding="UTF-8" %>

<%
    request.setAttribute("email", request.getRemoteUser());
%>
<jsp:doBody/>
<%

%>
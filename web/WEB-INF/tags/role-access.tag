<%@tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@attribute name="role" required="true" rtexprvalue="true" type="java.lang.String" %>

<%
    if(request.isUserInRole(role)){
  %>
<jsp:doBody/>
<%
    }
%>

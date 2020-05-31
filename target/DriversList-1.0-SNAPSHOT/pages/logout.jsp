<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 30.05.2020
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath());
%>
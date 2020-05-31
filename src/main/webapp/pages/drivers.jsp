<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 28.05.2020
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=cp1251">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Drivers list</title>

</head>

<body>
<%
    HttpServletResponse resp = (HttpServletResponse) response;
    String login = (String)session.getAttribute("login");
    if (login == null) {
        resp.sendRedirect("auth.jsp");
    }
%>
<div class="float-right">
    <a href="${pageContext.request.contextPath}/pages/logout.jsp">Logout</a>
</div>
<h1 align="center">Drivers</h1><br>
<form class="form-inline">
    <button type="button" class="btn btn-warning">Add</button>
    <input type="searchfield" class="form-control" id="InputSearch" placeholder="Search..." onkeyup="tableSearch()">
</form>
<Table class="table" id="info-table">
    <tr>
        <th>Surname</th>
        <th>Name</th>
        <th>Patronymic</th>
        <th>Age</th>
        <th>License cathegory</th>
        <th>Experience</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="driver" items="${requestScope.drivers}">
    <tr id="tr_${driver.id}">
        <td data-name="surname"><c:out value="${driver.surname}"/></td>
        <td data-name="name"><c:out value="${driver.name}"/></td>
        <td data-name="patronymic"><c:out value="${driver.patronymic}"/></td>
        <td data-name="age"><c:out value="${driver.age}"/></td>
        <td data-name="license_cathegory"><c:out value="${driver.license_cathegory}"/></td>
        <td data-name="experience"><c:out value="${driver.experience}"/></td>
        <td width="50"><button type="button" class="btn btn-outline-warning action" value="${driver.id}" action="update">Update</button></td>
        <td width="50"><a href="?rm=${driver.id}" class="btn btn-outline-danger">Delete</a></td>
    </tr>
    </c:forEach>
</Table>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 13-05-2021
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
<body>
<div style="font-family: 'Times New Roman'">
<table class="table" style="width: auto;">
    <thead class="thead-dark">
    <tr>
        <th scope="col">${sessionScope.role}</th>
        <th scope="col">${sessionScope.user.name}</th>
        <th scope="col">${sessionScope.user.email}</th>
        <th scope="col">${sessionScope.user.phone}</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">forespørgsels nr.</th>
        <th>kunde nr.</th>
        <th scope="row">carport nr.</th>
        <th scope="row">status</th>
        <th>besked</th>
        <th>navn</th>
        <th>email</th>
        <th>telefon</th>
    </tr>



    <c:forEach items="${requestScope.queries}" var="object">
        <tr>
            <td>${object.id}</td>
            <td>${object.userId}</td>
            <td>${object.carportId}</td>
            <td>${object.status}</td>
            <td>${object.message}</td>
        <c:forEach items="${requestScope.users}" var="users">

                <td>${users.name}</td>
                <td>${users.email}</td>
                <td>${users.phone}</td>
            </tr>
        </c:forEach>
    </c:forEach>

    </tbody>
</table>

</div>
</body>
    </jsp:body>
</t:genericpage>



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
        <h3>Forespørgsel på model CAR01H ${requestscope.name}</h3>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
<body style="background-color: darksalmon;">
<img class="mx-auto d-block rounded" style="width: 356px;height: 249px;float: right;" src="<c:url  value="/data/${requestScope.carport.name}.png"/>" alt="carport"/>

<table class="table" style="width: 50%">
    <thead class="thead-dark">
    <tr>
        <th scope="col">${sessionScope.user.name}</th>
        <th scope="col">${sessionScope.user.email}</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">Model</th>
        <td>${requestScope.carport.name}</td>
    </tr>
    </tbody>
</table>

</body>
    </jsp:body>
</t:genericpage>



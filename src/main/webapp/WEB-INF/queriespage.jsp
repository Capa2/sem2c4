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
                    <th scope="row">kunde navn</th>
                    <th scope="row">kunde email</th>
                    <th>carport nr.</th>
                    <th>status</th>
                    <th>besked</th>
                </tr>
                <c:forEach items="${requestScope.queries}" var="queries">
                    <tr>
                        <td>${queries.id}</td>
                        <td>${queries.userId}</td>
                        <td>${queries.carportId}</td>
                        <td>${queries.status}</td>
                        <td>${queries.message}</td>
                        <td>${requestScope.userFacade.getUser(queries.userId).name}</td>
                        <td>${requestScope.userFacade.getUser(queries.userId).email}</td>
                        <td>${requestScope.userFacade.getUser(queries.userId).phone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        </body>
    </jsp:body>
</t:genericpage>

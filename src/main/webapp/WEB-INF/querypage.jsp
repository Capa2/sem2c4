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

        <div class="container my-5">
            <h2 class="display-4"> ${requestScope.carport.name}
                <c:if test="${carport.length >= 400}">dobbelt</c:if>
                <c:if test="${carport.length < 400}">enkelt</c:if> carport</h2>
            <div class="row mt-4">
                <hr class="border-white">
                <div class="col-5">
                    <div class="mb-4">
                        <h3 class="display-8">Du har sendt en forespørgsel på</h3>
                        <p>${requestScope.carport.width} x ${requestScope.carport.length} mtr.</p>
                        <c:forEach var="material" items="${requestScope.bom.list}">
                            <c:if test="${material.materialCategoryId > 0}"><p>${material.name}</p></c:if>
                        </c:forEach>
                        <p>Inkl. søm, skruer og hulbånd.</p>
                        <br>
                        <h4 class="text-uppercase">PRIS: ${requestScope.bom.priceString} DKK</h4>
                    </div>
                        <%--                        Pictures--%>
                    <div class="row col-6 offset-1">
                        <c:if test="${requestScope.custom = false}">
                            <img class="img-fluid" style="float: right;"
                                 src="<c:url  value='/data/${carport.name}.png'/>"
                                 alt="carport"/>
                            <hr class="border-white">
                        </c:if>
                            ${requestScope.svg}
                    </div>

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
                            <th>Håndværker</th>
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
                                <td>${queries.wantBuilder}</td>

                                <td>
                                    <c:if test="${sessionScope.role.equals('Sælger') || sessionScope.role.equals('employee')}">
                                    <p>${requestScope.bomBuilder.getPriceString(queries.carportId) * 1.5} Dkkr</p>
                                    <c:out
                                            value="${income}"/><p>
                                </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>
            </div>
        </body>
    </jsp:body>
</t:genericpage>



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
        <div class="container my-5">

            <h2 class="display-4">
                <c:if test="${requestScope.carport.name != null}">
                    ${requestScope.carport.name}
                </c:if>
                <c:if test="${requestScope.carport.name == null}">
                    Quick-byg
                </c:if>
                <c:if test="${requestScope.carport.length >= 400}">dobbelt</c:if>
                <c:if test="${requestScope.carport.length < 400}">enkelt</c:if> carport</h2>
            <div class="row mt-4">
                <hr class="border-white">
                <div class="col-7">
                    <c:if test="${sessionScope.user.role == 'employee'}">
                        <h4>Kundedetaljer:</h4>
                        <p>Navn: ${requestScope.customer.name}</p>
                        <p>email: ${requestScope.customer.email}</p>
                        <p>Telefon: ${requestScope.customer.phone}</p>
                    </c:if>
                    <c:if test="${requestScope.query.wantBuilder != 0 && sessionScope.user.role == 'employee'}">
                        <p>Ønsker tilbud fra en håndværker</p>
                    </c:if>
                    <c:if test="${sessionScope.user.role == 'employee'}">
                        <hr class="border-white">
                    </c:if>
                    <h3 class="mb-2">Forespørgselsbekræftigelse</h3>
                    <p>Carport dimensioner: ${requestScope.carport.width} x ${requestScope.carport.length} mtr.</p>
                    <c:if test="${requestScope.carport.shedWidth != 0}">
                        <p>Skur dimensioner: ${requestScope.carport.shedWidth} x ${requestScope.carport.shedLength}
                            mtr.</p>
                    </c:if>
                    <h5>Matrialer: </h5>
                    <c:forEach var="material" items="${requestScope.bom.list}">
                        <c:if test="${material.materialCategoryId > 0}"><p>${material.name}</p></c:if>
                    </c:forEach>
                    <br>
                    <p>Inkl. søm, skruer og hulbånd.</p>
                    <c:if test="${requestScope.message != null}">
                        <p><b>besked fra sælger: ${requestScope.message}</b></p></c:if>
                    <c:if test="${requestScope.carport.name != null}">
                        <h5>Pris: ${requestScope.bom.priceString} DKK</h5>
                    </c:if>
                    <c:if test="${requestScope.carport.name == null}">
                        <h5>Pris: Afventer tilbud</h5>
                    </c:if>
                </div>
                <div class="col-4 offset-1">
                        ${requestScope.svg}
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>



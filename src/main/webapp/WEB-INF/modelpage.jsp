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
        Carport ${requestScope.carport.name}
        <c:if test="${carport.width >= 400}">dobbelt</c:if>
            <c:if test="${carport.width < 400}">enkelt</c:if>
        ${requestScope.carport.width}cm x ${requestScope.carport.length}cm
            <c:if test="${carport.roofAngle == 0}"> med fladt tag</c:if>
            <c:if test="${carport.roofAngle > 0}">med høj rejsning</c:if>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="container my-5">
            <div class="row">
                <div class="row col-8">
                    <img src="<c:url  value='/data/${carport.name}.png'/>" alt="carport"/>
                </div>
                <div class="col-4">
                    <div class="mb-4">
                        <h2 class="text-uppercase">Carport ${requestScope.carport.name}
                            <c:if test="${carport.width >= 400}">dobbelt</c:if>
                            <c:if test="${carport.width < 400}">enkelt</c:if>
                                ${requestScope.carport.width}cm x ${requestScope.carport.length}cm
                            <c:if test="${carport.roofAngle == 0}"> med fladt tag</c:if>
                            <c:if test="${carport.roofAngle > 0}">med høj rejsning</c:if></h2>
                        <h4 class="alert-success font-weight-bold text-uppercase">PRIS: ${requestScope.bom.defaultPrice},- DKK</h4>
                        <hr>
                        <p>${requestScope.carport.width} x ${requestScope.carport.length} mtr.</p>
                        <p>Stolpe: 100 x 100 mm. ru trykimprægneret.</p>
                        <p>Rem: 45 x 145 mm spærtræ.</p>
                        <p>Spær: 45 x 95 mm. reglar.</p>
                        <p>Stern: 25 x 150 mm. ru trykimprægneret.</p>
                        <p>Tag: PLASTMO ecolite tagplade.</p>
                        <p>Inkl. søm, skruer og hulbånd.</p>
                        <p>Sælges som standardmodel.</p>
                        <p>Se i øvrigt tilkøbspakker.</p>
                        <c:if test="${sessionScope.user == null}">
                            <div class="alert-info p-2 mt-2"><a href="${pageContext.request.contextPath}/fc/registerpage">Klik her
                                for at oprette dig som bruger.</a></div>
                        </c:if>
                        <form name="sendQuery" action="${pageContext.request.contextPath}/fc/querypage" method="post">
                            <input type="hidden" name="queriedId" value="${requestScope.carport.id}"/>
                            <button class="btn btn-success mt-2" type="submit" <c:if test="${sessionScope.user == null}">disabled="disabled"</c:if> name="submitQuery"
                                    value="${requestScope.carport.name}">Send forespørgsel
                            </button>
                        </form>
                    </div>
                    <hr>
                    <div class="p-4">
                        <img class="img-fluid" src="<c:url value='/data/SVGD.png'/>"
                             alt="carport ${requestscope.carport.name}"/>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>

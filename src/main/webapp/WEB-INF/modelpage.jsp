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
            <h2 class="display-4"> ${requestScope.carport.name}
                <c:if test="${carport.length >= 400}">dobbelt</c:if>
                <c:if test="${carport.length < 400}">enkelt</c:if> carport</h2>
            <div class="row mt-4">
                <hr class="border-white">
                <div class="col-5">
                    <div class="mb-4">
                        <p>${requestScope.carport.width} x ${requestScope.carport.length} mtr.</p>
                        <c:forEach var="material" items="${requestScope.bom.list}">
                            <c:if test="${material.materialCategoryId > 0}"><p>${material.name}</p></c:if>
                        </c:forEach>
                        <p>Inkl. søm, skruer og hulbånd.</p>
                        <p>Sælges som standardmodel.</p>
                        <br>
                        <h4 class="text-uppercase">PRIS: ${requestScope.bom.priceString} DKK</h4>
                        <form name="sendQuery" action="${pageContext.request.contextPath}/fc/querypage" method="post">
                            <input type="hidden" name="queriedId" value="${requestScope.carport.id}"/>
                            <button class="btn btn-success mt-2" type="submit"
                                    <c:if test="${sessionScope.user == null}">disabled="disabled"</c:if>
                                    name="submitQuery"
                                    value="${requestScope.carport.name}">Send forespørgsel
                            </button>
                        </form>
                    </div>
                    <c:if test="${sessionScope.user == null}">
                        <div class="alert-info p-3 mt-2 rounded">Inden du bestiller: <a class="alert-info"
                                                                                        href="${pageContext.request.contextPath}/fc/registerpage">opret
                            bruger</a> eller <a class="alert-info"
                                                href="${pageContext.request.contextPath}/fc/loginpage">login</a></div>
                    </c:if>
                </div>
                <div class="row col-6 offset-1">
                    <img class="img-fluid" src="<c:url  value='/data/${carport.name}.png'/>"
                         alt="carport"/>
                    <hr class="border-white">
                        ${requestScope.svg}
                    <!--<img class="img-fluid img-thumbnail" src="<c:url value='/data/SVGD.png'/>"
                         alt="carport ${requestscope.carport.name}"/>-->
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>

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
            <c:if test="${carport.roofAngle != 0}">med høj rejsning</c:if>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div style="width: 33%; padding: 5px; float: left;">
            <img src="<c:url value='/data/CAR01H.png'/>" alt="carport"/>
            <br><br><br><br><br><br><br><br><br><br><br>
        </div>

        <div style="padding: 5px;width: 45; float: left;">
            <p><br>${requestScope.carport.width} x ${requestScope.carport.length} mtr.<br>
                Stolpe: 100 x 100 mm. ru trykimprægneret.<br>
                Rem: 45 x 145 mm spærtræ.<br>
                Spær: 45 x 95 mm. reglar.<br>
                Stern: 25 x 150 mm. ru trykimprægneret.<br>
                Tag: PLASTMO ecolite tagplade.<br>
                Inkl. søm, skruer og hulbånd.<br>
                Sælges som standardmodel.<br>
                Se i øvrigt tilkøbspakker.</p>
        </div>

        <div style="width: 100;height: auto;padding: 5px; float: left;">
            <img src="<c:url value='/data/SVGD.png'/>" width=500 height=auto alt=Carport model ${requestscope.name}/>
        </div>
        <div style="padding: 5px;">

            <form name="sendforespørgsel" action="${pageContext.request.contextPath}/fc/querypage" method="post">
                <input class="btn btn-succes" type="submit" value="Send forespørgsel">
            </form>
        </div>

        <div class="container my-5">
        <div class="row">
            <div class="row col-9 m-n2 p-n2">
            <div class="col-3">
                <div class="mb-4">

                </div>
                <hr>
                <div class="bg-info p-4"><a href="${pageContext.request.contextPath}/fc/custom">
                    <h2 class="display-4">Klik her for byg-selv-formular</h2></a>
                </div>
            </div>
        </div>
        </div>
        </div>
    </jsp:body>
</t:genericpage>

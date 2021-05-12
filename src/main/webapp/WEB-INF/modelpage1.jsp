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
        <h4>Carport model CAR01<br>Enkelt model
            uden reskabsrum</h4>
<%--        <div class="w-25 pl-4 rounded-1"><img class="img-circle border-white img-fluid" src="<c:url value='/data/CAR01.png'/>"alt="kids"/></div>--%>
<%--        <img src="${pageContext.request.contextPath}${CAR01.png}"/>--%>
        <img src="<c:url value='/data/CAR01.png'/>" alt=.../>
        <div style="float: right;">
            <form class="mt-4" method="post" action="${pageContext.request.contextPath}/fc/modelpage1">
                <fieldset>
                    <legend>Byg din nørdede garage/carport her</legend>
                    <label class="p-1" for="topping"><Strong>Bredde:</Strong></label>
                    <select class="p-0" name="width" id="width">
                        <c:forEach var="width" items="${applicationScope.width}">
                            <option value="${carport.id}"
                                    selected="${requestScope.get(carport.name)}">${carport.name}</option>
                        </c:forEach>
                    </select>

                    <label class="p-1" for="noget andet"><strong>noget andet:</strong></label>
                    <select class="p-0" name="noget andet" id="noget andet">
                        <c:forEach var="noget andet" items="${applicationScope.bottomList}">
                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>
                        </c:forEach>
                    </select>

                    <label class="p-1" for="noget andet"><strong>noget andet:</strong></label>
                    <select class="p-0" name="noget andet" id="noget andet">
                        <c:forEach var="noget andet" items="${applicationScope.bottomList}">
                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>
                        </c:forEach>
                    </select>
                </fieldset>
            </form>
        </div>
        <p>Mål: 3,00 x 4,80 mtr. Højde 2,25 mtr.
            Dimensioner:<br>
            Stolpe: 100 x 100 mm. ru trykimprægneret.<br>
            Rem: 45 x 145 mm spærtræ.<br>
            Spær: 45 x 95 mm. reglar.<br>
            Stern: 25 x 150 mm. ru trykimprægneret.<br>
            Tag: PLASTMO ecolite tagplade.<br>
            Inkl. søm, skruer og hulbånd.<br>
            Sælges som standardmodel.<br>
            Se i øvrigt tilkøbspakker.</p>



    </jsp:body>
</t:genericpage>

<%--        <div style="margin-top: 5em;">--%>
<%--            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">--%>
<%--                <div class="row mb-3">--%>
<%--                    <label class="" for="name">Name</label>--%>
<%--                    <div class="col-sm-4">--%>
<%--                        <input id="name" class="form-control" type="name" name="name" value="${param.name}"  placeholder="Skriv navn">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <input class="btn btn-primary" type="submit" type="submit" value="Submit">--%>
<%--            </form>--%>

<%--            <c:if test="${requestScope.error != null }">--%>
<%--                <p style="color:red">--%>
<%--                        ${requestScope.error}--%>
<%--                </p>--%>
<%--            </c:if>--%>
<%--        </div>--%>


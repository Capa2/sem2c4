<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Carporte
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="container my-5">
            <div class="row">
                <div class="row col-9 m-n2 p-n2">
                    <c:forEach var="carport" items="${requestScope.models}">
                        <div class="col-3">
                            <div class="m-2 w-100 pt-2 rounded shadow border-2 border-top border-white"
                                 style="background:url('<c:url
                                         value="/data/ep_naturalwhite.png"/>'); background-repeat:repeat;">
                                <h4 style="font-weight: 600;" class="text-center text-uppercase">${carport.name}</h4>
                                <img style="height: 125px"
                                     class="img-fluid w-100 mt-2 mb-4 mx-n2 border-top border-bottom border-white"
                                     src="<c:url  value='/data/${carport.name}.png'/>"
                                     alt="carport"/>
                                <div style="font-weight:400;" class="px-4 text-center">
                                    <p> ${carport.width} x ${carport.length} mtr.
                                    </p>
                                    <p>
                                        <c:if test="${carport.length >= 400}">Dobbelt</c:if>
                                        <c:if test="${carport.length < 400}">Enkelt</c:if>
                                        carport
                                    </p>
                                    <p>
                                        <c:if test="${carport.roofAngle == 0}">Fladt tag</c:if>
                                        <c:if test="${carport.roofAngle > 0}">Tag med rejsning</c:if>
                                    </p>
                                </div>
                                <div class="text-center">
                                    <p style="font-weight: 600" class="lead">${requestScope.bomBuilder.getPriceString(carport.id)} DKK</p>
                                    <a href="${pageContext.request.contextPath}/fc/modelpage?model=${carport.id}">
                                        <button class="btn btn-success rounded-0 rounded-top">Læs mere</button>
                                    </a></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-3">
                    <div class="mb-4">
                        <form name="filter" action="${pageContext.request.contextPath}" method="post">
                            <label class="my-2" for="roof">Tag:</label>
                            <select class="my-2 w-50" id="roof" name="roof">
                                <option value="flat">Fladt</option>
                                <option value="angled">Høj rejsning</option>
                            </select>
                            <br>
                            <label class="my-2" for="type">Type</label>
                            <select class="my-2 w-50" id="type" name="type">
                                <option value="single">Enkelt</option>
                                <option value="double">Dobbelt</option>
                            </select>
                            <br>
                            <label class="my-2" for="shed">Skur</label>
                            <select class="my-2 w-50" id="shed" name="shed">
                                <option value="shed">Med skur</option>
                                <option value="noShed">Uden skur</option>
                            </select>
                            <button type="submit" class="mt-4 btn btn-secondary w-100" name="filter" value="filter">
                                Filtrer
                            </button>
                        </form>
                    </div>
                    <hr>
                    <div class="bg-info p-4 rounded text-center">
                        <a href="${pageContext.request.contextPath}/fc/quickbuildpage">
                            <h2 class="display-4">Klik her for byg-selv-formular</h2></a>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
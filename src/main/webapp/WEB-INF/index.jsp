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
        <div>
            <div class="container my-5">
                <div class="row">
                    <div class="row col-9 m-n2 p-n2">
                        <c:forEach var="carport" items="${applicationScope.models}">
                            <div class="w-25">
                                <div class="w-100 m-2  pt-2 rounded shadow border-2 border-top border-white"
                                     style="background:url('<c:url
                                             value="/data/ep_naturalwhite.png"/>'); background-repeat:repeat;">
                                    <h4 class="text-center">${carport.name}</h4>
                                    <img style="height: 125px"
                                         class="img-fluid w-100 my-2 mx-n2 border-top border-bottom border-white"
                                         src="<c:url  value='/data/${carport.name}.png'/>"
                                         alt="carport"/>
                                    <div class="card-body">
                                        <p> ${carport.width} x ${carport.length} mtr.
                                        </p>
                                        <p>Type:
                                            <c:if test="${carport.width >= 400}">dobbelt</c:if>
                                            <c:if test="${carport.width < 400}">enkelt</c:if>
                                        </p>
                                        <p>Tag:
                                            <c:if test="${carport.roofAngle == 0}">fladt</c:if>
                                            <c:if test="${carport.roofAngle > 0}">høj rejsning</c:if>
                                        </p>
                                        <p class="text-bold lead align-self-center">10399,- kr.</p>
                                    </div>
                                    <div class="text-center">
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
                        <div class="bg-info p-4 rounded"><a href="${pageContext.request.contextPath}/fc/custom">
                            <h2 class="display-4">Klik her for byg-selv-formular</h2></a>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a></p>
            </c:if>


        </div>

    </jsp:body>
</t:genericpage>
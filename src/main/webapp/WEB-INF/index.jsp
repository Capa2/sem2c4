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

                            <div class="col-3 m-2  p-2 rounded border border-2 border-secondary"><h4 class="h4">
                                    ${carport.name}</h4>
                                <img class="img-fluid rounded w-100 my-2 mx-n2"
                                     src="https://www.polarhus.dk/cache/0d1299f4da2d5e4722cdbf2c7bd7f9f0e498828c_780x520_c.jpg"
                                     alt="carport"/>
                                <p> ${carport.width} x ${carport.length} mtr.</p>
                                <p>Type: <c:if test="${carport.width >= 400}">dobbelt</c:if>
                                    <c:if test="${carport.width < 400}">enkelt</c:if></p>
                                <p>Tag: <c:if test="${carport.roofAngle == 0}">fladt</c:if>
                                    <c:if test="${carport.roofAngle != 0}">høj rejsning</c:if></p>
                                <p><strong>399,- kr.</strong></p>
                                <a href="${pageContext.request.contextPath}/fc/modelpage?model=${carport.id}">
                                    <button class="btn btn-success float-right">Læs mere</button>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-3">
                        <div class="mb-4">
                            <form>
                                <label class="my-2" for="1">Vælg noget andet:</label>
                                <select class="my-2" id="1" name="valg">
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                </select>
                                <label class="my-2" for="2">Vælg noget andet:</label>
                                <select class="my-2" id="2" name="valg">
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                </select>
                                <label class="my-2" for="3">Vælg noget andet:</label>
                                <select class="my-2" id="3" name="valg">
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                </select>
                                <label class="my-2" for="4">Vælg noget andet:</label>
                                <select class="my-2" id="4" name="valg">
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                </select>
                                <label class="my-2" for="5">Vælg noget andet:</label>
                                <select class="my-2" id="5" name="valg">
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                    <option value="valgbart">valgbart</option>
                                </select>
                                <button class="mt-4 btn btn-secondary w-100" name="Filtrer" value="filter">Filtrer
                                </button>
                            </form>
                        </div>
                        <hr>
                        <div class="bg-info p-4"><a href="${pageContext.request.contextPath}/fc/custom">
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
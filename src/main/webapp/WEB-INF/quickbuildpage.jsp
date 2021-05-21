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
                Quick-byg carport</h2>
            <div class="row mt-4">
                <hr class="border-white">
                <c:if test="${sessionScope.user == null}">
                    <div class="alert-info p-3 mt-2 rounded">Inden du bestiller: <a class="alert-info"
                                                                                    href="${pageContext.request.contextPath}/fc/registerpage">opret
                        bruger</a> eller <a class="alert-info"
                                            href="${pageContext.request.contextPath}/fc/loginpage">login</a></div>
                </c:if>
                <div class="col-5">
                    <div class="mb-4">
                        <form class="form" name="quickbuild" action="${pageContext.request.contextPath}/fc/querypage"
                              method="post">
                            <div class="form-group my-2">
                                <label class="" for="width">Bredde, carport</label>
                                <input class="form-control" id="width" name="width" placeholder="600" type="number"
                                       min="50" max="2500"/> <small class="form-text text-muted">centimeter</small>
                            </div>
                            <div class="form-group my-2">
                                <label for="length">Længde, carport</label>
                                <input class="form-control" id="length" name="length" placeholder="500" type="number"
                                       min="50" max="2500"/><small class="form-text text-muted">centimeter</small>
                            </div>
                            <div class="form-group my-2">
                                <label for="width">Bredde, skur</label>
                                <input class="form-control" id="shedWidth" name="shedWidth" placeholder="550"
                                       type="number" min="0" max="2500"/>
                                <small class="form-text text-muted">centimeter</small>
                            </div>
                            <div class="form-group my-2">
                                <label for="length">Længde, skur</label>
                                <input class="form-control" id="shedLength" name="shedLength" placeholder="200"
                                       type="number" min="0" max="2500"/>
                                <small class="form-text text-muted">centimeter</small>
                            </div>
                            <div class="form-group my-2">
                                <label for="roof">Tag</label>
                                <select class="form-control" id="roof" name="roof">
                                    <option>Fladt</option>
                                    <option>Rejst</option>
                                </select>
                            </div>
                            <div class="form-group my-2">
                                <label for="message">Besked</label>
                                <textarea class="form-control" id="message" name="message" rows="3"></textarea>
                                <small id="note" class="form-text text-muted">(Valgfrit) besked ved henvendelse.</small>
                            </div>
                            <input type="submit" class="btn btn-success my-2"
                                   type="submit" name="submitCustom" value="Send forespørgsel"
                                   <c:if test="${sessionScope.user == null}">disabled="disabled"</c:if> />
                        </form>
                    </div>

                </div>
                <div class="row col-6 offset-1">

                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>

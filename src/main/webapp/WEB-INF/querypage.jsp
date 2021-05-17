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
        <h3>Forespørgsel på model CAR01H ${requestscope.name}</h3>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <img src="<c:url value='/data/CAR01H.png'/>" style="padding: 10px;border: 1px solid;float: left;" class="img-fluid. max-width: 100%;" alt=Carport model ${requestscope.name}/>
        <%--            </div>--%>

        <%--make colums--%>
        <p style="font-family:'Times New Roman';border:1px solid; padding:5px;float: left;" width="300px;" height="auto">
            Mål: 3,00 x 4,80 mtr. Højde 2,25 mtr.<br>
            Dimensioner:<br>
            Stolpe: 100 x 100 mm. ru trykimprægneret.<br>
            Rem: 45 x 145 mm spærtræ.<br>
            Spær: 45 x 95 mm. reglar.<br>
            Stern: 25 x 150 mm. ru trykimprægneret.<br>
            Tag: PLASTMO ecolite tagplade.<br>
            Inkl. søm, skruer og hulbånd.<br>
            Sælges som standardmodel.<br>
            Se i øvrigt tilkøbspakker.</p>



        <img src="<c:url value='/data/SVGD.png'/>" style="width: 500px; height: auto;border: 1px solid;float: left;" alt=Carport model ${requestscope.name}/>

        <%--            Enkelt model uden reskabsrum</h4>--%>
        <%--        <div class="w-25 pl-4 rounded-1"><img class="img-circle border-white img-fluid" src="<c:url value='/data/CAR01.png'/>"alt="kids"/></div>--%>
        <%--        <img src="${pageContext.request.contextPath}${CAR01.png}"/>--%>

<%--        <div style="padding: 5px;">--%>
<%--            <form name="sendforespørgsel" action="${pageContext.request.contextPath}/fc/querypage" method="get">--%>
<%--                    &lt;%&ndash;                <div class="row mb-3">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <label class="" for="name">Send forespørgsel</label>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <div class="col-sm-4">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input id="name" class="form-control" type="name" name="name" value="${param.name}"  placeholder="Send forespørgsel">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                <input style="font-family:'Times New Roman';color: red; width: 200px; align: left;padding: 10px;" class="btn btn-dark" type="submit"--%>
<%--                       type="submit" value="Gå tilbage">--%>
<%--            </form>--%>
<%--                &lt;%&ndash;            flashy fast lav pris skilt&ndash;%&gt;--%>
<%--        </div>--%>

        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" value="${sessionScope.user.email}">
                </div>
            </div>

            <div class="form-group">
                <label for="name">Navn</label>
                <input type="text" class="form-control" id="name" value="${sessionScope.user.name}">
            </div>

            <div class="form-group">
                <label for="address">Adresse</label>
                <input type="text" class="form-control" id="address" value="${sessionScope.user.street}">
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="city">By</label>
                    <input type="text" class="form-control" id="city" value="${sessionScope.user.town}">
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="zipCode">Postnummer</label>
                        <input type="text" class="form-control" id="zipCode" value="${sessionScope.user.zipCode}">
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="zipCode">Model</label>
                            <input type="text" class="form-control" id="zipCode" value="${sessionScope}">
                        </div>

<%--                <div class="form-group col-md-4">--%>
<%--                    <label for="inputState">Postnummer</label>--%>
<%--                    <select id="inputState" class="form-control">--%>
<%--                        <option selected>Choose...</option>--%>
<%--                        <option>...</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="form-group col-md-2">--%>
<%--                    <label for="inputZip">Forespørgsel på garage CAR01H</label>--%>
<%--                    <input type="text" class="form-control" id="inputZip">--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Jeg vil gerne have tilbud på en tømrer
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Send</button>
        </form>


        <%--        <div style="float: right;">--%>
        <%--            <form class="mt-4" method="post" action="${pageContext.request.contextPath}/fc/modelpage1">--%>
        <%--                <fieldset>--%>
        <%--                    <legend>Byg din nørdede garage/carport her</legend>--%>
        <%--                    <label class="p-1" for="topping"><Strong>Bredde:</Strong></label>--%>
        <%--                    <select class="p-0" name="width" id="width">--%>
        <%--                        <c:forEach var="width" items="${applicationScope.width}">--%>
        <%--                            <option value="${carport.id}"--%>
        <%--                                    selected="${requestScope.get(carport.name)}">${carport.name}</option>--%>
        <%--                        </c:forEach>--%>
        <%--                    </select>--%>

        <%--                    <label class="p-1" for="nogetandet"><strong>nogetandet:</strong></label>--%>
        <%--                    <select class="p-0" name="nogetandet" id="nogetandet">--%>
        <%--                        <c:forEach var="noget andet" items="${applicationScope.bottomList}">--%>
        <%--                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>--%>
        <%--                        </c:forEach>--%>
        <%--                    </select>--%>

        <%--                    <label class="p-1" for="nogetandet"><strong>noget andet:</strong></label>--%>
        <%--                    <select class="p-0" name="nogetandet" id="nogetandet">--%>
        <%--                        <c:forEach var="nogetandet" items="${applicationScope.nogetandet}">--%>
        <%--                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>--%>
        <%--                        </c:forEach>--%>
        <%--                    </select>--%>
        <%--                </fieldset>--%>
        <%--            </form>--%>
        <%--        </div>--%>

        <%--                <table style="width: 45%;padding: 5px">--%>
        <%--                    <tr>--%>
        <%--                        <p><SPAN STYLE="font-family:'Times New Roman'">--%>
        <%--                            <br>Mål: 3,00 x 4,80 mtr. Højde 2,25 mtr.<br>--%>
        <%--                            Dimensioner:<br>--%>
        <%--                            Stolpe: 100 x 100 mm. ru trykimprægneret.<br>--%>
        <%--                            Rem: 45 x 145 mm spærtræ.<br>--%>
        <%--                            Spær: 45 x 95 mm. reglar.<br>--%>
        <%--                            Stern: 25 x 150 mm. ru trykimprægneret.<br>--%>
        <%--                            Tag: PLASTMO ecolite tagplade.<br>--%>
        <%--                            Inkl. søm, skruer og hulbånd.<br>--%>
        <%--                            Sælges som standardmodel.<br>--%>
        <%--                            Se i øvrigt tilkøbspakker.</SPAN></p>--%>
        <%--                    </tr>--%>
        <%--                </table>--%>

        <%--        <div style="margin-top: 2em;">--%>
        <%--            <form name="sendForespørgsel" action="${pageContext.request.contextPath}/fc/query" method="POST">--%>
        <%--                    &lt;%&ndash;                <div class="row mb-3">&ndash;%&gt;--%>
        <%--                    &lt;%&ndash;                    <label class="" for="name">Send forespørgsel</label>&ndash;%&gt;--%>
        <%--                    &lt;%&ndash;                    <div class="col-sm-4">&ndash;%&gt;--%>
        <%--                    &lt;%&ndash;                        <input id="name" class="form-control" type="name" name="name" value="${param.name}"  placeholder="Send forespørgsel">&ndash;%&gt;--%>
        <%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
        <%--                    &lt;%&ndash;                </div>&ndash;%&gt;--%>
        <%--                <input class="btn btn-primary" type="submit" type="submit" value="Send forespørgsel">--%>
        <%--            </form>--%>

        <%--                &lt;%&ndash;            <c:if test="${requestScope.error != null }">&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <p style="color:red">&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                        ${requestScope.error}&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                </p>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;            </c:if>&ndash;%&gt;--%>
        <%--        </div>--%>


    </jsp:body>
</t:genericpage>

<%--<%@page contentType="text/html" pageEncoding="UTF-8" %>--%>
<%--<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<t:genericpage>--%>
<%--    <jsp:attribute name="header">--%>

<%--    </jsp:attribute>--%>

<%--    <jsp:attribute name="footer">--%>
<%--        <c:set var="addHomeLink" value="${false}" scope="request"/>--%>
<%--    </jsp:attribute>--%>

<%--    <jsp:body>--%>
<%--        <h4>Carport model ${requestscope.name}<br>--%>
<%--&lt;%&ndash;            Enkelt model uden reskabsrum</h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="w-25 pl-4 rounded-1"><img class="img-circle border-white img-fluid" src="<c:url value='/data/CAR01.png'/>"alt="kids"/></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <img src="${pageContext.request.contextPath}${CAR01.png}"/>&ndash;%&gt;--%>
<%--        <div style="float: right;">--%>
<%--        <img src="<c:url value='/data/CAR01.png'/>" alt=.../>--%>
<%--        </div>--%>
<%--            <form class="mt-4" method="post" action="${pageContext.request.contextPath}/fc/modelpage1">--%>
<%--                <fieldset>--%>
<%--                    <legend>Byg din nørdede garage/carport her</legend>--%>
<%--                    <label class="p-1" for="topping"><Strong>Bredde:</Strong></label>--%>
<%--                    <select class="p-0" name="width" id="width">--%>
<%--                        <c:forEach var="width" items="${applicationScope.width}">--%>
<%--                            <option value="${carport.id}"--%>
<%--                                    selected="${requestScope.get(carport.name)}">${carport.name}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>

<%--                    <label class="p-1" for="nogetandet"><strong>nogetandet:</strong></label>--%>
<%--                    <select class="p-0" name="nogetandet" id="nogetandet">--%>
<%--                        <c:forEach var="noget andet" items="${applicationScope.bottomList}">--%>
<%--                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>

<%--                    <label class="p-1" for="nogetandet"><strong>noget andet:</strong></label>--%>
<%--                    <select class="p-0" name="nogetandet" id="nogetandet">--%>
<%--                        <c:forEach var="nogetandet" items="${applicationScope.nogetandet}">--%>
<%--                            <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </fieldset>--%>
<%--            </form>--%>

<%--        <p> <br>Mål: 3,00 x 4,80 mtr. Højde 2,25 mtr.<br>--%>
<%--            Dimensioner:<br>--%>
<%--            Stolpe: 100 x 100 mm. ru trykimprægneret.<br>--%>
<%--            Rem: 45 x 145 mm spærtræ.<br>--%>
<%--            Spær: 45 x 95 mm. reglar.<br>--%>
<%--            Stern: 25 x 150 mm. ru trykimprægneret.<br>--%>
<%--            Tag: PLASTMO ecolite tagplade.<br>--%>
<%--            Inkl. søm, skruer og hulbånd.<br>--%>
<%--            Sælges som standardmodel.<br>--%>
<%--            Se i øvrigt tilkøbspakker.</p>--%>

<%--        <div style="margin-top: 2em;">--%>
<%--            <form name="sendforespørgsel" action="${pageContext.request.contextPath}/fc/querypage" method="POST">--%>
<%--&lt;%&ndash;                <div class="row mb-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label class="" for="name">Send forespørgsel</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <div class="col-sm-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input id="name" class="form-control" type="name" name="name" value="${param.name}"  placeholder="Send forespørgsel">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                <input class="btn btn-primary" type="submit" type="submit" value="Send forespørgsel">--%>
<%--            </form>--%>

<%--&lt;%&ndash;            <c:if test="${requestScope.error != null }">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <p style="color:red">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        ${requestScope.error}&ndash;%&gt;--%>
<%--&lt;%&ndash;                </p>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </c:if>&ndash;%&gt;--%>
<%--        </div>--%>


<%--    </jsp:body>--%>
<%--</t:genericpage>--%>



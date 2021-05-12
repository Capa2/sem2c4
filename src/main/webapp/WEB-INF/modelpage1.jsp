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
        <h4>Carport model enkelt uden reskabsrum</h4>
        <img src="${pageContext.request.contextPath}${CAR01.png}"/>

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


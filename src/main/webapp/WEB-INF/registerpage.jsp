<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="name">Name:</label>
                    <div class="col-sm-4">
                        <input id="name" class="form-control" type="name" name="name" value="${param.name}"  placeholder="Skriv navn">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="email">Email:</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="Enter a valid email">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="phone">Phone:</label>
                    <div class="col-sm-4">
                        <input id="phone" class="form-control" type="phone" name="phone" value="${param.phone}"  placeholder="Phone">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="street">Vej_nr:</label>
                    <div class="col-sm-4">
                        <input id="street" class="form-control" type="text" name="street" value="${param.street}" placeholder="Vej og husnummer">
                    </div>
                </div>

                <div class="row mb-3">
                    <%--@declare id="city"--%><label class="col-sm-2 col-form-label" for="city">By:</label>
                    <div class="col-sm-4">
                        <input id="By" class="form-control" type="text" name="city" value="${param.city}" placeholder="By">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="zipCode">Postnummer:</label>
                    <div class="col-sm-4">
                        <input id="Postnummer" class="form-control" type="text" name="zipCode" value="${param.zipCode}" placeholder="Postnummer">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="password1">Password:</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control" type="password" name="password1"  value="${param.password1}"  placeholder="Enter your password">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="password2">Igen:</label>
                    <div class="col-sm-4">
                        <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}"  placeholder="Repeat the password">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>



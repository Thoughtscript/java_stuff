<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html ng-app='angularApp'>
<head>
    <title>Spring Secured Sockets</title>
    <link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/vendor/angular/angular.min.js" />"></script>
    <script src="<c:url value="/resources/vendor/angular/angular-route.min.js" />"></script>

    <script src="<c:url value="/resources/scripts/app.js" />"></script>
    <script src="<c:url value="/resources/scripts/services/SocketService.js" />"></script>
    <script src="<c:url value="/resources/scripts/factories/Form.js" />"></script>
    <script src="<c:url value="/resources/scripts/factories/PetFactory.js" />"></script>
    <script src="<c:url value="/resources/scripts/controllers/indexController.js" />"></script>
    <script src="<c:url value="/resources/scripts/controllers/loginController.js" />"></script>
    <script src="<c:url value="/resources/scripts/controllers/socketController.js" />"></script>
    <script src="<c:url value="/resources/scripts/controllers/successController.js" />"></script>
    <script src="<c:url value="/resources/scripts/routes/router.js" />"></script>
</head>
<body ng-controller="loginController">
<c:set var="context" scope="session" value="${pageContext.request.contextPath}"/>
<h1>Angular Login Form</h1><br/>
<h2>(This is a working Angular form but it does not automatically redirect on success)</h2><br/>
<form>
    <table>
        <tr>
            <td>User:</td>
            <td><input id="userField" type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input id="passwordField" type="password" name="password"/></td>
        </tr>
        <tr>
            <td>
                <button ng-click='postForm("${context}")'>Submit</button>
            </td>
        </tr>
    </table>
</form>

<!-- Must match the endpoint specified in security config -->
<h1>JSP Login Form</h1><br/>
<h2>(This one does)</h2><br/>
<form name='f' action="authenticate" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit"/></td>
        </tr>
    </table>
</form>

<!-- CSRF Token -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
</head>
<body>

    <div style="float: left">
        <h3>Регистрация</h3>
        <form:form commandName="user" action="register" method="post">
            <p><form:input path="username" type="text" name="j_username" placeholder="Username" /></p>
            <p><form:input path="password" type="password" name="j_password" placeholder="Password" /></p>

            <p class="submit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" name="commit" value="Зарегистрироваться"></p>
        </form:form>
    </div>

</body>
</html>
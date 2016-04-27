<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>
</head>
<body>

<h3>
    <spring:message code="label.form.title" />
</h3>
<form:form modelAttribute="userDto" action="register" method="POST" enctype="UTF-8">
    <p>
        <label><spring:message code="label.user.firstName" />
        <br>
        <form:input path="firstName" value="" />
        <form:errors path="firstName" element="div" cssStyle="color: red" />
    </p>
    <p>
        <label><spring:message code="label.user.lastName" />
        <br>
        <form:input path="lastName" value="" />
        <form:errors path="lastName" element="div" cssStyle="color: red" />
    </p>
    <p>
        <label><spring:message code="label.user.login" />
        <br>
        <form:input path="login" value="" />
        <form:errors path="login" element="div" cssStyle="color: red" />
    </p>
    <p>
        <label><spring:message code="label.user.email" />
        <br>
        <form:input path="email" value="" />
        <form:errors path="email" element="div" cssStyle="color: red" />
    </p>
    <p>
        <label><spring:message code="label.user.password" />
        <br>
        <form:input path="password" value="" type="password" id="name" />
        <form:errors path="password" element="div" cssStyle="color: red; width: 350px;" />
    </p>
    <p>
        <label><spring:message code="label.user.confirmPass" />
        <br>
        <form:input path="matchingPassword" value="" type="password" />
        <form:errors element="div" cssStyle="color: red" />
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Отправить">
    <a href="<c:url value="/registerForm" />">Сбросить</a>
</form:form>
<br>
<a href="<c:url value="/auth" />">
    <spring:message code="label.form.loginLink" />
</a>

</body>
</html>
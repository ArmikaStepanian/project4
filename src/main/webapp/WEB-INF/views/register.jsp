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
    <spring:message code="label.form.title"></spring:message>
</h3>
<form:form modelAttribute="userDto" method="POST" enctype="utf8">
    <p>
        <label><spring:message code="label.user.firstName"></spring:message></label>
        <br>
        <form:input path="firstName" value="" />
        <form:errors path="firstName" element="div"/>
    </p>
    <p>
        <label><spring:message code="label.user.lastName"></spring:message></label>
        <br>
        <form:input path="lastName" value="" />
        <form:errors path="lastName" element="div" />
    </p>
    <p>
        <label><spring:message code="label.user.login"></spring:message></label>
        <br>
        <form:input path="login" value="" />
        <form:errors path="login" element="div" />
    </p>
    <p>
        <label><spring:message code="label.user.email"></spring:message></label>
        <br>
        <form:input path="email" value="" />
        <form:errors path="email" element="div" />
    </p>
    <p>
        <label><spring:message code="label.user.password"></spring:message></label>
        <br>
        <form:input path="password" value="" type="password" />
        <form:errors path="password" element="div" />
    </p>
    <p>
        <label><spring:message code="label.user.confirmPass"></spring:message></label>
        <br>
        <form:input path="matchingPassword" value="" type="password" />
        <form:errors element="div" />
    </p>
    <button type="submit"><spring:message code="label.form.submit"></spring:message></button>
</form:form>
<br>
<a href="<c:url value="/auth" />">
    <spring:message code="label.form.loginLink"></spring:message>
</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
</head>
<body>
<H1>
    <spring:message code="label.form.title"></spring:message>
</H1>
<form:form modelAttribute="userDto" method="POST" enctype="utf8">
    <br>
    <tr>
        <td><label><spring:message code="label.user.firstName"></spring:message>
        </label>
        </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <tr>
        <td><label><spring:message code="label.user.lastName"></spring:message>
        </label>
        </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <tr>
        <td><label><spring:message code="label.user.email"></spring:message>
        </label>
        </td>
        <td><form:input path="email" value="" /></td>
        <form:errors path="email" element="div" />
    </tr>
    <tr>
        <td><label><spring:message code="label.user.password"></spring:message>
        </label>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <tr>
        <td><label><spring:message code="label.user.confirmPass"></spring:message>
        </label>
        </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    <button type="submit"><spring:message code="label.form.submit"></spring:message>
    </button>
</form:form>
<br>
<a href="<c:url value="products.jsp" />">
    <spring:message code="label.form.loginLink"></spring:message>
</a>

    <%--<div style="float: left">
        <h3>Регистрация</h3>
        <form:form commandName="user" action="register" method="post">
            <p><form:input path="username" type="text" placeholder="Username" /></p>
            <p><form:input path="password" type="password" placeholder="Password" /></p>

            <p class="submit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" name="commit" value="Зарегистрироваться"></p>
        </form:form>
    </div>--%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Авторизация</title>
</head>
<body>
<h3>Авторизация</h3>
<form action="<c:url value='j_spring_security_check' />" method="post">
    <p><input type="text" name="j_username" placeholder="Login" /></p>
    <p><input type="password" name="j_password" placeholder="Password" /></p>
    <p class="remember_me">
        <label>
            <input type="checkbox" name="remember-me" id="remember-me">
            Запомнить
        </label>
    </p>
    <p class="submit">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" name="commit" value="Login"></p>
    <c:if test="${not empty param.login_failed}">
        <div style="color: red">
            Неверные пользователь <br> и / или пароль
        </div>
    </c:if>
</form>

<p>Если вы впервые на сайте, то можете
    <a href="<c:url value="/registerForm" />" >зарегистрироваться</a>
</p>

<a href="<c:url value="/" />">Вернуться на главную страницу</a>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>500</title>
</head>
<body>

<h4>Ошибочка номер 500.</h4>
<p>Такой страницы не существует.

Вы перешли по ссылке, которая указывает на несуществующую страницу.</p>

<a href="<c:url value="/" />">
    Вернуться на главную страницу
</a>

</body>
</html>

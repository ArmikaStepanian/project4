<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Selected product</title>
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
</head>
<body>

<div class="item">
    <div class="info">
        <p><strong>ID </strong>${product.id}</p>
        <p><strong>НАИМЕНОВАНИЕ </strong>${product.name}</p>
        <p><strong>ЦВЕТ </strong>${product.color}</p>
        <p><strong>НАЛИЧИЕ ДЕКОРАТИВНОЙ НАДПИСИ </strong>${product.feature}</p>
        <p><strong>КАТЕГОРИЯ </strong>${product.category}</p>
    </div>
</div>

</body>

</html>
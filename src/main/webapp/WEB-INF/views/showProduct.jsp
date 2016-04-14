<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Selected product</title>
</head>
<body>

<style type="text/css">

    * {margin: 0; padding: 0;} /* обнуляем отступы */

    .item { height:200px; width: 250px; overflow: hidden; margin: 0 auto; border: 1px solid #469b4a; border-radius: 5px; margin-left: 15px; margin-top: 20px; float: left;}
    .item .info {overflow: hidden;}
    .item .info p {color: #666; margin-bottom: 8px;}

</style>


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
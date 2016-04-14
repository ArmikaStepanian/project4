<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main page</title>
</head>
<body>

<style type="text/css">
    .item { height:200px; width: 250px; padding-top: 18px; padding-bottom: 18px; overflow: hidden; border: 1px solid #469b4a; border-radius: 5px; margin-left: 15px; margin-top: 20px; float: left;}
    .item .info {overflow: hidden;}
    .item .info p {color: #666; margin-bottom: 8px;}



</style>


<div class="item">
    <div class="info">
        <p><strong>ID </strong>${product.id}</p>
        <p><strong>NAME </strong>${product.name}</p>
        <p><strong>COLOR </strong>${product.color}</p>
        <p><strong>FEATURE </strong>${product.feature}</p>
        <p><strong>CATEGORY </strong>${product.category}</p>
    </div>
    </div>




</body>
</html>
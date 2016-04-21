<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/templates/welcome.jspf" %>

<div class="item">
    <div class="info">
            <p><strong>ID </strong>${product.id}</p>
            <p><strong>НАИМЕНОВАНИЕ </strong>${product.name}</p>
            <p><strong>ЦВЕТ </strong>${product.color}</p>
            <p><strong>НАЛИЧИЕ ДЕКОРАТИВНОЙ НАДПИСИ </strong>${product.feature}</p>
            <p><strong>КАТЕГОРИЯ </strong>${product.category}</p>
    </div>
</div>

<%@include file="/WEB-INF/templates/footer.jspf" %>
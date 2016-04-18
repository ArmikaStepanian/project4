<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to my shop</title>
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
<div class="header">
<p><img class="img" src="<c:url value='/resources/images/header.png'/>" /></p>

<form:form method="get" action="filter" commandName="productModel" cssClass="form-pm">

    <p class="name">
        <b>Поиск по наименованию:</b><br>
        <form:input path="name" /></p>

    <p class="param">
        <form:select path = "color" >
            <form:option value=""><b>Любой цвет</b></form:option>
                <c:forEach items="${colors}" var="c" >
                    <form:option value="${c}">${c}</form:option>
                </c:forEach>
         </form:select></p>

    <p class="param">
        <form:select path = "category">
            <form:option value=""><b>Любая категория</b></form:option>
                <c:forEach items="${categories}" var="cat" >
                    <form:option value="${cat}">${cat}</form:option>
                </c:forEach>
            </form:select></p>

    <p class="feature"><b>Наличие декоративной надписи:</b><br>
        <form:radiobutton path="feature" value="да" label="да" />
        <form:radiobutton path="feature" value="нет" label="нет" />
        <form:radiobutton path="feature"  value="" label="не важно" />
    </p>

    <p class="submit">
        <input type="submit" value="Отобрать" />
        <input type="reset" value="Сбросить" /></p>

</form:form>

</div>

    <c:if test="${pageHelper.isPagination() == true}">
        <p>Найдено товаров: ${count}</p>
            <a href="<c:if test="${pageHelper.getPreviousPage()!=-1}">?page=${pageHelper.getPreviousPage()}</c:if>">&laquo;&nbsp;&nbsp;</a>
            <c:set var="count" value="1"></c:set>
            <c:forEach begin="1" end="${pageHelper.getPagesCount()}">
                <a href="?name=${productModel.name}&color=${productModel.color}&category=${productModel.category}&feature=${productModel.feature}&page=${count}">${count}&nbsp;&nbsp;</a>
                <c:set var="count" value="${count + 1}"></c:set>
            </c:forEach>
            <a href="<c:if test="${pageHelper.getNextPage()!=-1}">?page=${pageHelper.getNextPage()}</c:if>">&nbsp;&nbsp;&raquo;</a>
    </c:if>


    <%--Оставлю на всякий случай, вдруг пригодится
    ***${requestScope['javax.servlet.forward.request_uri']}***
    ***${requestScope['javax.servlet.forward.query_string']}***--%>



<div class="book-list">
<c:if test="${!(products.isEmpty())}">

    <c:forEach items="${products}" var="pr" >

       <div class="item">
          <div class="info">
            <p><strong>ID </strong>${pr.id}</p>
            <p><strong>NAME </strong><a href="./showProduct?id=${pr.id}"><c:out value="${pr.name}"/></a></p>
            <p><strong>COLOR </strong>${pr.color}</p>
            <p><strong>FEATURE </strong>${pr.feature}</p>
            <p><strong>CATEGORY </strong>${pr.category}</p>
          </div>
       </div>

    </c:forEach>

</c:if>

<c:if test="${products.isEmpty()}">
<h3><p class="sorry">Я искала на складе, но такого товара нет!</p></h3>
</c:if>
</div>

</div>
</body>

</html>
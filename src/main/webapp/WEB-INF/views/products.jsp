<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product page</title>

</head>
<body>

<style type="text/css">
    * {margin: 0; padding: 0;} /* обнуляем отступы */
    body {
        text-align: center; /* выравниваем все содержимое body по центру */
        background: #fff; /* цвет фона для наглядности */
    }



.item { height:200px; width: 250px; padding-top: 18px; padding-bottom: 18px; overflow: hidden; margin: 0 auto; border: 1px solid #469b4a; border-radius: 5px; margin-left: 15px; margin-top: 20px; float: left;}
    .item .info {overflow: hidden;}
    .item .info p {color: #666; margin-bottom: 8px;}
</style>

<%--<form action="<c:url value="/logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout"/>
</form>--%>
<p><img style="display:block; margin: 0 auto;" src="<c:url value='/resources/images/header.png'/>" /></p>

<form:form method="get" action="filter" commandName="pm" style="border: 1px solid; width: 889px; display:block; margin: 0 auto;">

    <b>Поиск по наименованию:</b><br>
        <form:input path="name" />


    <form:select path = "color">
        <form:option value=""><b>Любой цвет</b></form:option>
        <c:forEach items="${colors}" var="c" >
            <form:option value="${c}">${c}</form:option>
        </c:forEach>
    </form:select>

    <form:select path = "category">
        <form:option value=""><b>Любая категория</b></form:option>
        <c:forEach items="${categories}" var="cat" >
            <form:option value="${cat}">${cat}</form:option>
        </c:forEach>
    </form:select>

    <p><b>Наличие декоративной надписи:</b><br>
        <form:radiobutton path="feature" value="да" label="да" />
        <form:radiobutton path="feature" value="нет" label="нет" />
        <form:radiobutton path="feature"  value="" label="не важно" />
    </p>

    <p><%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
        <input type="submit" value="Отобрать" />
        <input type="reset" value="Сбросить" /></p>

</form:form>

<c:if test="${!(productByParameters.isEmpty())}">

    <c:forEach items="${productByParameters}" var="s" >

       <div class="item">
          <div class="info">
            <p><strong>ID </strong>${s.id}</p>
            <p><strong>NAME </strong><a href="./showProduct?id=${s.id}"><c:out value="${s.name}"/></a></p>
            <p><strong>COLOR </strong>${s.color}</p>
            <p><strong>FEATURE </strong>${s.feature}</p>
            <p><strong>CATEGORY </strong>${s.category}</p>
          </div>
       </div>


    </c:forEach>
</table>


</c:if>


<c:if test="${productByParameters.isEmpty()}">
<h3 style="display:block; margin:0 auto;">Я искала на складе, но такого товара нет!</h3>
</c:if>


</body>
</html>
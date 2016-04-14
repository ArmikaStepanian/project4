<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to my shop</title>
</head>
<body>

<style scoped="scoped" type="text/css">

    * {margin: 0; padding: 0;} /* обнуляем отступы */

    .item { height:200px; width: 250px; overflow: hidden; margin: 0 auto; border: 1px solid #469b4a; border-radius: 5px; margin-left: 15px; margin-top: 20px; float: left;}
    .item .info {overflow: hidden;}
    .item .info p {color: #666; margin-bottom: 8px;}

    .form-pm { border: 1px solid; width: 889px; display:block; margin: 0 auto; margin-top:15px; }
    .img { display:block; margin: 0 auto; }
    .name { float: left; margin-top: 17px; margin-left: 35px; margin-right: 35px; }
    .color { margin-top: 34px; float: left; margin-right: 35px; }
    .category { margin-top: 34px; }
    .feature { margin-top: 17px; margin-left:35px; }
    .submit { margin-top: 17px; margin-left:35px; margin-bottom: 17px; }
    .sorry { text-align: center; margin-top: 100px; }

</style>


<p><img class="img" src="<c:url value='/resources/images/header.png'/>" /></p>

<form:form method="get" action="filter" commandName="pm" cssClass="form-pm">

    <p class="name">
        <b>Поиск по наименованию:</b><br>
        <form:input path="name" /></p>

    <p class="color">
        <form:select path = "color" >
            <form:option value=""><b>Любой цвет</b></form:option>
                <c:forEach items="${colors}" var="c" >
                    <form:option value="${c}">${c}</form:option>
                </c:forEach>
         </form:select></p>

    <p class="category">
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

</c:if>

<c:if test="${productByParameters.isEmpty()}">
<h3><p class="sorry">Я искала на складе, но такого товара нет!</p></h3>
</c:if>

</body>

</html>
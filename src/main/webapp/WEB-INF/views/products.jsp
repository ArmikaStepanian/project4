<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product page</title>

</head>
<body>

<form action="<c:url value="/logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout"/>
</form>

<form:form method="get" action="filter" commandName="pm" style="border: 1px solid; width: 300px;">

    <p><b>Поиск по имени:</b><br>
        <form:input path="name" />
    <p>

    <form:select path = "color">
        <form:option value=""><b>Любой цвет</b></form:option>
        <c:forEach items="${colors}" var="c" >
            <form:option value="${c}">${c}</form:option>
        </c:forEach>
    </form:select>

    <p><b>Наличие дополнительного кармана:</b><br>
        <form:radiobutton path="feature" value="да" label="yes" />
        <form:radiobutton path="feature" value="нет" label="no" />
        <form:radiobutton path="feature"  value="" label="doesn't matter" />
    </p>

    <p><%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
        <input type="submit" value="Отобрать" />
        <input type="reset" value="Сбросить" /></p>

</form:form>


<table style="width: 600px; text-align:center">
    <tbody>
    <c:forEach items="${productByParameters}" var="s" >
        <tr>
            <td>${s.id}</td>
            <td><a href="./showProduct?id=${s.id}"><c:out value="${s.name}"/></a></td>
            <%--<td>${s.name}</td>--%>
            <td>${s.color}</td>
            <td>${s.feature}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
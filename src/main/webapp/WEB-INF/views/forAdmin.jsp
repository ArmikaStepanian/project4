<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
</head>
<body>


<form:form name="form" method="get" action="addProduct" commandName="productModel" >

    <p class="name">
        <b>Имя:</b><br>
        <form:input path="name" /></p>

    <p class="param">
        <form:select path = "color" >
            <form:option value=""><b>Цвет</b></form:option>
            <c:forEach items="${colors}" var="c" >
                <form:option value="${c.id}">${c.name}</form:option>
            </c:forEach>
        </form:select></p>

    <p class="param">
        <form:select path = "category">
            <form:option value=""><b>Категория</b></form:option>
            <c:forEach items="${categories}" var="cat" >
                <form:option value="${cat.id}">${cat.name}</form:option>
            </c:forEach>
        </form:select></p>

    <p class="feature"><b>Наличие декоративной надписи:</b><br>
        <c:forEach items="${features}" var="f" >
            <form:radiobutton path="feature" value="${f.id}" label="${f.name}" />
        </c:forEach>
    </p>

    <p class="submit">
        <input type="submit" value="Добавить" />
        <input type="button" value="Сбросить" onclick="clearForm(this.form);" /></p>

</form:form>

<%-- Script to clear search-form after submit --%>

<script type="text/javascript">

    function clearForm(form) {

        var elements = form.elements;

        form.reset();

        for(i=0; i < elements.length; i++) {

            field_type = elements[i].type.toLowerCase();

            switch(field_type) {

                case "text":
                case "password":
                case "textarea":
                case "hidden":

                    elements[i].value = "";
                    break;

                case "radio":
                case "checkbox":
                    if (elements[i].checked) {
                        elements[i].checked = false;
                    }
                    break;

                case "select-one":
                case "select-multi":
                    elements[i].selectedIndex = 0;
                    break;

                default:
                    break;
            }
        }
    }

</script>

</body>

</html>

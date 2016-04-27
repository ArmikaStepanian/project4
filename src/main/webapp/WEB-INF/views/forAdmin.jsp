<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello, Admin</title>
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
</head>
<body>

<div style="float: left">
    <a href="<c:url value="/" />">
        Вернуться на главную <br> страницу
    </a>
</div>

<%-- start Form for adding product --%>
<c:if test="${empty productModel.id}">

<form:form onsubmit="return checkForm(this)" name="form" method="get" action="addProduct" commandName="productModel" cssClass="form-pm" >

    <p>
        <b>Имя:</b>
    <br>
        <form:input id="name" path="name" />
    <br>
        <output id="err_name" class="error" ></output>
    </p>
    <p>
        <form:select id="color" path = "color">
            <form:option value=""><b>Цвет</b></form:option>
            <form:options items="${colors}" itemValue="id" itemLabel="name" />
        </form:select>
    <br>
        <output id="err_color" class="error"></output>
    </p>
    <p>
        <form:select id="category" path = "category">
            <form:option value=""><b>Категория</b></form:option>
            <form:options items="${categories}" itemValue="id" itemLabel="name" />
        </form:select>
    <br>
        <output id="err_category" class="error"></output>
    </p>
    <p>
        <b>Наличие декоративной надписи:</b>
    <br>
        <form:radiobuttons path="feature" items="${features}" itemValue="id" itemLabel="name" />
    <br>
        <output id="err_feature" class="error"></output>
    </p>
    <p>
        <input type="submit" value="Добавить" />
        <input type="button" value="Сбросить" onclick="clearForm(this.form);" />
    </p>

</form:form>

</c:if>
<%-- end Form for adding product --%>

<%-- start Form for editing product --%>
<c:if test="${!empty productModel.id}">

    <form:form onsubmit="return checkForm(this)" name="form" method="get" action="editProduct" commandName="productModel" cssClass="form-pm" >

    <p>
        <b>Id:</b>
        <form:input path="id" readonly="true" />
    </p>
    <p>
        <b>Имя:</b>
        <br>
        <form:input id="name" path="name" />
        <br>
        <output id="err_name" class="error" ></output>
    </p>
    <p>
        <form:select id="color" path = "color">
            <form:option value=""><b>Цвет</b></form:option>
            <form:options items="${colors}" itemValue="id" itemLabel="name" />
        </form:select>
        <br>
        <output id="err_color" class="error"></output>
    </p>
    <p>
        <form:select id="category" path = "category">
            <form:option value=""><b>Категория</b></form:option>
            <form:options items="${categories}" itemValue="id" itemLabel="name" />
        </form:select>
        <br>
        <output id="err_category" class="error"></output>
    </p>
    <p>
        <b>Наличие декоративной надписи:</b>
        <br>
        <form:radiobuttons path="feature" items="${features}" itemValue="id" itemLabel="name" />
        <br>
        <output id="err_feature" class="error"></output>
    </p>
    <p>
        <input type="submit" value="Редактировать" />
        <a href="<c:url value="//addProductPage" />" >Отмена</a>
    </p>

    </form:form>

</c:if>
<%-- end Form for editing product --%>

<%-- start Script to clear search-form after submit --%>
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
                case "output":
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
<%-- end Script to clear search-form after submit --%>

<%-- start Script for checking forms' empty fields --%>
<script type="text/javascript">

    function checkForm(form){

        if (document.getElementById('name').value==""){
            document.getElementById('err_name').innerHTML='Заполните имя';
            return false;
        }
        else {
            document.getElementById('err_name').innerHTML="";
        }

        if (document.getElementById('color').value==""){
            document.getElementById('err_color').innerHTML='Заполните  цвет';
            return false;
        }
        else {
            document.getElementById('err_color').innerHTML="";
        }

        if (document.getElementById('category').value==""){
            document.getElementById('err_category').innerHTML='Заполните категорию';
            return false;
        }
        else {
            document.getElementById('err_category').innerHTML="";
        }
// Radio Button Validation
// copyright Stephen Chapman, 15th Nov 2004,14th Sep 2005
// you may copy this function but please keep the copyright notice with it
        var features = (form.feature);
        var index = -1;
        for (var i=features.length-1; i > -1; i--) {

            if (features[i].checked) {

                index = i; i = -1;
            }
        }
        if (index > -1) {

            document.getElementById('err_feature').innerHTML="";
        }
        else
        {
            document.getElementById('err_feature').innerHTML='Выберите значение';
        return false;
        }

        return true;
    }

</script>
<%-- end Script for checking forms' empty fields --%>

<%-- start Pagination --%>
<div class="form-pm">
<c:if test="${!(products.isEmpty())}">
    <c:if test="${pageHelper.isPagination() == true}">
        <p>Найдено товаров: ${count}</p>
        <p><a href="<c:if test="${pageHelper.getPreviousPage()!=-1}">?id=${productModel.id}&page=${pageHelper.getPreviousPage()}</c:if>">&laquo;&nbsp;&nbsp;</a>
            <c:set var="count" value="1"></c:set>
            <c:forEach begin="1" end="${pageHelper.getPagesCount()}">
                <a href="?id=${productModel.id}&page=${count}">${count}&nbsp;&nbsp;</a>
                <c:set var="count" value="${count + 1}"></c:set>
            </c:forEach>
            <a href="<c:if test="${pageHelper.getNextPage()!=-1}">?id=${productModel.id}&page=${pageHelper.getNextPage()}</c:if>">&nbsp;&nbsp;&raquo;</a></p>
    </c:if>
</div>


    <table class="form-pm">
        <tr>
            <th width="90">id</th>
            <th width="150">Name</th>
            <th width="150">Color</th>
            <th width="150">Category</th>
            <th width="150">Feature</th>
            <th width="150">Edit</th>
            <th width="150">Delete</th>
        </tr>
        <c:forEach items="${products}" var="pr">
            <tr>
                <td>${pr.id}</td>
                <td>${pr.name}</td>
                <td>${pr.color}</td>
                <td>${pr.category}</td>
                <td>${pr.feature}</td>
                <td><a href="<c:url value="./editProductPage?id=${pr.id}&page=${pageHelper.getCurrentPage()}" />" >Edit</a></td>
                <td><a href="<c:url value="./deleteProduct?id=${pr.id}" />" onclick="return confirm('Удалить запись?')">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
<%-- end Pagination and Table--%>

</body>

</html>
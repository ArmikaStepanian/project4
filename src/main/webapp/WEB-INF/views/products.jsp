<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- start Login, Logout --%>
<div style="float: left">
<p>
    <a href="<c:url value="/auth" />" >Войти</a>
</p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p>
        <a href="./addProductPage"><c:out value="ДОБАВИТЬ ТОВАР"/></a>
    </p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
    <form  action="<c:url value='/logout' />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="Выйти"/>
    </form>
</sec:authorize>
</div>
<%-- end Login, Logout --%>

<%@include file="/WEB-INF/templates/welcome.jspf" %>

<%@include file="/WEB-INF/templates/searchForm.jspf" %>

    <div class="book-list">

<%-- start Pagination --%>
    <c:if test="${!(products.isEmpty())}">
        <c:if test="${pageHelper.isPagination() == true}">
            <p>Найдено товаров: ${count}</p>
            <p><a href="<c:if test="${pageHelper.getPreviousPage()!=-1}">?name=${productModel.name}&color=${productModel.color}&category=${productModel.category}&feature=${productModel.feature}&page=${pageHelper.getPreviousPage()}</c:if>">&laquo;&nbsp;&nbsp;</a>
                <c:set var="count" value="1"></c:set>
                <c:forEach begin="1" end="${pageHelper.getPagesCount()}">
                    <a href="?name=${productModel.name}&color=${productModel.color}&category=${productModel.category}&feature=${productModel.feature}&page=${count}">${count}&nbsp;&nbsp;</a>
                    <c:set var="count" value="${count + 1}"></c:set>
                </c:forEach>
                <a href="<c:if test="${pageHelper.getNextPage()!=-1}">?name=${productModel.name}&color=${productModel.color}&category=${productModel.category}&feature=${productModel.feature}&page=${pageHelper.getNextPage()}</c:if>">&nbsp;&nbsp;&raquo;</a></p>
        </c:if>

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
<%-- end Pagination and table --%>

<%@include file="/WEB-INF/templates/footer.jspf" %>




        <%--***${requestScope['javax.servlet.forward.request_uri']}***
        ***${requestScope['javax.servlet.forward.query_string']}***--%>
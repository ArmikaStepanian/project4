<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Home</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
</head>
<body>


  
  <section class="container">
    <div class="login">      
      <form action="<c:url value='j_spring_security_check'/>" method="POST">
        <p><input  type="text" name="j_username" value="" placeholder="Username or Email"></p>
        <p><input  type="password" name="j_password" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember-me" id="remember-me">
            Запомнить
          </label>
        </p>
        <p class="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" name="commit" value="Login"></p>
          <c:if test="${not empty param.login_failed}">
              <div class="error">
                  Неверные пользователь и/или пароль
              </div>
          </c:if>
      </form>
    </div>    
  </section>
  
</body>

</html>

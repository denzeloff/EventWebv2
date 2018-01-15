<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 12.12.2017
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/head.jspf" />
<body>
<jsp:include page="fragments/navbar.jspf" />
<div class="img-container sm-img"> </div>

<div class="form-container">
    <div class="col-sm-6 col-md-4" >
        <form class="form-signin" method="post" action="register">
            <h2 class="form-signin-heading">Sign up</h2>
            <c:if test="${param.result=='fail'}">
                <div class="alert alert-danger">
                    <strong>Password or email already exists</strong>
                </div>
            </c:if>
            <input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus />
            <input name="inputUsername" type="text" class="form-control" placeholder="Username" required autofocus />
            <input name="inputPassword" type="password" class="form-control" placeholder="Password" required />
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign up</button>
        </form>
    </div>
</div>
<jsp:include page="fragments/footer.jspf" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>

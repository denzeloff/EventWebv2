<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 09.12.2017
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>EventWeb</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="fragments/navbar.jspf" />

<c:if test="${not empty requestScope.events}">
<c:forEach var="events" items="${requestScope.events}">
<div class="container">     
    <div class="row bs-callout bs-callout-primary">
            <%--  <c:if test="${events.seats > 0}">
                  <div class="col col-md-1 col-sm-2"> Number of seats:          
                      <div class="well well-sm centered"> <c:out value="${events.seats}" /></div>       
                  </div> 
              </c:if>--%>
             <c:choose>
                  <c:when test="${events.seats > 0}">
                      <div class="col col-md-1 col-sm-2"> Number of seats:          
                          <div class="well well-sm centered"> <c:out value="${events.seats}" /></div>       
                      </div>  
                       </c:when>
                  <c:otherwise>
                      <div class="col col-md-1 col-sm-2"> Number of seats:          
                          <div class="well well-sm centered">no places </div>       
                      </div>  
                  </c:otherwise>
              </c:choose>    
        <div class="col col-md-11 col-sm-10">
                      <h3 class="centered"><a href="${pageContext.request.contextPath}/event?id=${events.id}"><c:out value="${events.title}" /></a></h3>       
                      <p><c:out value="${events.description}" /></p>
            <div class="info-container">
            <h6>
                <medium>Added by: <c:out value="${events.user.username}" />,Date: <fmt:formatDate value="${events.timestamp}" pattern="dd/MM/YYYY"/></medium>
                <!-- <p><medium>Wyświetlono: 12 razy</medium></p>-->
            </h6>
            </div>
        </div>
    </div>
    </c:forEach>
     </c:if>
</div>
<jsp:include page="fragments/footer.jspf" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>

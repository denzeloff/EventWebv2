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
<jsp:include page="fragments/head.jspf" />
<body>
<jsp:include page="fragments/navbar.jspf" />
<div class="img-container">
    <div class="row welcome-text">
        <div class="col col-md-12 col-lg-12">
            <h1>Technology is a future.</h1>
            <h3>Be up-to-date. Choose a technology event which you can't miss. </h3>
        </div>
    </div>
</div>

<section class="event-section">
    <div class="row">
        <div class="col col-lg-12 col-md-12">
            <h2>Future Events</h2>

            <c:if test="${not empty requestScope.events}">
                <c:forEach var="events" items="${requestScope.events}">
                    <div class="col col-md-10 col-sm-10 event-col">
                        <div class="title-part">
                            <h3 class="event-h3 not-booked"> <a href="${pageContext.request.contextPath}/event?id=${events.id}"> <c:out value="${events.title}" /> </a> </h3> 
                            <c:choose>
                                <c:when test="${events.seats > 0}">
                                    <div class="seats"> Number of seats:          
                                        <span class="seats-number"> <c:out value="${events.seats}" /> </span>       
                                    </div>  
                                </c:when>
                                <c:otherwise>
                                    <div class="seats"> Number of seats:          
                                        <span class="seats-number"> no places available </span>       
                                    </div> 
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <p> <c:out value="${events.description}" /></p>
                        <div class="info-container">
                            <h6>
                                <medium>Added by: <c:out value="${events.user.username}" />, Date: <fmt:formatDate value="${events.timestamp}" pattern="dd/MM/YYYY"/></medium>
                            </h6>
                        </div>
                    </div> <!-- end of event-col -->

                </c:forEach>
                       </c:if>

        </div> <!-- end of main col-->
    </div> <!-- end of main row -->
</section>

<jsp:include page="fragments/footer.jspf" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>

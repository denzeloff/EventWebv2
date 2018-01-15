<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 24.12.2017
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/head.jspf" />
<body>
<jsp:include page="fragments/navbar.jspf"/>

<div class="img-container sm-img"> </div>

<div class="container">

    <div class="row">
        <article class="col-lg-12">
            <div class="tab-content">
                <c:if test="${param.result != null}">
                    <div class="alert alert-warning">
                        <c:out value="${param.result}"/>
                    </div>
                </c:if>
                <h2> <c:out value="${event.title}"/> </h2>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <tbody>
                        <tr>
                            <th> Event title: </th>
                            <td>
                                <h4><c:out value="${event.title}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Category: </th>
                            <td>
                                <h4><c:out value="${event.category.category}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Date: </th>
                            <td>
                                <h4><c:out value="${event.date}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Time: </th>
                            <td>
                                <h4> <c:out value="${event.eventHour}"/> </h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Language: </th>
                            <td>
                                <h4><c:out value="${event.language}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> City: </th>
                            <td>
                                <h4><c:out value="${event.city}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Place: </th>
                            <td>
                                <h4><c:out value="${event.place}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Address: </th>
                            <td>
                                <h4> <c:out value="${event.address}"/> </h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Description: </th>
                            <td>
                                <p>
                                    <c:out value="${event.description}"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <th> Speakers: </th>
                            <td>
                                <h4><c:out value="${event.speakers}"/></h4>
                            </td>
                        </tr>
                        <tr>
                            <th> Available seats: </th>
                            <td>
                                <h4><c:out value="${event.seats}"/></h4>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="row ">
                    <div class="button-style">
                    <c:if test="${user_id != null && event.user.id != user_id && event.seats > 0}">
                        <c:if test="${not isSignedUp}">
                            <a href="${pageContext.request.contextPath}/signUp?id=${event.id}"
                               class="btn-default sign-button">Sign up for the event
                            </a>
                        </c:if>
                        <c:if test="${isSignedUp == true}">
                            <p>You are already signed up for this event</p>
                        </c:if>
                    </c:if>
                    </div>
                </div>

                <hr>
                <c:choose>
                <c:when test="${not empty users}">
                <div class="users-list">
                    <h3>Users who have already signed up: </h3>

                    <div class="table-responsive">

                        <table class="table user-table">
                            <tbody>
                            <tr class="table-head">
                                <th> <h4>Lp</h4>  </th>
                                <th>
                                    <h4> Username </h4>
                                </th>
                            </tr>
                            <c:set var="count" value="1" scope="page"/>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td> <c:out value="${count}"/></td>
                                    <td>
                                        <h4><c:out value="${user.username}"/></h4>
                                    </td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page"/>
                            </c:forEach>
                            </c:when>
                            <c:otherwise>
                                No attendants yet
                            </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </article>
    </div>
</div>


<jsp:include page="fragments/footer.jspf"/>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>
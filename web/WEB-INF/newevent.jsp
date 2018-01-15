<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 16.12.2017
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/head.jspf"/>
<body>
<jsp:include page="fragments/navbar.jspf" />
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-sm-12 col-md-6 col-6 col-xl-6 ">
            <h3>Insert data in every form field to add a new event</h3>
            <form class="form-signin" method="post" action="add">
                <div class="form-group">
                    <label for="event-title">Event title</label>
                    <input name="inputTitle" type="text" class="form-control" id="event-title" required>
                </div>
                <div class="form-group">
                    <label for="number of places">Number of places</label>
                    <input name="inputSeats" type="text" class="form-control" id="number of places" required>
                </div>
                <div class="form-group">
                    <label for="event-category">Event category</label>
                    <select name="inputCategory" multiple class="form-control" id="event-category" required>
                        <option>System Administration</option>
                        <option>Software Development</option>
                        <option>Project Management</option>
                        <option>Cloud Computing</option>
                        <option>Artificial Intelligence</option>
                        <option>Network Security</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="event-date">Event date</label>
                    <input name="inputDate" type="date" class="form-control" id="event-date" required>
                </div>
                <div class="form-group">
                    <label for="event-time">Event time</label>
                    <input name="inputTime" type="time" class="form-control" id="event-time" required>
                </div>
                <div class="form-group">
                    <label for="event-language">Language</label>
                    <select name="inputLanguage" class="form-control" id="event-language" required>
                        <option>English</option>
                        <option>French</option>
                        <option>German</option>
                        <option>Polish</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="event-city">City</label>
                    <input name="inputCity" type="text" class="form-control" id="event-city" required>
                </div>
                <div class="form-group">
                    <label for="event-place">Place</label>
                    <input name="inputPlace" type="text" class="form-control" id="event-place" required>
                </div>
                <div class="form-group">
                    <label for="event-address">Address</label>
                    <input name="inputAddress" type="text" class="form-control" id="event-address" required>
                </div>
                <div class="form-group">
                    <label for="event-speakers">Speakers</label>
                    <input name="inputSpeakers" type="text" class="form-control" id="event-speakers" required>
                </div>
                <div class="form-group">
                    <label for="event-description">Event Description</label>
                    <textarea name="inputDescription" class="form-control" id="event-description" rows="3" required></textarea>
                </div>
                <div class="row d-flex justify-content-end">
                    <button type="submit" class="btn btn-outline-success">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jspf" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Library Automation</title>

    <!-- Bootstrap -->

    <link
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
            rel="stylesheet">

    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <link href="${pageContext.request.contextPath }/static/css/main.css" rel="stylesheet" type="text/css">

    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/6.1.7/css/bootstrap-slider.min.css"
            rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header and footer/header.jsp" />




<%--	<sec:authorize access="!isAuthenticated()">
		<a href="${pageContext.request.contextPath }/loginpage">Login</a>
		<p />

		<a href="${pageContext.request.contextPath }/registerpage">Register</a>
		<p />

	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="${pageContext.request.contextPath }/profile">My Profile</a>
		<p />
	</sec:authorize>

	<c:url var="logoutUrl" value="/logout" />
	<sec:authorize access="isAuthenticated()">
		<form action="${logoutUrl }" method="post">
			<input type="submit" value="Log out">
		</form>
	</sec:authorize>--%>


<br><br><br><br><br><br>
<div class="row">
    <div class="col-md-3 col-md-offset-3 "><h1>Book List</h1></div>


    <c:if test="${!empty listBooks}">
    <table class="table table-striped">
        <tr>
            <th width="120">id</th>
            <th width="120">isbn</th>
            <th width="120">title</th>
            <th width="120">publishYear</th>
            <th width="120">author</th>
            <th width="120">addingDate</th>
            <th width="120">Settigs</th>
            <th width="60">Details</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.publishYear}</td>
                <td>${book.author}</td>
                <td>${book.addingDate}</td>

                <td>
                    <a href="/editBook/${book.id}" class="btn btn-primary">
                        <span class="glyphicon glyphicon-cog"></span> Edit</a>
                    <a href="/deleteBook/${book.id}" class="btn btn-danger">
                        <span class="glyphicon glyphicon-trash"></span> Delete</a></td>
                <td><a href="/book/${book.id}" class="btn btn-warning">
                    <span class="glyphicon glyphicon-info-sign"></span> Details</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>



</body>
</html>
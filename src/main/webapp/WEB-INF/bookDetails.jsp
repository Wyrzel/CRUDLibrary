%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
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

<jsp:include page="header and footer/header.jsp"/>


<br><br><br><br><br><br>
<div class="col-md-offset-2 col-xs-offset-4">
    <div class="row">
        <h3>
            <strong>${book.title}</strong>
        </h3>
    </div>
    <div class="row">
        <div class="col-md-2 col-xs-4"><b>isbn:</b></div>
        <div class="col-md-2 col-xs-4">
            <c:out value="${book.author}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-xs-4"><b>publishYear:</b></div>
        <div class="col-md-2 col-xs-4">
            <c:out value="${book.publishYear}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-xs-4"><b>author:</b></div>
        <div class="col-md-2 col-xs-4">
            <c:out value="${book.isbn}"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-xs-4"><b>Rent:</b></div>
        <div class="col-md-2 col-xs-4">
            <c:if test="${book.status eq 'AVALIBLE'}">
                <a href="/book/rent/${book.id}" class="btn btn-warning" method="POST"> Rent</a>
            </c:if>
            <c:if test="${book.status eq 'LOANED'}">
                <span class="label label-success">${book.status} to ${rented}</span>
            </c:if>
        </div>
    </div>
</div>

<br><br><br>
<c:choose>
<c:when test="${empty bookHistory}">
    <h3 class="text-center">Book History is empty!</h3>
</c:when>
<c:otherwise>
<div class="col-md-offset-2 col-xs-offset-4">
    <h3>
        <strong>Book History</strong>
    </h3>
    <table class="table-bordered">
        <tr>
            <th width="120">rent Date</th>
            <th width="120">return Date</th>
            <th width="120">by</th>

        </tr>
        <c:forEach items="${bookHistory}" var="rent">
            <tr>
                <td>${rent.rentDate}</td>
                <td>${rent.returnDate}</td>
                <td>${rent.user.firstName}</td>


            </tr>
        </c:forEach>
    </table>
</div>
</c:otherwise>
</c:choose>

</body>
</html>
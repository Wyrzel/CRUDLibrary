<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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

<br><br><br><br><br><br>

<div class="container">
    <div class="card card-container">

        <h4> Create new account</h4>
        <form action="" method="post" class="form-signin">
            <input name="email" type="email" id="inputEmail" class="form-control"
                   placeholder="Email address" required autofocus>
            <input name="firstName" type="text" id="inputFirstName" class="form-control"
                   placeholder="First name" required>
            <input name="lastName" type="text" id="inputLastName" class="form-control"
                   placeholder="Last name" required>
            <input name="password" type="password" id="inputPassword" class="form-control"
                   placeholder="Password" required>
            <input name="repeatPassword" type="password" id="inputRepeatedPassword"
                   class="form-control" placeholder="Repeat password" required>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Create
            </button>
        </form>

        <div class="margin-bottom-10">
            <a href="" class="forgot-password">Back to login</a>
        </div>

    </div>
</div>


</body>
</html>
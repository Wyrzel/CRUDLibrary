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

    <link href="${pageContext.request.contextPath }/" rel="stylesheet" type="text/css">

    <link href="${pageContext.request.contextPath }/" rel="stylesheet" type="text/css">

    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/6.1.7/css/bootstrap-slider.min.css"
            rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="header and footer/header.jsp"/>


<br><br><br><br><br><br><br><br><br>

    <div class="container">
        <div class="col-md-offset-5 col-md-3">
        <c:if test="${param.logout!=null}">
            <div class="alert alert-success fade in">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                <p>You've logged out</p>
            </div>
        </c:if>

        <c:if test="${param.register!=null}">
            <div class="alert alert-info fade in">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                <p>Register successful. You can log in</p>
            </div>
        </c:if>

        <c:if test="${param.error!=null}">
            <div class="alert alert-danger fade in">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                <p>Username or password is incorrect</p>
            </div>
        </c:if>

        <div class="card card-container">
            <h4> Login to your account</h4>
            <form action="${loginUrl}" method="post" class="form-signin">
                <input name="email" type="email" id="inputEmail" class="form-control"
                       placeholder="Email address" required autofocus>
                <input name="password" type="password" id="inputPassword" class="form-control"
                       placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" a
                        href="${pageContext.request.contextPath }/allBooks">Sign in
                </button>
            </form>
            <div class="margin-bottom-10">
                <a href="#" class="forgot-password">Forgot the password?</a>
            </div>
            <div class="margin-bottom-10">
                Don't have account? <a href="${pageContext.request.contextPath }/registration" class="register">Create
                account</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
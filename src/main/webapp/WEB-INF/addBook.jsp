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

<jsp:include page="header and footer/header.jsp" />

<br><br><br><br>
<div align="center">
    <h1>Add Book</h1>
    <form:form method="POST" action="save" >
        <table>
            <tr>
                <td>ISBN:</td>
                <td><form:input path="isbn"/></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td>Publish Year:</td>
                <td><form:input path="publishYear"/></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                &nbsp;&nbsp;<td>
                <button class="btn btn-danger" type="submit">save</button>
            </td>
            </tr>
        </table>
    </form:form>
</div>


</body>
</html>
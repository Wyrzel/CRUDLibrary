<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                        aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath }/">Library
                    Automation</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/search/" method="post">
                    <div class="form-group">

                        <input name="title" type="text" placeholder=Search class="form-control">
                    </div>

                    <button type="submit" class="btn btn-success">Search</button>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="${pageContext.request.contextPath }/login"
                           class="btn btn-success">Sign In</a>

                    </sec:authorize>

                    <!-- PROFILE BUTTON ON NAVBAR (ONLY VISIBLE TO SIGNED IN)  -->

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="${pageContext.request.contextPath }/profile"
                           class="btn btn-success">My Profile</a>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="${pageContext.request.contextPath }/addBook"
                           class="btn btn-success">add Book</a>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="${pageContext.request.contextPath }/allBooks"
                           class="btn btn-success">All Books</a>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <a href="${pageContext.request.contextPath }/book/rents"
                           class="btn btn-success">All Rents</a>
                    </sec:authorize>



                </form>

                <!-- LOGOUT BUTTON ON NAVBAR (ONLY VISIBLE TO SIGNED IN)  -->


                <div id="navbar" class="navbar-collapse collapse"></div>
                <c:url var="logoutUrl" value="/logout"/>
                <sec:authorize access="isAuthenticated()">
                    <form action="${logoutUrl }" method="post"
                          class="navbar-form navbar-right">
                        <input type="submit" value="Log out" class="btn btn-xs btn-danger">
                    </form>
                </sec:authorize>

                <!-- REGISTER BUTTON ON NAVBAR (NOT VISIBLE TO SIGNED IN) -->

       <%--         <sec:authorize access="!isAuthenticated()">
                    <form action="${pageContext.request.contextPath }/registerpage"
                          method="post" class="navbar-form navbar-right">
                        <input type="submit" value="Sign Up" class="btn btn-xs btn-danger">
                    </form>
                </sec:authorize>--%>


            </div>
            <!--/.navbar-collapse -->
        </div>
    </nav>
</head>
<body>

</body>
</html>

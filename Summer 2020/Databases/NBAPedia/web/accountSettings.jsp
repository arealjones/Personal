<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%!
    boolean loggedIn = false;
    String username = "";
%>


<%
    if (session.getAttribute("username") != null) {
        loggedIn = true;
        username = session.getAttribute("username").toString();
    } else {
        loggedIn = false;
        username = "";
    }

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Rapid Bootstrap Template - Index</title>
    <meta content="" name="descriptison">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
    <link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png"
          rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/ionicons/css/ionicons.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/venobox/venobox.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/owl.carousel/assets/owl.carousel.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: Rapid - v2.2.0
    * Template URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top header-transparent">
    <div class="container d-flex align-items-center">

        <h1 class="logo mr-auto"><a href="/index"><img
                src="${pageContext.request.contextPath}/assets/img/logo.png" alt=""
                id="logo-img"/>NBAPedia</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav class="main-nav d-none d-lg-block">
            <ul>
                <li><a href="/index">Home</a></li>
                <li><a href="/teams">Teams</a></li>
                <li><a href="/players">Players</a></li>
                <li><a href="/games">Schedule</a></li>
                <c:if test="<%=!loggedIn%>">
                    <li><a href="/login" class="user-button user-button-border">Log In</a></li>
                    <li><a href="/signup" class="user-button user-button-border">Sign Up</a></li>
                </c:if>
                <c:if test="<%=loggedIn%>">
                    <li class="drop-down" class="active"><a href="">Hi! <%=username%>
                    </a>
                        <ul>
                            <li><a href="/account">Account Settings</a></li>
                            <li><a href="javascript:location.href='/logout'">Log Out</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </nav><!-- .main-nav-->

    </div>
</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<div class="clearfix" id="account-box">
    <div class="container">
        <div class="row settings-section">
            <div class="col-2">
            </div>
            <div class="col-8">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Account Settings</h5>
                        <form action="/user/update" id="update-form" method="POST">
                            <div class="input-div">
                                <label for="username">Username: </label>
                                <input id="username" class="form-control settings-form" type="text"
                                       placeholder="${username}" name="username" value="${username}"
                                       readonly>
                            </div>
                            <div class="input-div">
                                <label for="password">Password: </label>
                                <input type="password" id="password" name="password"
                                       class="form-control settings-form"
                                       placeholder="Password">
                            </div>
                            <div class="input-div">
                                <label for="favTeam">Your favorite team: </label>
                                <select class="form-control settings-form" name="favTeam"
                                        id="favTeam">
                                    <c:forEach items="${teams}" var="team">
                                        <c:if test="${user.favouriteTeam.teamId == team.teamId}">
                                            <option value="${team.teamId}"
                                                    selected>${team.name}</option>
                                        </c:if>
                                        <c:if test="${user.favouriteTeam.teamId != team.teamId}">
                                            <option value="${team.teamId}">${team.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div id="update-msg">${msg}</div>
                            <button class="btn btn-lg btn-primary btn-block submit"
                                    id="update-button"
                                    type="submit">Update
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-2">
            </div>
        </div>

        <%--        Player comments         --%>
        <div class="row settings-section">
            <div class="col-2 ">
            </div>
            <div class="col-8">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Manage Your Player Comments</h5>
                        <c:forEach items="${playerComments}" var="comment">
                            <div class="card comment-card">
                                <div class="card-body">
                                    <h5 class="card-title">${comment.player.name}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">
                                            ${comment.created}
                                    </h6>
                                    <p class="card-text">${comment.content}</p>
                                    <a href="#" class="card-link" data-toggle="modal"
                                       data-target="#commentUpdateModal"
                                       data-id="${comment.commentId}"
                                       data-content="${comment.content}">Update</a>
                                    <a href="#" class="card-link"
                                       onclick="javascript:window.location.href='/comment/delete?commentId=${comment.commentId}';">Delete</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-2">
            </div>
        </div>

        <%--        Team comments         --%>
        <div class="row settings-section">
            <div class="col-2">
            </div>
            <div class="col-8">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Manage Your Team Comments</h5>
                        <c:forEach items="${teamComments}" var="comment">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${comment.team.name}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">
                                        <fmt:formatDate
                                                value="${comment.created}"
                                                pattern="MM/dd/yyyy HH:mm"/>
                                    </h6>
                                    <p class="card-text">${comment.content}</p>
                                    <a href="#" class="card-link" data-toggle="modal"
                                       data-target="#commentUpdateModal"
                                       data-id="${comment.commentId}"
                                       data-content="${comment.content}">Update</a>
                                    <a href="#"
                                       onclick="javascript:window.location.href='/comment/delete?commentId=${comment.commentId}';"
                                       class="card-link">Delete</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-2">
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="commentUpdateModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Update Comment</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form method="post" id="commentUpdateForm">
                        <div class="modal-body">
                            <textarea name="content" class="form-control" id="commentTextArea"
                                      rows="3"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                Close
                            </button>
                            <button type="submit" class="btn btn-primary" id="updateCommentBtn">Save
                                changes
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Vendor JS Files -->
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/counterup/counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/venobox/venobox.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/aos/aos.js"></script>

<!-- Template Main JS File -->
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

<script>
    <%
        if (request.getAttribute("commentMsg") != null) {
    %>
    alert("${commentMsg}")
    console.log("${commentMsg}")
    <%
            request.removeAttribute("commentMsg");
        }
    %>

    $('#commentUpdateModal').on('show.bs.modal', function (event) {
        let button = $(event.relatedTarget) // Button that triggered the modal
        let commentId = button.data('id')
        let content = button.data('content')
        $('#commentTextArea').text(content)
        console.log(content)
        $('#commentUpdateForm').attr('action', '/comment/update?commentId=' + commentId)
    })
</script>

</body>

</html>

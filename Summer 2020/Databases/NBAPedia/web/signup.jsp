<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Rapid Bootstrap Template - Index</title>
    <meta content="" name="descriptison">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">

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

        <h1 class="logo mr-auto"><a href="/index"><img src="assets/img/logo.png" alt=""
                                                       id="logo-img"/>NBAPedia</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav class="main-nav d-none d-lg-block">
            <ul>
                <li><a href="/index">Home</a></li>
                <li><a href="/teams">Teams</a></li>
                <li><a href="/players">Players</a></li>
                <li><a href="/games">Schedule</a></li>
                <li><a href="/login" class="user-button user-button-border">Log In</a></li>
                <li class="active"><a href="/signup" class="user-button user-button-border">Sign Up</a></li>
            </ul>
        </nav><!-- .main-nav-->

    </div>
</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="sign-up-box" class="clearfix">
    <div class="container d-flex h-100" id="sign-up-form">
        <div class="row justify-content-center align-self-center" data-aos="fade-up">
            <div class="col-md-12 intro-info order-md-first order-last" data-aos="zoom-in"
                 data-aos-delay="100">
                <form class="form-signup" action="/signup" id="sign-up" method="post">
                    <h1 id="sign-in">Sign Up</h1>
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" id="username" name="username" class="form-control"
                           placeholder="Username" required="" autofocus="">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Password" required="">
                    <label class="sr-only" for="favTeam">Your favorite team</label>
                    <select class="form-control" name="favTeam" id="favTeam">
                        <option selected value="-1">Your favorite team</option>
                        <c:forEach items="${teams}" var="team">
                            <option value="${team.teamId}">${team.name}</option>
                        </c:forEach>
                    </select>
                    <div id="msg">${msg}</div>
                    <button class="btn btn-lg btn-primary btn-block submit" type="submit">Sign Up
                    </button>
                </form>
            </div>
        </div>
    </div>
</section><!-- End Hero -->

<!-- Vendor JS Files -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/counterup/counterup.min.js"></script>
<script src="assets/vendor/venobox/venobox.min.js"></script>
<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="assets/vendor/aos/aos.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

<script src="assets/js/main.js"></script>
<%if (request.getAttribute("succeed") != null && (boolean)request.getAttribute("succeed")) {%>
<script>
    setTimeout(function () {
        window.location.href = '/index'
    }, 3000)
</script>
<%}%>

</body>

</html>

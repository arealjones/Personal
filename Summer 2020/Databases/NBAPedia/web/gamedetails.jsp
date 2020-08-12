<%--
  Created by IntelliJ IDEA.
  User: yusun
  Date: 7/16/20
  Time: 5:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


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

<html>
<head>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

        <%--        Pulling from online--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <!-- =======================================================
        * Template Name: Rapid - v2.2.0
        * Template URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Game</title>
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
                <li class="active"><a href="/games">Schedule</a></li>
                <c:if test="<%=!loggedIn%>">
                    <li><a href="/login" class="user-button user-button-border">Log In</a></li>
                    <li><a href="/signup" class="user-button user-button-border">Sign Up</a></li>
                </c:if>
                <c:if test="<%=loggedIn%>">
                    <li class="drop-down"><a href="">Hi! <%=username%>
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

<style>
    .game-box {
        background: #EDEAE5;
        padding: 3% 0% 3% 0%;
    }
    .nav-pills a {
        background: #026670;
        color: white;
    }
    .nav-pills a:hover {
        background: #9FEDD7;
        color: #026670;
    }
    .game-box {
        border-style: solid;
        border-width: 1px;
        margin: 0% 0% 4% 0%;
    }
    .game-details-logo {
        height: 200px;
        width: 200px;
        object-fit: contain;
    }
    /*.tab-col {*/
    /*    margin: 4% 0% 0% 0%;*/
    /*}*/
</style>

<h1>${messages.title}</h1>
<div class="container">
    <div class="row">
        <div class="col-lg center-block text-center">
            <h1 style="color: black; font-size: 4em;"> <c:out value="${game.getHomeTeam().getName()} vs ${game.getAwayTeam().getName()} "></c:out></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 center-block text-center">
            <div class="game-box">
                <div class="row center-block text-center headshot-box">
                    <img class="game-details-logo" src="/assets/img/team_logos/${game.getHomeTeam().getShortName()}.png" alt="${game.getHomeTeam().getName()}">
                    <img class="game-details-logo" src="/assets/img/team_logos/${game.getAwayTeam().getShortName()}.png" alt="${game.getAwayTeam().getName()}">
                </div>
                <div class="game-info-box" >
                    <row>
                        <h4> <b style="color:#026670">GameId:</b> <c:out value="${game.getGameId()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">HomeTeamId:</b> <c:out value="${game.getHomeTeam().getTeamId()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">AwayTeamId:</b> <c:out value="${game.getAwayTeam().getTeamId()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">HomeTeamScore:</b> <c:out value="${game.getHomeTeamScore()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">AwayTeamScore:</b> <c:out value="${game.getAwayTeamScore()}"/> </h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">OTs:</b> <c:out value="${game.getOTs()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Date:</b> <c:out value="${game.getDate()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Playoff:</b> <c:out value="${game.isPlayOff()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Season:</b> <c:out value="${game.getSeason()}" /></h4>
                    </row>
                </div>
            </div>
        </div>
        <div class="col-lg tab-col">
            <ul class="nav nav-pills">
                <li><a data-toggle="pill" href="#menu1">Game Stats</a></li>
                <li><a data-toggle="pill" href="#menu2">Media</a></li>
            </ul>
            <div class="tab-content">
                <div id="menu1" class="tab-pane fade">
                    <h3>Game Stats</h3>
                    <div class="table-responsive">
                        <table id="gamestats_table" class="table table-striped table-bordered tablesorter">
                            <thead>
                            <tr>
                                <th>Players</th>
                                <th>FG</th>
                                <th>FGA</th>
                                <th>FGP</th>
                                <th>FG3</th>
                                <th>FG3A</th>
                                <th>FG3P</th>
                                <th>FT</th>
                                <th>FTA</th>
                                <th>FTP</th>
                                <th>ORB</th>
                                <th>DRB</th>
                                <th>TRB</th>
                                <th>AST</th>
                                <th>STL</th>
                                <th>TOV</th>
                                <th>PTS</th>
                                <th>PF</th>
                                <th>BLK</th>
                            </tr>
                            </thead>
                            <tbody id="gamestats_tbody">
                            <c:forEach items="${playerGameStatsList}" var="playerGameStats" >
                                <tr>
                                    <td><c:out value="${playerGameStats.getPlayerSeason().getPlayer().getName()}" /></td>
                                    <td><c:out value="${playerGameStats.getFG()}" /></td>
                                    <td><c:out value="${playerGameStats.getFGA()}" /></td>
                                    <td><c:out value="${playerGameStats.getFGP()}" /></td>
                                    <td><c:out value="${playerGameStats.getFG3()}" /></td>
                                    <td><c:out value="${playerGameStats.getFG3A()}" /></td>
                                    <td><c:out value="${playerGameStats.getFG3P()}" /></td>
                                    <td><c:out value="${playerGameStats.getFT()}" /></td>
                                    <td><c:out value="${playerGameStats.getFTA()}" /></td>
                                    <td><c:out value="${playerGameStats.getFTP()}" /></td>
                                    <td><c:out value="${playerGameStats.getORB()}" /></td>
                                    <td><c:out value="${playerGameStats.getDRB()}" /></td>
                                    <td><c:out value="${playerGameStats.getTRB()}" /></td>
                                    <td><c:out value="${playerGameStats.getAST()}" /></td>
                                    <td><c:out value="${playerGameStats.getSTL()}" /></td>
                                    <td><c:out value="${playerGameStats.getTOV()}" /></td>
                                    <td><c:out value="${playerGameStats.getPTS()}" /></td>
                                    <td><c:out value="${playerGameStats.getPF()}" /></td>
                                    <td><c:out value="${playerGameStats.getBLK()}" /></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div id="menu2" class="tab-pane fade">
                    <h3>Menu 2</h3>
                    <p> games media like youtube and instagram posts</p>
                </div>
            </div>

        </div>
    </div>
</div>

<footer class="container-fluid text-center" style="background-color: #026670; color: white;
font-size: 24px">
    <div class="container" style="margin-top: 40px; margin-bottom: 40px;">
        <div class="row">
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.wikipedia.org/" target="_blank" style="color: white">Wikipedia</a>
            </div>
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.basketball-reference.com/" target="_blank" style="color: white">BasketBall
                    Reference</a>
            </div>
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.nba.com/" target="_blank" style="color: white">NBA</a>
            </div>
        </div>
    </div>

    <div class="footer-copyright text-center py-3" style="font-size: 12px">© 2020
        Copyright: NBAPedia
    </div>
</footer>

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


<!-- load jQuery and tablesorter scripts -->
<script type="text/javascript" src="assets/js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="assets/js/jquery.tablesorter.js"></script>

<!-- tablesorter widgets (optional) -->
<script type="text/javascript" src="assets/js/jquery.tablesorter.widgets.js"></script>


<script>
  function goBack() {
    window.history.back();
  }
</script>

</body>
</html>

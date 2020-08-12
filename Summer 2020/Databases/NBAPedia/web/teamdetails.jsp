<%--
  Created by IntelliJ IDEA.
  User: arealjones
  Date: 7/15/20
  Time: 9:51 AM
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
    <title>Player</title>
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
                <li class="active"><a href="/teams">Teams</a></li>
                <li><a href="/players">Players</a></li>
                <li><a href="/games">Schedule</a></li>
                <c:if test="<%=!loggedIn%>">
                    <li><a href="/login" class="user-button user-button-border">Log In</a></li>
                    <li><a href="/signup" class="user-button user-button-border">Sign Up</a></li>
                </c:if>
                <c:if test="<%=loggedIn%>">
                    <li class="drop-down"><a href="">Hi! <%=username%>
                    </a>
                        <ul>
                            <li><a href="#">Account Settings</a></li>
                            <li><a href="javascript:location.href='/logout'">Log Out</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </nav><!-- .main-nav-->

    </div>
</header><!-- End Header -->

<style>
    .team-box {
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

    .team-box {
        border-style: solid;
        border-width: 1px;
        margin: 0% 0% 4% 0%;
    }

    .team-details-logo {
        height: 200px;
        width: 200px;
        object-fit: contain;
    }

    .btn-primary {
        font-weight: bold;
        cursor: pointer;
        border-radius: 1%;
        background-color: #026670;
        border-bottom: 1px solid black;
        padding: 10px;
        color: white;
        font-size: 20px;
    }

    /*.tab-col {*/
    /*    margin: 4% 0% 0% 0%;*/
    /*}*/
</style>

<h1>${messages.title}</h1>
<div class="container">
    <div class="row">
        <div class="col-lg center-block text-center">
            <h1 style="color:black; font-size: 4em;"> <c:out value="${team.getName()}"></c:out></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 center-block text-center">
            <div class="team-box">
                <div class="row center-block text-center headshot-box">
                    <img class="team-details-logo" src="/assets/img/team_logos/${team.getShortName()}.png" alt="${team.getName()}">
                </div>
                <div class="team-info-box" >
                    <row>
                        <h4> <b style="color:#026670">Full Name:</b> <c:out value="${team.getName()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Short Name:</b> <c:out value="${team.getShortName()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Years:</b> <c:out value="${team.getYears()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Total Games:</b> <c:out value="${team.getTotalGames()}"/></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Total Wins:</b> <c:out value="${team.getTotalWins()}"/> </h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Total Losses:</b> <c:out value="${team.getTotalLosses()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Champions:</b> <c:out value="${team.getChampions()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">Team Status:</b> <c:out value="${team.isActive()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">City:</b> <c:out value="${team.getCity()}" /></h4>
                    </row>
                    <row>
                        <h4> <b style="color:#026670">State:</b> <c:out value="${team.getState()}" /></h4>
                    </row>
                </div>
            </div>
        </div>
        <div class="col-lg tab-col">
            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#home">Bio</a></li>
                <li><a data-toggle="pill" href="#menu1">Season Stats</a></li>
                <li><a data-toggle="pill" href="#menu2">Current Players</a></li>
                <li><a data-toggle="pill" href="#menu3">Media</a></li>
            </ul>
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <h3>Team Bio</h3>
                    <p><c:out value="${team.getAbout()}"/></p>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <h3>Season Stats</h3>
                    <div class="table-responsive">
                        <table id="productSizes" class="table table-striped table-bordered tablesorter">
                            <thead>
                            <tr>
                                <th>Season</th>
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
                            <tbody id="myTable">
                            <c:forEach items="${teamSeasonStatsList}" var="season" >
                                <tr>
                                    <td><c:out value="${season.getSeason()}" /></td>
                                    <td><c:out value="${season.getFG()}" /></td>
                                    <td><c:out value="${season.getFGA()}" /></td>
                                    <td><c:out value="${season.getFGP()}" /></td>
                                    <td><c:out value="${season.getFG3()}" /></td>
                                    <td><c:out value="${season.getFG3A()}" /></td>
                                    <td><c:out value="${season.getFG3P()}" /></td>
                                    <td><c:out value="${season.getFT()}" /></td>
                                    <td><c:out value="${season.getFTA()}" /></td>
                                    <td><c:out value="${season.getFTP()}" /></td>
                                    <td><c:out value="${season.getORB()}" /></td>
                                    <td><c:out value="${season.getDRB()}" /></td>
                                    <td><c:out value="${season.getTRB()}" /></td>
                                    <td><c:out value="${season.getAST()}" /></td>
                                    <td><c:out value="${season.getSTL()}" /></td>
                                    <td><c:out value="${season.getTOV()}" /></td>
                                    <td><c:out value="${season.getPTS()}" /></td>
                                    <td><c:out value="${season.getPF()}" /></td>
                                    <td><c:out value="${season.getBLK()}" /></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div id="menu2" class="tab-pane fade">
                    <h3>Current Players</h3>
                    <div class="table-responsive">
                        <table id="productSize" class="table table-striped table-bordered tablesorter">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Height</th>
                                <th>Weight</th>
                                <th>BirthDate</th>
                                <th>Retired</th>
                            </tr>
                            </thead>
                            <tbody id="Table">
                            <c:forEach items="${playersList}" var="player" >
                                <tr>
                                    <td><a href="playerdetails?playerId=<c:out
                                    value="${player.getPlayerId()}"/>"><c:out value="${player.getName()}" /></a></td>
                                    <td><c:out value="${player.getPosition()}" /></td>
                                    <td><c:out value="${player.getHeight()}" /></td>
                                    <td><c:out value="${player.getWeight()}" /></td>
                                    <td><c:out value="${player.getBirthDate()}" /></td>
                                    <td><c:out value="${player.getRetired()}" /></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="menu3" class="tab-pane fade">
                    <h3>Media</h3>
                    <p> Player media like twitter and instagram posts</p>
                </div>
            </div>

        </div>
    </div>
</div>

<%--<div  style="background-color: #fdfcff; padding: 2%">--%>
<div  style="background-color: #FAF8FF; padding: 2%">
    <div class="container card-body">
        <h1> <b>Comments Section</b></h1>
        <c:forEach items="${teamCommentsList}" var="comment" >
            <div class="row centered-form center-block" >
                <div class="col-md center-block" style="">
                    <div class="g-mb-15">
                        <h4 class="h4 g-color-gray-dark-v1 mb-0"><c:out value="${comment.getCreated()}" /></h4>
                        <span class="g-color-gray-dark-v4 g-font-size-12"><c:out value="${comment.getUser().getUsername()}" /></span>
                    </div>
                    <p><c:out value="${comment.getContent()}" /></p>
                </div>
            </div>
            <hr>
        </c:forEach>


        <div class="row centered-form center-block" >
            <div class="col-md center-block" >
                <form class="form-comment" action="/teaminfo?teamId=1" id="commentForm"
                      method="post">
                    <div class="input-group">
                        <textarea class="form-control custom-control"
                                  style="resize:none; height: 100px; margin-bottom: 30px" id="comment" type="text" name="comment"
                                  required=""> </textarea>
                        <button style="margin-bottom: 10px" class="btn btn-primary" type="submit" id="commentSubmitBtn">Submit
                        </button>
                        <div id="commentmsg">Sign up or login to add comments</div>
                        <%--                        <div id="commentmsg">${addPlayerCommentMsg}</div>--%>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center" style="background-color: #026670; color: white;
font-size: 24px">
    <div class="container" style="margin-top: 50px; margin-bottom: 40px;">
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

<script>
  var commentMsg = document.getElementById("commentmsg");
  var username = "<%=username%>";
  if (username === "") {
    document.getElementById("commentSubmitBtn").disabled = true;
    commentMsg.style.display = "block";
  } else {
    document.getElementById("commentSubmitBtn").disabled = false;
    commentMsg.style.display = "none";
  }
</script>

</body>
</html>

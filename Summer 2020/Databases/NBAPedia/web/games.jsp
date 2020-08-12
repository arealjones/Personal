<%--
  Created by IntelliJ IDEA.
  User: yusun
  Date: 7/12/20
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
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

<h1>${messages.title}</h1>


<style>
    .row.schedules-row {
        padding: 2%;
        margin: 1%;
    }
    .container.schedule-container {
        background: #9FEDD7;
    }
    .search-box,
    select {
        width: 100%;
        height: 50px;
        font-size: 100%;
        font-weight: bold;
        cursor: pointer;
        border-radius: 0;
        background-color: #026670;
        border: none;
        border-bottom: 1px solid black;
        padding: 10px;
    }
    select {
        color: white;
        appearance: none;
        -webkit-appearance: none;
        -moz-appearance: none;
        padding: 10px;
    }
    /* For IE <= 11 */
    select::-ms-expand {
        display: none;
    }
    select:hover,
    select:focus {
        /*color: #c0392b;*/
        color: #026670;
        background-color: white;
        border-bottom-color: #DCDCDC;
    }
    .select-icon {
        position: absolute;
        top: 6px;
        right: 20px;
        width: 30px;
        height: 36px;
    }
    .select-icon svg.icon {
        transition: fill 0.3s ease;
        fill: white;
    }
    input {
        width: 85%;
    }
    .schedule-col {
        margin: 2% 0% 2% 0%;
    }
</style>

<!-- ======= Schedule Section ======= -->

<div class="container schedule-container">
    <div class="row schedules-row">
        <div class="col-lg center-block text-center schedule-col">
            <div class="search-box">
                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for gameId..">
                <button type="submit"><i class="fa fa-search"></i></button>
            </div>
        </div>
        <div class="col-lg center-block text-center schedule-col">
            <div class="input-select">
                <select data-trigger="" name="choices-single-default" onchange="filterGames(this, 1)">
                    <option value=''>Filter By HomeTeamName</option>
                    <option value='Atlanta Hawks'>Atlanta Hawks</option>
                    <option value='Boston Celtics'>Boston Celtics</option>
                    <option value='Brooklyn Nets'>Brooklyn Nets</option>
                    <option value='Charlotte Hornets'>Charlotte Hornets</option>
                    <option value='Chicago Bulls'>Chicago Bulls</option>
                    <option value='Cleveland Cavaliers'>Cleveland Cavaliers</option>
                    <option value='Dallas Mavericks'>Dallas Mavericks</option>
                    <option value='Denver Nuggets'>Denver Nuggets</option>
                    <option value='Detroit Pistons'>Detroit Pistons</option>
                    <option value='Golden State Warriors'>Golden State Warriors</option>
                    <option value='Houston Rockets'>Houston Rockets</option>
                    <option value='Indiana Pacers'>Indiana Pacers</option>
                    <option value='Los Angeles Clippers'>Los Angeles Clippers</option>
                    <option value='Los Angeles Lakers'>Los Angeles Lakers</option>
                    <option value='Memphis Grizzlies'>Memphis Grizzlies</option>
                    <option value='Miami Heat'>Miami Heat</option>
                    <option value='Milwaukee Bucks'>Milwaukee Bucks</option>
                    <option value='Minnesota Timberwolves'>Minnesota Timberwolves</option>
                    <option value='New Orleans Pelicans'>New Orleans Pelicans</option>
                    <option value='New York Knicks'>New York Knicks</option>
                    <option value='Oklahoma City Thunder'>Oklahoma City Thunder</option>
                    <option value='Orlando Magic'>Orlando Magic</option>
                    <option value='Philadelphia 76ers'>Philadelphia 76ers</option>
                    <option value='Phoenix Suns'>Phoenix Suns</option>
                    <option value='Portland Trail Blazers'>Portland Trail Blazers</option>
                    <option value='Sacramento Kings'>Sacramento Kings</option>
                    <option value='San Antonio Spurs'>San Antonio Spurs</option>
                    <option value='Toronto Raptors'>Toronto Raptors</option>
                    <option value='Utah Jazz'>Utah Jazz</option>
                    <option value='Washington Wizards'>Washington Wizards</option>
                    <option value='Anderson Packers'>Anderson Packers</option>
                    <option value='Baltimore Bullets'>Baltimore Bullets</option>
                    <option value='Chicago Stags'>Chicago Stags</option>
                    <option value='Cleveland Rebels'>Cleveland Rebels</option>
                    <option value='Denver Nuggets'>Denver Nuggets</option>
                    <option value='Detroit Falcons'>Detroit Falcons</option>
                    <option value='Indianapolis Jets'>Indianapolis Jets</option>
                    <option value='Indianapolis Olympians'>Indianapolis Olympians</option>
                    <option value='Kentucky Colonels'>Kentucky Colonels</option>
                    <option value='Memphis Sounds'>Memphis Sounds</option>
                    <option value='Pittsburgh Condors'>Pittsburgh Condors</option>
                    <option value='Pittsburgh Ironmen'>Pittsburgh Ironmen</option>
                    <option value='Providence Steam Rollers'>Providence Steam Rollers</option>
                    <option value='San Diego Sails'>San Diego Sails</option>
                    <option value='Sheboygan Red Skins'>Sheboygan Red Skins</option>
                    <option value='Spirits of St. Louis'>Spirits of St. Louis</option>
                    <option value='St. Louis Bombers'>St. Louis Bombers</option>
                    <option value='The Floridians'>The Floridians</option>
                    <option value='Toronto Huskies'>Toronto Huskies</option>
                    <option value='Utah Stars'>Utah Stars</option>
                    <option value='Virginia Squires'>Virginia Squires</option>
                    <option value='Washington Capitols'>Washington Capitols</option>
                </select>
                <div class="select-icon">
                    <svg focusable="false" viewBox="0 0 104 128" width="25" height="35" class="icon">
                        <path d="m2e1 95a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm0-3e1a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm0-3e1a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm14 55h68v1e1h-68zm0-3e1h68v1e1h-68zm0-3e1h68v1e1h-68z"></path>
                    </svg>
                </div>
            </div>
        </div>
        <div class="col-lg center-block text-center schedule-col">
            <div class="input-select">
                <select data-trigger="" name="choices-single-default" onchange="filterGames(this, 2)">
                    <option value=''>Filter By AwayTeamName</option>
                    <option value='Atlanta Hawks'>Atlanta Hawks</option>
                    <option value='Boston Celtics'>Boston Celtics</option>
                    <option value='Brooklyn Nets'>Brooklyn Nets</option>
                    <option value='Charlotte Hornets'>Charlotte Hornets</option>
                    <option value='Chicago Bulls'>Chicago Bulls</option>
                    <option value='Cleveland Cavaliers'>Cleveland Cavaliers</option>
                    <option value='Dallas Mavericks'>Dallas Mavericks</option>
                    <option value='Denver Nuggets'>Denver Nuggets</option>
                    <option value='Detroit Pistons'>Detroit Pistons</option>
                    <option value='Golden State Warriors'>Golden State Warriors</option>
                    <option value='Houston Rockets'>Houston Rockets</option>
                    <option value='Indiana Pacers'>Indiana Pacers</option>
                    <option value='Los Angeles Clippers'>Los Angeles Clippers</option>
                    <option value='Los Angeles Lakers'>Los Angeles Lakers</option>
                    <option value='Memphis Grizzlies'>Memphis Grizzlies</option>
                    <option value='Miami Heat'>Miami Heat</option>
                    <option value='Milwaukee Bucks'>Milwaukee Bucks</option>
                    <option value='Minnesota Timberwolves'>Minnesota Timberwolves</option>
                    <option value='New Orleans Pelicans'>New Orleans Pelicans</option>
                    <option value='New York Knicks'>New York Knicks</option>
                    <option value='Oklahoma City Thunder'>Oklahoma City Thunder</option>
                    <option value='Orlando Magic'>Orlando Magic</option>
                    <option value='Philadelphia 76ers'>Philadelphia 76ers</option>
                    <option value='Phoenix Suns'>Phoenix Suns</option>
                    <option value='Portland Trail Blazers'>Portland Trail Blazers</option>
                    <option value='Sacramento Kings'>Sacramento Kings</option>
                    <option value='San Antonio Spurs'>San Antonio Spurs</option>
                    <option value='Toronto Raptors'>Toronto Raptors</option>
                    <option value='Utah Jazz'>Utah Jazz</option>
                    <option value='Washington Wizards'>Washington Wizards</option>
                    <option value='Anderson Packers'>Anderson Packers</option>
                    <option value='Baltimore Bullets'>Baltimore Bullets</option>
                    <option value='Chicago Stags'>Chicago Stags</option>
                    <option value='Cleveland Rebels'>Cleveland Rebels</option>
                    <option value='Denver Nuggets'>Denver Nuggets</option>
                    <option value='Detroit Falcons'>Detroit Falcons</option>
                    <option value='Indianapolis Jets'>Indianapolis Jets</option>
                    <option value='Indianapolis Olympians'>Indianapolis Olympians</option>
                    <option value='Kentucky Colonels'>Kentucky Colonels</option>
                    <option value='Memphis Sounds'>Memphis Sounds</option>
                    <option value='Pittsburgh Condors'>Pittsburgh Condors</option>
                    <option value='Pittsburgh Ironmen'>Pittsburgh Ironmen</option>
                    <option value='Providence Steam Rollers'>Providence Steam Rollers</option>
                    <option value='San Diego Sails'>San Diego Sails</option>
                    <option value='Sheboygan Red Skins'>Sheboygan Red Skins</option>
                    <option value='Spirits of St. Louis'>Spirits of St. Louis</option>
                    <option value='St. Louis Bombers'>St. Louis Bombers</option>
                    <option value='The Floridians'>The Floridians</option>
                    <option value='Toronto Huskies'>Toronto Huskies</option>
                    <option value='Utah Stars'>Utah Stars</option>
                    <option value='Virginia Squires'>Virginia Squires</option>
                    <option value='Washington Capitols'>Washington Capitols</option>
                </select>
                <div class="select-icon">
                    <svg focusable="false" viewBox="0 0 104 128" width="25" height="35" class="icon">
                        <path d="m2e1 95a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm0-3e1a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm0-3e1a9 9 0 0 1 -9 9 9 9 0 0 1 -9 -9 9 9 0 0 1 9 -9 9 9 0 0 1 9 9zm14 55h68v1e1h-68zm0-3e1h68v1e1h-68zm0-3e1h68v1e1h-68z"></path>
                    </svg>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="table-responsive">
        <table id="productSizes" class="table table-striped table-bordered tablesorter">
            <thead>
            <tr>
                <th>
                    GameId
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
                <th>
                    HomeTeamName
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
                <th>
                    AwayTeamName
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
                <th>
                    HomeTeamScore
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
                <th>
                    AwayTeamScore
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
                <th>
                    Date
                    <span class="glyphicon glyphicon-triangle-bottom"></span>
                    <span class="glyphicon glyphicon-triangle-top"></span>
                </th>
            </tr>
            </thead>
            <tbody id="myTable">
            <c:forEach items="${gamesList}" var="game" >
                <tr>
                    <td><a href="gameinfo?gameId=<c:out value="${game.getGameId()}"/>"><c:out value="${game.getGameId()}" /></a></td>
                    <td><c:out value="${game.getAwayTeam().getName()}" /></td>
                    <td><c:out value="${game.getHomeTeam().getName()}" /></td>
                    <td><c:out value="${game.getHomeTeamScore()}" /></td>
                    <td><c:out value="${game.getAwayTeamScore()}" /></td>
                    <td><c:out value="${game.getDate()}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>

<footer class="container-fluid text-center" style="background-color: #026670; color: white;
font-size: 24px">
    <div class="container" style="padding-top: 40px; margin-bottom: 40px;">
        <div class="row">
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.wikipedia.org/" target="_blank" style="color:white">Wikipedia</a>
            </div>
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.basketball-reference.com/" target="_blank" style="color:white">BasketBall
                    Reference</a>
            </div>
            <div class="col-sm-4 center-block text-center">
                <a href="https://www.nba.com/" target="_blank" style="color:white">NBA</a>
            </div>
        </div>
    </div>

    <div class="footer-copyright text-center py-3" style="font-size: 12px">© 2020
        Copyright: NBAPedia
    </div>
</footer>
<!-- End Games -->


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

<%-- Search Bar and filter bar --%>
<script>
  function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("productSizes");
    tr = table.getElementsByTagName("tr");
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }
</script>

<script>
  function filterGames(obj, index) {
    var filter, table, tr, td, i, txtValue;
    filter = obj.value.toUpperCase();
    table = document.getElementById("productSizes");
    tr = table.getElementsByTagName("tr");
    // Displays all of the games
    if (obj.value === '') {
      for (i = 0; i < tr.length; i++) {
        tr[i].style.display = "";
      }
    }
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[index];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }
</script>

<%-- For sorting games table--%>
<script>
  $(function() {
    $("#productSizes").tablesorter();
  });
</script>

<script>
  $(function() {
    $("#productSizes").tablesorter({ sortList: [[0,0], [1,0]] });
  });
</script>

</html>
<%--
  Created by IntelliJ IDEA.
  User: yusun
  Date: 7/12/20
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>PlayerAwards</title>
</head>
<body>
<h1>${messages.title}</h1>
<table border="1">
    <tr>
        <th>PlayerAwardId</th>
        <th>Award</th>
        <th>Season</th>
        <th>PlayerId</th>
        <th>PlayerSeasonId</th>
        <th>Delete PlayerAwards</th>
    </tr>
    <c:forEach items="${playerAwards}" var="playerAward" >
        <tr>
            <td><c:out value="${playerAward.getPlayerAwardId()}" /></td>
            <td><c:out value="${playerAward.getAward()}" /></td>
            <td><c:out value="${playerAward.getSeason()}" /></td>
            <td><c:out value="${playerAward.getPlayer().getPlayerId()}" /></td>
            <td><c:out value="${playerAward.getPlayerSeason().getPlayerSeasonId()}" /></td>
            <td><a href="deleteplayerAwards?playerAwardId=<c:out value="${playerAward.getPlayerAwardId()}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

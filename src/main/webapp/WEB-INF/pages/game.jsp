<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Hangman</title>

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/lib/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>

</head>

<body>

<h1>${message}</h1>

<div id="main">

    <div id="guess">
        <ul id="wordToGuess">
            <c:forEach var="i" begin="1" end="${characterCount}">
                <li class="guess">_</li>
            </c:forEach>
        </ul>
    </div>

    <div id="buttons">
        <ul id="alphabet">
            <c:forEach var="letter" items="${availableLetters}">
                <li id="letter">${letter}</li>
            </c:forEach>
        </ul>
    </div>

</div>


</body>

</html>
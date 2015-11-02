<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Hangman stats</title>

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<h1>Game Stats</h1>

<div id="main">

    <table id="statsTable">
        <tr>
            <th>No</th>
            <th>Word to Guess</th>
            <th>Current State</th>
            <th>Guesses Left</th>
        </tr>
        <c:forEach var="gameState" items="${currentGamesList}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${gameState.wordToGuess}</td>
                <td class="placeholder">${gameState.placeholderWord}</td>
                <td>${gameState.guessesLeft}</td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
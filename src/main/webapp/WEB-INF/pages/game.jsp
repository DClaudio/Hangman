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

<h1>${title}</h1>

<div id="main">

    <div id="guess">
        <ul id="wordToGuess">
            <c:forEach var="idx" begin="0" end="${characterCount - 1}">
                <li class="guess" data-index="${idx}">_</li>
            </c:forEach>
        </ul>
    </div>

    <p id="guessesLeft">You have <span id="count">${numberOfGuesses}</span> guesses left</p>

    <p id="winnerMessage">Congratulations you have won!</p>
    <p id="loserMessage">Game Over!</p>

    <div id="buttons">
        <ul id="characters">
            <c:forEach var="character" items="${availableLetters}">
                <li data-guess-char="${character}">${character}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="container">
        <a id="reset" href="">Play again</a>
    </div>

    <script type='text/javascript'>
        $(document).ready(function () {
            Hangman.init("${wordToGuess}", ${numberOfGuesses});
        });
    </script>

</div>


</body>

</html>
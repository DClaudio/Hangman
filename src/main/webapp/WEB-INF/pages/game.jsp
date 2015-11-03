<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@ taglib prefix="ju" uri="/WEB-INF/pages/JsonUtils.tld"--%>

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
        <p>${gameState.placeholderWord}</p>
    </div>

    <p id="guessesLeft">You have <span id="count">${gameState.guessesLeft}</span> guesses left</p>

    <p id="winnerMessage">Congratulations you have won!</p>

    <p id="loserMessage">Game Over! The word was &lt; ${gameState.wordToGuess} &gt;</p>

    <div id="buttons">
        <ul id="characters">
            <c:forEach var="character" items="${availableLetters}">
                <li data-guess-char="${character}">${character}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="container">
        <a id="resetGame" href="newgame">Play again</a>
    </div>

    <script type='text/javascript'>
        $(document).ready(function () {
            HangmanGame.init({
                wordToGuess: "${gameState.wordToGuess}",
                placeholderWord: "${gameState.placeholderWord}",
                guessesLeft:${gameState.guessesLeft},
                charactersTriedList:[]
            }, '${sessionId}');
        });
    </script>

</div>


</body>

</html>

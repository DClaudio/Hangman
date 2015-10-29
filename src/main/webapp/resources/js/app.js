var HangmanGame = function () {

    var wordToGuess;
    var guessesLeftCount;
    var remainingCharCount;
    var guesses = [];

    function bindEvents() {
        $("#characters li").click(function (eventObject) {
            $(eventObject.currentTarget).hide();
            var guessChar = $(this).data("guess-char");
            guesses.push(guessChar);
            var occurrences = getIndexesOfChar(guessChar);

            if (occurrences.length > 0) {
                //good guess
                for (var i = 0; i < occurrences.length; i++) {
                    $("#wordToGuess li[data-index=" + occurrences[i] + "]").text(wordToGuess[occurrences[i]]);
                }
                remainingCharCount = remainingCharCount - occurrences.length;
                if (remainingCharCount === 0) showGameOverMessage("winner");
            } else {
                // bad guess
                $("#guessesLeft span#count").text(--guessesLeftCount);
                if (guessesLeftCount === 0) showGameOverMessage("loser");
            }
        });
    }

    var init = function (word, numberOfGuesses) {
        wordToGuess = word;
        remainingCharCount = word.length;
        guessesLeftCount = numberOfGuesses;
        bindEvents();
    };

    function getIndexesOfChar(character) {
        var idx = [];
        for (var i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i].toLowerCase() === character) idx.push(i);
        }
        return idx;
    }

    function showGameOverMessage(outcome) {
        $("#characters li").addClass("gameOver").off();
        $("#" + outcome + "Message").show();
    }


    return {
        "init": init
    }
}();

var HangmanLogic = function () {

    var getOccurrencesPos = function (wordToGuess, letter) {
        var idxs = [];
        for (var i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i].toLowerCase() === letter) idxs.push(i);
        }
        return idxs;
    };

    var processLetterGuess = function (gameState, letter) {
        var occurrences = getOccurrencesPos(gameState.wordToGuess, letter);
        var newStr = gameState.placeholderWord;
        for (var i = 0; i < occurrences.length; i++) {
            var letterPos = occurrences[i];
            newStr = newStr.substr(0, letterPos) + gameState.wordToGuess[letterPos] + newStr.substr(letterPos + 1);
        }
        return {
            wordToGuess: gameState.wordToGuess,
            placeholderWord: newStr,
            guessesLeft: (occurrences.length === 0) ? gameState.guessesLeft - 1 : gameState.guessesLeft
        };
    };

    var isGameWon = function (gameState) {
        if (gameState.wordToGuess === gameState.placeholderWord) return true;
        else return false;
    };

    return {
        "getOccurrencesPos": getOccurrencesPos,
        "processLetterGuess": processLetterGuess,
        "isGameWon": isGameWon
    }
}();
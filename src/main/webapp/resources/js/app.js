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
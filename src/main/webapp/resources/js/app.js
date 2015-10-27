var Hangman = function () {

    var wordToGuess = "";
    var guessesCount = 5;
    var guesses = [];

    function getIndexesOfChar(character) {
        var idx = [];
        for (var i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i].toLowerCase() === character) idx.push(i);
        }
        return idx;
    }

    function bindEvents() {
        $("#characters li").click(function () {
            $(this).hide();
            var guessChar = $(this).data("guess-char");
            guesses.push(guessChar);
            var occurrences = getIndexesOfChar(guessChar);
            if (occurrences.length > 0) {
                //good guess
                for (var i = 0; i < occurrences.length; i++) {
                    $("#wordToGuess li[data-index=" +occurrences[i] + "]").text(wordToGuess[occurrences[i]]);
                }

            } else {
                $("#guessesLeft span#count").text(--guessesCount)
            }
        });
    }

    var init = function (word, numberOfGuesses) {
        wordToGuess = word;
        guessesCount = numberOfGuesses;
        bindEvents();
    };


    return {
        "init": init
    }
}();
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
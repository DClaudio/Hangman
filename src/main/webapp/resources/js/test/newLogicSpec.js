describe("new approach app", function () {

    it("should return position of character occurrences", function () {
        expect(HangmanLogic.getOccurrencesPos("Hangman", 'c')).toEqual([]);
        expect(HangmanLogic.getOccurrencesPos("Hangman", 'h')).toEqual([0]);
        expect(HangmanLogic.getOccurrencesPos("Hangman", 'a')).toEqual([1, 5]);
    });

    it("should check if game is won", function () {
        var gameStateNotWonYet = {wordToGuess: "Test", placeholderWord: "T__t", guessesLeft: 5};
        expect(HangmanLogic.isGameWon(gameStateNotWonYet)).toEqual(false);

        var gameStateNotWon =  {wordToGuess: "Test", placeholderWord: "Test", guessesLeft: 3};
        expect(HangmanLogic.isGameWon(gameStateNotWon)).toEqual(true);


       // expect(HangmanLogic.isGameWon("Test", "Test")).toEqual(true);
    });

    it("process letter guess", function () {
        // game state representation: wordToGuess, placeholderWord, guessesLeft
        var testGameState = {wordToGuess: "Test", placeholderWord: "____", guessesLeft: 5};

        var expectedGameState1 = {wordToGuess: "Test", placeholderWord: "____", guessesLeft: 4};
        expect(HangmanLogic.processLetterGuess(testGameState, 'x')).toEqual(expectedGameState1);

        var expectedGameState2 = {wordToGuess: "Test", placeholderWord: "T__t", guessesLeft: 5};
        expect(HangmanLogic.processLetterGuess(testGameState, 't')).toEqual(expectedGameState2);
    });

});


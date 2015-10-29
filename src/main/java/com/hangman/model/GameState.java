package com.hangman.model;


public class GameState {

    private String wordToGuess;
    private String placeholderWord;
    private int guessesLeft;

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getPlaceholderWord() {
        return placeholderWord;
    }

    public void setPlaceholderWord(String placeholderWord) {
        this.placeholderWord = placeholderWord;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public void setGuessesLeft(int guessesLeft) {
        this.guessesLeft = guessesLeft;
    }

    public GameState(String wordToGuess, String placeholderWord, int guessesLeft) {
        this.wordToGuess = wordToGuess;
        this.placeholderWord = placeholderWord;
        this.guessesLeft = guessesLeft;
    }
}

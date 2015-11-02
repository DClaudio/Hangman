package com.hangman.model;


import java.util.List;

public class GameState {

    private String wordToGuess;
    private String placeholderWord;
    private int guessesLeft;
    private List<Character> charactersTriedList;

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

    public List<Character> getCharactersTriedList() {
        return charactersTriedList;
    }

    public void setCharactersTriedList(List<Character> charactersTriedList) {
        this.charactersTriedList = charactersTriedList;
    }

    public GameState(String wordToGuess, String placeholderWord, int guessesLeft, List<Character> charactersTriedList) {
        this.wordToGuess = wordToGuess;
        this.placeholderWord = placeholderWord;
        this.guessesLeft = guessesLeft;
        this.charactersTriedList = charactersTriedList;
    }

    public GameState() {
        super();
    }
}

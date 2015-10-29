package com.hangman.dao;


import com.hangman.model.GameState;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GameStateDAO {

    private List<String> wordList;
    public static int GUESSES_ALLOWED = 5;


    public GameStateDAO() {
        wordList = new ArrayList<>();
        wordList.add("Test");
        wordList.add("Hangman");
    }

    public String retrieveRandomWord() {
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

    public GameState retrieveStartGameState() {
        String randomWord = retrieveRandomWord();
        return new GameState(randomWord, randomWord.replaceAll(".", "_"), GUESSES_ALLOWED);
    }
}

package com.hangman.dao;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GuessWordsDAO {

    private List<String> wordList;


    public GuessWordsDAO() {
        wordList = new ArrayList<>();
        wordList.add("Test");
        wordList.add("Hangman");
    }

    public String retrieveRandomWord() {
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
}

package com.hangman.dao;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GuessWordsDAOTest {

    private GuessWordsDAO guessWordsDao = new GuessWordsDAO();

    @Test
    public void getRandomWord(){
        String word = guessWordsDao.retrieveRandomWord();
        assertNotNull(word);
    }
}

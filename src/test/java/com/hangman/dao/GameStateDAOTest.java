package com.hangman.dao;


import com.hangman.model.GameState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameStateDAOTest {

    private GameStateDAO gameStateDao = new GameStateDAO();

    @Test
    public void testRetrieveRandomWord() {
        String word = gameStateDao.retrieveRandomWord();
        assertNotNull(word);
    }

    @Test
    public void testRetrieveStartGameState() {
        GameState gs = gameStateDao.retrieveStartGameState();
        assertNotNull("Game State Not Null", gs);
        assertEquals("Length of word to guess vs placeholder ", gs.getWordToGuess().length(), gs.getPlaceholderWord().length());
        assertEquals("placeholder word", gs.getWordToGuess().replaceAll(".", "_"),gs.getPlaceholderWord());
        assertEquals("guesses allowed", GameStateDAO.GUESSES_ALLOWED, gs.getGuessesLeft());
    }

    @Test
    public void testRetrieveGameState(){
        GameState gs = gameStateDao.retrieveGameState("sessionIdTest");

        assertNotNull("Game State Not Null", gs);
        assertEquals("Length of word to guess vs placeholder ", gs.getWordToGuess().length(), gs.getPlaceholderWord().length());
        assertEquals("placeholder word", gs.getWordToGuess().replaceAll(".", "_"),gs.getPlaceholderWord());
        assertEquals("guesses allowed", GameStateDAO.GUESSES_ALLOWED, gs.getGuessesLeft());
    }
}

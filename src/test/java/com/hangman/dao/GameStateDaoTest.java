package com.hangman.dao;


import com.hangman.model.GameState;
import com.hangman.model.GameStateRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameStateDaoTest {


    private GameStateRepository mockStateRepository;
    private GameStateDAO gameStateDao;

    @Before
    public void setUp() {
        mockStateRepository = EasyMock.createMock(GameStateRepository.class);
        gameStateDao = new GameStateDAO();
        gameStateDao.setGameStateRepository(mockStateRepository);
    }

    @Test
    public void testRetrieveRandomWord() {
        String word = gameStateDao.retrieveRandomWord();
        assertNotNull(word);
    }

    @Test
    public void testGenerateStartGameState() {
        GameState gs = gameStateDao.generateStartGameState();
        assertNotNull("Game State Not Null", gs);
        assertEquals("Length of word to guess vs placeholder ", gs.getWordToGuess().length(), gs.getPlaceholderWord().length());
        assertEquals("placeholder word", gs.getWordToGuess().replaceAll(".", "_"), gs.getPlaceholderWord());
        assertEquals("guesses allowed", GameStateDAO.GUESSES_ALLOWED, gs.getGuessesLeft());
    }

    @Test
    public void testRetrieveGameStateForNewGame() {
        String testSessionId = "testSessionId";
        GameState expectedGameState = new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED);
        //configure mock
        EasyMock.expect(mockStateRepository.getById(testSessionId)).andReturn(null);
        EasyMock.expect(mockStateRepository.insert(isA(String.class), isA(GameState.class))).andReturn(expectedGameState);
        EasyMock.replay(mockStateRepository);

        // exercise method
        GameState gs = gameStateDao.retrieveGameState(testSessionId);

        //assert results
        assertNotNull("Game State Not Null", gs);
        assertEquals("Length of word to guess vs placeholder ", gs.getWordToGuess().length(), gs.getPlaceholderWord().length());
        assertEquals("placeholder word", gs.getWordToGuess().replaceAll(".", "_"), gs.getPlaceholderWord());
        assertEquals("guesses allowed", GameStateDAO.GUESSES_ALLOWED, gs.getGuessesLeft());
        EasyMock.verify(mockStateRepository);
    }

    @Test
    public void testGetGameSate() {
        String testSessionId = "testSessionId";
        GameState expectedGameState = new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED);

        EasyMock.expect(mockStateRepository.getById(testSessionId)).andReturn(expectedGameState);
        EasyMock.replay(mockStateRepository);

        assertEquals("get game state", expectedGameState, gameStateDao.getGameSate(testSessionId));
        EasyMock.verify(mockStateRepository);
    }

    @Test
    public void testUpdateGameState() {
        String testSessionId = "testSessionId";
        GameState expectedGameState = new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED);

        EasyMock.expect(mockStateRepository.update(testSessionId, expectedGameState)).andReturn(expectedGameState);
        EasyMock.replay(mockStateRepository);

        assertEquals("get game state", expectedGameState, gameStateDao.updateGameState(testSessionId, expectedGameState));
        EasyMock.verify(mockStateRepository);
    }


    @Test
    public void testGetCurrentGames() {
        List<GameState> currentGames = new ArrayList<>();
        currentGames.add(new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED));
        currentGames.add(new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED - 1));

        EasyMock.expect(mockStateRepository.getAll()).andReturn(currentGames);
        EasyMock.replay(mockStateRepository);

        assertEquals("get current games", currentGames, gameStateDao.getCurrentGames());
        EasyMock.verify(mockStateRepository);
    }


    @Test
    public void testDeleteGameState() {
        String stateId = "tstStateId";
        GameState stateToDelete = new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED);

        EasyMock.expect(mockStateRepository.delete(stateId)).andReturn(stateToDelete);
        EasyMock.replay(mockStateRepository);

        assertEquals("delete state", stateToDelete, gameStateDao.deleteGameSate(stateId));
        EasyMock.verify(mockStateRepository);
    }
}

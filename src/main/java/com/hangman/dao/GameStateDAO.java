package com.hangman.dao;


import com.hangman.model.GameState;
import com.hangman.model.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GameStateDAO {

    @Autowired
    private GameStateRepository gameStateRepository;

    private List<String> wordList;
    public static int GUESSES_ALLOWED = 5;//TODO: put this in a configuration file

    public GameStateRepository getGameStateRepository() {
        return gameStateRepository;
    }

    public void setGameStateRepository(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public GameStateDAO() {
        wordList = new ArrayList<>();
        wordList.add("Test");
        wordList.add("Hangman");
    }

    public String retrieveRandomWord() {
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

    public GameState generateStartGameState() {
        String randomWord = retrieveRandomWord();
        GameState gs = new GameState(randomWord, randomWord.replaceAll(".", "_"), GUESSES_ALLOWED);
        return gs;
    }

    public GameState retrieveGameState(String sessionId) {
        GameState gs = gameStateRepository.getById(sessionId);
        if (gs == null) {
            gs = generateStartGameState();
            gameStateRepository.insert(sessionId, gs);
        }
        return gs;

    }

    public GameState getGameSate(String sessionId) {
        return gameStateRepository.getById(sessionId);
    }


    public GameState updateGameState(String sessionId, GameState gameState) {
        return  gameStateRepository.update(sessionId, gameState);
    }
}

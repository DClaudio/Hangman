package com.hangman.dao;


import com.hangman.model.GameState;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GameStateDAO {

    private List<String> wordList;
    private Map<String, GameState> gameStateRepository;
    public static int GUESSES_ALLOWED = 5;

    public Map<String, GameState> getGameStateRepository() {
        return gameStateRepository;
    }

    public void setGameStateRepository(Map<String, GameState> gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public GameStateDAO() {
        wordList = new ArrayList<>();
        wordList.add("Test");
        wordList.add("Hangman");

        gameStateRepository = new HashMap<String, GameState>();
    }

    public String retrieveRandomWord() {
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

    public GameState retrieveStartGameState() {
        String randomWord = retrieveRandomWord();
        GameState gs = new GameState(randomWord, randomWord.replaceAll(".", "_"), GUESSES_ALLOWED);
        return gs;
    }

    public GameState retrieveGameState(String sessionId) {
        GameState gs = null;
        if(gameStateRepository.containsKey(sessionId)){
            gs= gameStateRepository.get(sessionId);
        }else{
            gameStateRepository.put(sessionId, gs);
            gs = retrieveStartGameState();
        }
        return gs;
    }
}

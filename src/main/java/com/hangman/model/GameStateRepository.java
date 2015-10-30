package com.hangman.model;


public interface GameStateRepository {

    GameState getById(String sessionId);

    GameState insert(String sessionId, GameState gs);

    GameState update(String testSessionId, GameState expectedGameState);

}

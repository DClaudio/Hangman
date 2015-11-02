package com.hangman.model;


import java.util.List;

public interface GameStateRepository {

    GameState getById(String sessionId);

    GameState insert(String sessionId, GameState gs);

    GameState update(String testSessionId, GameState expectedGameState);

    List<GameState> getAll();

    GameState delete(String stateId);
}

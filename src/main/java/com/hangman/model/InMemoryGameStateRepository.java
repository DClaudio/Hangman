package com.hangman.model;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryGameStateRepository implements GameStateRepository {

    private Map<String, GameState> gameStateDB = new HashMap<>();

    @Override
    public GameState getById(String sessionId) {
        return gameStateDB.get(sessionId);
    }

    @Override
    public GameState insert(String sessionId, GameState gs) {
        return gameStateDB.put(sessionId, gs);
    }

    @Override
    public GameState update(String sessionId, GameState gs) {
        return gameStateDB.put(sessionId, gs);
    }

    @Override
    public List<GameState> getAll() {
        return new ArrayList<>(gameStateDB.values());
    }

    @Override
    public GameState delete(String stateId) {
        return gameStateDB.remove(stateId);
    }
}

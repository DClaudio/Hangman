package com.hangman.controllers;

import com.hangman.dao.GameStateDAO;
import com.hangman.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/current_games",
        produces = {"application/json"})
public class SessionApi {

    Logger logger = Logger.getLogger(SessionApi.class.getName());

    @Autowired
    private GameStateDAO gameStateDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GameState getGameState(@PathVariable("id") String sessionId) {
        return gameStateDAO.getGameSate(sessionId);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public GameState updateGameState(@PathVariable("id") String sessionId, @RequestBody GameState gameState) {
        return gameStateDAO.updateGameState(sessionId, gameState);
    }

//
//    @ModelAttribute
//    public void setVaryResponseHeader(HttpServletResponse response) {
//        response.setHeader("Vary", "Accept");
//    }


}

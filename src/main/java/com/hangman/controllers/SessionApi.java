package com.hangman.controllers;

import com.hangman.dao.GameStateDAO;
import com.hangman.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/session",
        produces = {"application/json"})
public class SessionApi {

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

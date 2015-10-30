package com.hangman.controllers;

import com.hangman.dao.GameStateDAO;
import com.hangman.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class GameController {

    private static char[] alphabetLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Autowired
    private GameStateDAO gameStateDAO;

    @RequestMapping(method = RequestMethod.GET)
    @Scope("session")
    public String mainGameView(ModelMap model, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        GameState startGameState = gameStateDAO.retrieveGameState(sessionId);
        model.addAttribute("title", "Welcome to Hangman!");
        model.addAttribute("gameState", startGameState);
        model.addAttribute("sessionId", sessionId);
        model.addAttribute("availableLetters", alphabetLetters);
        return "game";
    }

}
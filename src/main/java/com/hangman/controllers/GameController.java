package com.hangman.controllers;

import com.hangman.dao.GameStateDAO;
import com.hangman.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GameController {

    private static char[] alphabetLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Autowired
    private GameStateDAO gameStateDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String mainGameView(ModelMap model) {
        GameState startGameState = gameStateDAO.retrieveStartGameState();
        model.addAttribute("title", "Welcome to Hangman!");
        model.addAttribute("gameState", startGameState);
        model.addAttribute("availableLetters", alphabetLetters);
        return "game";
    }

}
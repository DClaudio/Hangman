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
import javax.servlet.http.HttpSession;

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
        GameState gameState = gameStateDAO.retrieveGameState(sessionId);
        model.addAttribute("title", "Welcome to Hangman!");
        model.addAttribute("gameState", gameState);
        model.addAttribute("sessionId", sessionId);
        model.addAttribute("availableLetters", alphabetLetters);
        return "game";
    }

    @RequestMapping(method = RequestMethod.GET, value = "newgame")
    @Scope("session")
    public String newGame(HttpServletRequest request){
        //remove http session
        HttpSession session = request.getSession();
        //remove saved game state
        gameStateDAO.deleteGameSate(session.getId());
        session.invalidate();
        return "redirect:/";
    }

}
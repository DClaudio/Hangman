package com.hangman.controllers;

import com.hangman.dao.GameStateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    GameStateDAO gameStateDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello from stats page!");
        model.addAttribute("currentGamesList", gameStateDAO.getCurrentGames());
        return "stats";
    }
}
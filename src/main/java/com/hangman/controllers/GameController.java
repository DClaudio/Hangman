package com.hangman.controllers;

import com.hangman.dao.GuessWordsDAO;
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
    private GuessWordsDAO guessWordsDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String mainGameView(ModelMap model) {

        String wordToGuess = guessWordsDAO.retrieveRandomWord();

        model.addAttribute("title", "Welcome to Hangman!");
        model.addAttribute("wordToGuess", wordToGuess);//get from database
        model.addAttribute("characterCount", wordToGuess.length());
        model.addAttribute("numberOfGuesses", 5);//make it configurable
        model.addAttribute("availableLetters", alphabetLetters);
        return "game";
    }

}
package com.hangman.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests extends BaseControllerTest {


    @Test
    public void testGameView() throws Exception {
        mockMvc.perform(get("/").session(mockSession))
                .andExpect(status().isOk())
                .andExpect(view().name("game"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("gameState"))
                .andExpect(model().attributeExists("gameState"))
                .andExpect(model().attributeExists("sessionId"))
                .andExpect(model().attributeExists("availableLetters"));
    }

    @Test
    public void testStatsView() throws Exception {
        mockMvc.perform(get("/stats"))
                .andExpect(status().isOk())
                .andExpect(view().name("stats"))
                .andExpect(model().attributeExists("currentGamesList"));
    }
}

package com.hangman.controllers;


import com.hangman.dao.GameStateDAO;
import com.hangman.model.GameState;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SessionApiTest extends BaseControllerTest {

    @Test
    public void testSessionApiGET() throws Exception {
        String sessionId = "testSesId";

        mockMvc.perform(get("/current_games/{id}", sessionId).contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
    }


    @Test
    public void testSessionApiPUT() throws Exception {
        String sessionId = "testSesId";
        GameState expectedGameState  = new GameState("Test", "____", GameStateDAO.GUESSES_ALLOWED, TestUtil.EMPTY_LIST);

        mockMvc.perform(put("/current_games/{id}", sessionId)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(expectedGameState)))
                .andExpect(status().isOk());
        //.andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }
}

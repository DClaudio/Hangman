package com.hangman.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Logger;

@ControllerAdvice
public class ControllerErrorHandler {
//    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
//
//    @ExceptionHandler(TodoNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public void handleTodoNotFoundException(TodoNotFoundException ex) {
//        LOGGER.debug("handling 404 error on a todo entry");
//    }
}

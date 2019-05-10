package edu.erm.appstoreserver;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AppProductNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AppProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(AppProductNotFoundException ex) {
        return ex.getMessage();
    }
}
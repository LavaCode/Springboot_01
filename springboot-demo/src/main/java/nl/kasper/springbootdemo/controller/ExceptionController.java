package nl.kasper.springbootdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import nl.kasper.springbootdemo.exception.RecordNotFoundException;

@RestController
@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return (ResponseEntity<Object>)ResponseEntity.notFound().build();
    }
}

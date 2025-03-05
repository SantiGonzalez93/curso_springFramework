package santi.curso.springboot_exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import santi.curso.springboot_exceptions.exceptions.UserNotFoundException;
import santi.curso.springboot_exceptions.models.ErrorDto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> divisionByZero(Exception e){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> nullPointerException(Exception e) {
        Map<String, Object> error = new HashMap<>();
        error.put("Date", new Date());
        error.put("error", "Roll no existe");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> numberFormatException(Exception e) {
        Map<String, Object> error = new HashMap<>();
        error.put("Date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> notFound(NoHandlerFoundException e) {
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setError("Api rest not Found");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }

}

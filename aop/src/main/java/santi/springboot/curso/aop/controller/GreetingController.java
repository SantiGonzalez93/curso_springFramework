package santi.springboot.curso.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import santi.springboot.curso.aop.service.IGreetingService;
import java.util.Collections;


@RestController
public class GreetingController {

    @Autowired
    private IGreetingService service;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity.ok(Collections.singletonMap("greeting", service.sayHello("Santi", "Hi, How are you?")));
    }
}

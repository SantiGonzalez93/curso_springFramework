package santi.curso.springboot_exceptions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import santi.curso.springboot_exceptions.exceptions.UserNotFoundException;
import santi.curso.springboot_exceptions.models.domain.User;
import santi.curso.springboot_exceptions.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserService service;

    @GetMapping
    public String index() {
        //Aritmetic error
        int value = Integer.parseInt("10x");
        return "OK 200";
    }
    @GetMapping("/show/{id}")
    public User findById(@PathVariable Long id) {
        User user = service.findById(id).orElseThrow(()-> new UserNotFoundException("Error el usuario no existe"));
        if (user == null){
            throw new UserNotFoundException("Useuario Nulo");
        }
        return user;
    }
    @GetMapping("/show")
    public List<User> findAll() {
        return service.findAll();
    }
}

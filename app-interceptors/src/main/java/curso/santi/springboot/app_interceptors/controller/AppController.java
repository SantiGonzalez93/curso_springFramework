package curso.santi.springboot.app_interceptors.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/foo")
    public Map<String, String> foo() {

        return Collections.singletonMap("message", "handler foo del controlador");
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {

        return Collections.singletonMap("message", "handler bar del controlador");
    }

    @GetMapping("/baz")
    public Map<String, String> baz() {

        return Collections.singletonMap("message", "handler baz del controlador");
    }
}

package br.com.velhoamigo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/api/v1/hello")
    public String sayHello() {
        return "Hello authentication with JWT";
    }
}

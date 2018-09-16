package br.com.velhoamigo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.velhoamigo.api.model.UserContext;
import br.com.velhoamigo.api.security.jwt.JwtAuthenticationToken;

@RestController
public class ProfileController {

    @RequestMapping(value = "/api/v1/me", method = RequestMethod.GET)
    @ResponseBody
    public UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}

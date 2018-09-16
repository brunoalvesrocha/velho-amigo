package br.com.velhoamigo.api.service;

import java.util.Optional;

import br.com.velhoamigo.api.entity.User;

public interface UserService {

    Optional<User> getByUsername(String username);
}

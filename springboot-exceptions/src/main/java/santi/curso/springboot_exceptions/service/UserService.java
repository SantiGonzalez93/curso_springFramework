package santi.curso.springboot_exceptions.service;

import santi.curso.springboot_exceptions.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    public Optional<User> findById(Long id);
}

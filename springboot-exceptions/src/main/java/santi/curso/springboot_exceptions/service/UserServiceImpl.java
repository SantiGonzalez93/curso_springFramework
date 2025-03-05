package santi.curso.springboot_exceptions.service;

import org.springframework.stereotype.Service;
import santi.curso.springboot_exceptions.models.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = Arrays.asList(new User(1L, "Santi", "Gonzalez")
                , new User(2L, "Santi", "Gonzalez")
                , new User(3L, "Emi", "Gonzalez")
                , new User(4L, "Barbi", "Dupu")
                , new User(5L, "Ane", "Mato"));
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        for (User u: users){
            if (u.getId().equals(id)){
                user = u;
                break;
            }
        }
        return Optional.ofNullable(user);
    }
}

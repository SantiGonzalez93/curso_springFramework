package santi.curso.springboot_exceptions.exceptions;

import santi.curso.springboot_exceptions.models.domain.User;

public class UserNotFoundException extends RuntimeException{

public UserNotFoundException(String mensaje){
    super(mensaje);
}

}

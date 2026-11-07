package br.unifan.agenda.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatoNotFound extends RuntimeException{

    public ContatoNotFound(String email){
        super(String.format("Não foi encontrado nenhum contato com o email %s", email));
    }
}

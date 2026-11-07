package br.unifan.agenda.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContatoJaExiste extends  RuntimeException {
    public ContatoJaExiste(String email) {
       super(String.format("Ja existe contato com email %s", email));     
    }
}


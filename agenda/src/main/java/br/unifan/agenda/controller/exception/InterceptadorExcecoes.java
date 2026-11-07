package br.unifan.agenda.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider 
public class InterceptadorExcecoes implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception ex) {
        Map<String, Object> atributos = new HashMap<>();
        atributos.put("timestamp", LocalDateTime.now().toString());
        atributos.put("message", ex.getMessage());
        atributos.put("exception", ex.getClass().getSimpleName());

        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;

        if(ex instanceof ContatoJaExiste)
            status = Response.Status.CONFLICT;
        else if (ex instanceof ContatoNotFound)
            status = Response.Status.NOT_FOUND;

        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(atributos).build();

    }

}

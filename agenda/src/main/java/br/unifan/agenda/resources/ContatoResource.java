package br.unifan.agenda.resources;

import br.unifan.agenda.controller.ContatoBC;
import br.unifan.agenda.controller.exception.ContatoJaExiste;
import br.unifan.agenda.controller.exception.ContatoNotFound;
import br.unifan.agenda.model.Contato;
import br.unifan.agenda.security.JWTUtil;
import br.unifan.agenda.security.LoginRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@LoginRequired
@Path("contato")
@Produces(MediaType.APPLICATION_JSON)
public class ContatoResource {

    private ContatoBC bc = new ContatoBC();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(Contato contato)throws ContatoJaExiste{
        bc.salvar(contato);
        return Response.ok().build();
    }

    @GET
    @Path("{email}")
    public Response obterPorEmail(@PathParam("email") String email) throws ContatoNotFound{
        Contato c = bc.obterPorEmail(email);
        return Response.ok(c).build();
    }

    @GET
    public Response obterPorEmailPorQueryParam(@QueryParam("email") String email) throws ContatoNotFound{
        Contato c = bc.obterPorEmail(email);
        return Response.ok(c).build();
    }

    @GET
    @Path("todos")
    public Response obterTodos(@Context HttpHeaders header){
        try{
            String token = header.getHeaderString(HttpHeaders.AUTHORIZATION);
            if(token == null || token.isBlank())
                return Response.status(401).entity("Token Ausente").build();
            JWTUtil.validarToken(token);
            return Response.ok().entity(bc.obterTodos()).build();
        }catch(Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("email") String email, Contato contato)throws ContatoNotFound, ContatoJaExiste{
        bc.atualizar(email, contato);
        return Response.ok().build();
    }

    @DELETE
    @Path("{email}")
    public Response remover(@PathParam("email") String email)throws ContatoNotFound{
        bc.remover(email);
        return Response.ok().build();
    }
}

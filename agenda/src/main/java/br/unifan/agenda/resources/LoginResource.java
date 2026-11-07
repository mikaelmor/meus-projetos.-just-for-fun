package br.unifan.agenda.resources;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import br.unifan.agenda.security.JWTUtil;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logar(String json) {
        try {
            JsonObject obj = Json.createReader(new StringReader(json)).readObject();
            if (obj.containsKey("email") == false || obj.containsKey("senha") == false)
                return Response.status(400).entity("Faltando campos obrigatórios: email e senha").build();
            String email = obj.getString("email");
            String senha = obj.getString("senha");
            if (!email.equals("admin@unifan.br"))
                return Response.status(401).entity("Usuário inválido").build();
            if (!senha.equals("passwd"))
                return Response.status(401).entity("Senha Inválida").build();
            String tokenJWT = JWTUtil.gerarToken(email);
            Map<String, String> body = new HashMap<>();
            body.put("tokenJWT", tokenJWT);
            return Response.ok().entity(body).build();
        } catch (Exception error) {
            return Response.status(500).entity(error.getMessage()).build();
        }
    }
}

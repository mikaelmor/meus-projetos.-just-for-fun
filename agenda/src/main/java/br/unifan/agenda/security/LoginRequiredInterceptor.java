package br.unifan.agenda.security;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@LoginRequired
public class LoginRequiredInterceptor implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString("Authorization");
        if (token == null || token.isBlank()) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("{\"message\":\"Token ausente ou inválido\"}")
                            .build());
            return;
        }
        
        try {
            JWTUtil.validarToken(token);
        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity("{\"message\":\"" + e.getMessage() + "\"}")
                            .build());
        }
    }
}

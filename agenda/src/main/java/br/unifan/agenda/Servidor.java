package br.unifan.agenda;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import org.glassfish.jersey.servlet.ServletContainer;
import jakarta.servlet.ServletException;

public class Servidor {
    public static void main(String[] args) throws ServletException {
        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(Servidor.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("agenda.war")
                .addServlets(
                        Servlets.servlet("JerseyServlet", ServletContainer.class)
                                .addInitParam("jersey.config.server.provider.packages",
                                        "br.unifan.agenda.controller.exception;br.unifan.agenda.resources;br.unifan.agenda.security;org.glassfish.jersey.jsonb")
                                .setLoadOnStartup(1)
                                .addMapping("/*"));
        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setHandler(manager.start())
                .build();
        server.start();
        System.out.println("Servidor Undertow rodando em http://localhost:8080/");
    }
}

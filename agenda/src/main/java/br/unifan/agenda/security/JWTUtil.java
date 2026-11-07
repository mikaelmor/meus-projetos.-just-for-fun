package br.unifan.agenda.security;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTUtil {

    private static final SecretKey CHAVE = Keys.hmacShaKeyFor(
            "minhachavequeprecisaterpelomenos80caracteresporquestoesdeseguranca"
                    .getBytes(StandardCharsets.UTF_8));

    public static String gerarToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "admin");
        claims.put("app", "agenda");
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(CHAVE, SignatureAlgorithm.HS512).compact();
    }

    public static void validarToken(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(CHAVE)
                .build()
                .parseClaimsJws(token);
        System.out.println("Token válido!");
        System.out.println("Subject: " + jws.getBody().getSubject());
        System.out.println("Role: " + jws.getBody().get("role"));
        System.out.println("Expiração: " + jws.getBody().getExpiration());
    }
}
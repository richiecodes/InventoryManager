package com.richiecodes.inventorymanager.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 123456L;

    @Value("$(jwt.secret)")
    private String secret;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims CLAIMS = getAllClaimsFromToken(token);

        return claimsResolver.apply(CLAIMS);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
    }

    public String generateToken(UserDetails details) {
        Map<String, Object> claims = new HashMap<>();

        return doGenerateToken(claims, details.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Boolean validateToken(String token, UserDetails details) {
        final String username = getUsernameFromToken(token);

        return username.equals(details.getUsername());
    }
}
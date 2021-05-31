package com.joubo.apisuperheroes.controller.impl;

import com.joubo.apisuperheroes.controller.UsuariosController;
import com.joubo.apisuperheroes.dto.UsuarioDTO;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UsuariosControllerImpl implements UsuariosController {

  @PostMapping("usuario")
  public UsuarioDTO login(@RequestParam("usuario") String usuario) {

    String token = getJWTToken(usuario);
    UsuarioDTO usu = new UsuarioDTO();
    usu.setNombre(usuario);
    usu.setToken(token);
    return usu;

  }

  private String getJWTToken(String username) {
    String secretKey = "mySecretKey";
    List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        .commaSeparatedStringToAuthorityList("ROLE_USER");

    String token = Jwts
        .builder()
        .setId("jouboJWT")
        .setSubject(username)
        .claim("authorities",
            grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()))
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 600000))
        .signWith(SignatureAlgorithm.HS512,
            secretKey.getBytes()).compact();

    return "Bearer " + token;
  }
}

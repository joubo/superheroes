package com.joubo.apisuperheroes.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

  private static final String HEADER = "Authorization";
  private static final String PREFIX = "Bearer ";
  private static final String SECRET = "mySecretKey";

  @Override
  protected void doFilterInternal(@NotNull HttpServletRequest request,
      @NotNull HttpServletResponse response, @NotNull FilterChain chain)
      throws ServletException, IOException {
    try {
      if (existeJWTToken(request)) {
        Claims claims = validateToken(request);
        if (claims.get("authorities") != null) {
          setUpSpringAuthentication(claims);
        } else {
          SecurityContextHolder.clearContext();
        }
      } else {
        SecurityContextHolder.clearContext();
      }
      chain.doFilter(request, response);
    } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }
  }

  private Claims validateToken(HttpServletRequest request) {
    String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
    return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
  }

  /**
   * Metodo para autenticarnos dentro del flujo de Spring
   *
   */
  private void setUpSpringAuthentication(Claims claims) {
    @SuppressWarnings("unchecked")
    List<String> authorities = (List) claims.get("authorities");

    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
        claims.getSubject(), null,
        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    SecurityContextHolder.getContext().setAuthentication(auth);

  }

  private boolean existeJWTToken(HttpServletRequest request) {
    String authenticationHeader = request.getHeader(HEADER);
    return authenticationHeader != null && authenticationHeader.startsWith(PREFIX);
  }

}
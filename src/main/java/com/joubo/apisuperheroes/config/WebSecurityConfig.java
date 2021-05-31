package com.joubo.apisuperheroes.config;


import com.joubo.apisuperheroes.filter.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/usuario").permitAll()
        .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
            "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
        .antMatchers(HttpMethod.GET, "/superheroes*/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/superheroes/cache").permitAll()
        .anyRequest().authenticated();
  }
}
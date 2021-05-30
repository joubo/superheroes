package com.joubo.apisuperheroes.config;

import com.joubo.apisuperheroes.interceptor.CorrelationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SuperheroesInterceptorConfiguration implements WebMvcConfigurer {

  @Autowired
  private CorrelationInterceptor correlationInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(correlationInterceptor);
  }

}

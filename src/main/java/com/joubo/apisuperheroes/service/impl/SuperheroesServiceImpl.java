package com.joubo.apisuperheroes.service.impl;

import com.joubo.apisuperheroes.entity.Superheroe;
import com.joubo.apisuperheroes.service.SuperheroesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SuperheroesServiceImpl implements SuperheroesService {

  @Override
  public List<Superheroe> getAllSuperheroes() {
    return new ArrayList<>();
  }

  @Override
  public Superheroe getSuperheroe(long id) {
    return new Superheroe();
  }

  @Override
  public Superheroe getSuperheroe(String nombre) {
    return new Superheroe();
  }

  @Override
  public Superheroe updateSuperheroe(Superheroe superheroe) {
    return new Superheroe();
  }

  @Override
  public void deleteSuperheroe(long id) {
  }
}

package com.joubo.apisuperheroes.service;

import com.joubo.apisuperheroes.entity.Superheroe;

import java.util.List;

public interface SuperheroesService {

  List<Superheroe> getAllSuperheroes();

  Superheroe getSuperheroe(long id);

  Superheroe getSuperheroe(String nombre);

  Superheroe updateSuperheroe(Superheroe superheroe);

  void deleteSuperheroe(long id);
}

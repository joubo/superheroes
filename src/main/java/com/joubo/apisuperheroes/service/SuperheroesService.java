package com.joubo.apisuperheroes.service;

import com.joubo.apisuperheroes.entity.Superheroe;

import java.util.List;

public interface SuperheroesService {

  List<Superheroe> getAllSuperheroes(String palabra);

  Superheroe getSuperheroe(long id);

  Superheroe updateSuperheroe(Superheroe superheroe);

  void deleteSuperheroe(long id);
}

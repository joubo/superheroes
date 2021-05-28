package com.joubo.apisuperheroes.controller;

import com.joubo.apisuperheroes.entity.Superheroe;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface SuperheroesController {

  List<Superheroe> getAllSuperheroes();

  Superheroe getSuperheroe(long id);

  Superheroe getSuperheroe(String nombre);

  Superheroe updateSuperheroe(Superheroe superheroe);

  void deleteSuperheroe(long id);
}

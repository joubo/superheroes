package com.joubo.apisuperheroes.controller.impl;

import com.joubo.apisuperheroes.controller.SuperheroesController;
import com.joubo.apisuperheroes.entity.Superheroe;
import com.joubo.apisuperheroes.service.SuperheroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperheroesControllerImpl implements SuperheroesController {

  @Autowired
  SuperheroesService superheroesService;

  @GetMapping("/superheroes")
  public List<Superheroe> getAllSuperheroes() {
    return superheroesService.getAllSuperheroes();
  }

  @GetMapping("/superheroes/{id}")
  public Superheroe getSuperheroe(@PathVariable(value = "id") long id) {
    return superheroesService.getSuperheroe(id);
  }

  @GetMapping("/superheroes/{nombre}")
  public Superheroe getSuperheroe(@PathVariable(value = "nombre") String nombre) {
    return superheroesService.getSuperheroe(nombre);
  }

  @PutMapping("/superheroes")
  public Superheroe updateSuperheroe(@RequestBody Superheroe superheroe) {
    return superheroesService.updateSuperheroe(superheroe);
  }

  @DeleteMapping("/superheroe/{id}")
  public void deleteSuperheroe(long id) {
    superheroesService.deleteSuperheroe(id);
  }

}

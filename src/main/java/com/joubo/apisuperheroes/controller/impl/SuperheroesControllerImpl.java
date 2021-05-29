package com.joubo.apisuperheroes.controller.impl;

import com.joubo.apisuperheroes.controller.SuperheroesController;
import com.joubo.apisuperheroes.entity.Superheroe;
import com.joubo.apisuperheroes.service.SuperheroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperheroesControllerImpl implements SuperheroesController {

  @Autowired
  SuperheroesService superheroesService;

  @GetMapping("/superheroes")
  public ResponseEntity<List<Superheroe>> getAllSuperheroes(
      @RequestParam(value = "palabra", required = false, defaultValue = "") String palabra) {

    return new ResponseEntity<>(
        superheroesService.getAllSuperheroes(palabra), HttpStatus.OK);
  }

  @GetMapping("/superheroes/{id}")
  public ResponseEntity<Superheroe> getSuperheroe(@PathVariable(value = "id") long id) {
    return new ResponseEntity<>(superheroesService.getSuperheroe(id), HttpStatus.OK);
  }

  @PutMapping("/superheroe")
  public ResponseEntity<Superheroe> updateSuperheroe(@RequestBody Superheroe superheroe) {
    return new ResponseEntity<>(superheroesService.updateSuperheroe(superheroe), HttpStatus.OK);
  }

  @DeleteMapping("/superheroe/{id}")
  public ResponseEntity<HttpStatus> deleteSuperheroe(@PathVariable long id) {
    superheroesService.deleteSuperheroe(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}

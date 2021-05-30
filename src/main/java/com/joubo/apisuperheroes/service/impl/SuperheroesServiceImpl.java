package com.joubo.apisuperheroes.service.impl;

import com.joubo.apisuperheroes.entity.Superheroe;
import com.joubo.apisuperheroes.exception.SuperHeroeNoEncontrado;
import com.joubo.apisuperheroes.repository.SuperheroesRepository;
import com.joubo.apisuperheroes.service.SuperheroesService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SuperheroesServiceImpl implements SuperheroesService {

  @Autowired
  SuperheroesRepository superheroesRepository;

  @Override
  public List<Superheroe> getAllSuperheroes(String palabra) {
    log.info("SuperheroesService: getAllSuperheroes");
    return superheroesRepository.findByNameContaining(palabra.toLowerCase());
  }

  @Override
  public Superheroe getSuperheroe(long id) {
    log.info("SuperheroesService: getSuperheroe");
    Optional<Superheroe> superheroe = superheroesRepository.findById(id);
    return superheroe
        .orElseThrow(
            () -> new SuperHeroeNoEncontrado(
                String.format("No existe el superheroe con id: %s", id)));
  }

  @Override
  public Superheroe updateSuperheroe(Superheroe superheroe) {
    log.info("SuperheroesService: updateSuperheroe");
    return superheroesRepository.save(superheroe);
  }

  @Override
  public void deleteSuperheroe(long id) {
    log.info("SuperheroesService: deleteSuperheroe");
    superheroesRepository.deleteById(id);
  }
}

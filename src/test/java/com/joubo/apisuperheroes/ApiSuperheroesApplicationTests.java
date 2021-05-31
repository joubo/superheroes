package com.joubo.apisuperheroes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.joubo.apisuperheroes.dto.SuperheroeDTO;
import com.joubo.apisuperheroes.entity.Superheroe;
import com.joubo.apisuperheroes.repository.SuperheroesRepository;
import com.joubo.apisuperheroes.service.SuperheroesService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ApiSuperheroesApplicationTests {

  @MockBean
  SuperheroesRepository superheroesRepository;

  @Autowired
  SuperheroesService superheroesService;

  // PRUEBAS UNITARIAS
  @Test
  void whenGetAllSuperheroes_ReturnListOfSuperheroes() {
    when(superheroesRepository.findByNameContaining("")).thenReturn(getListSuperheroes());
    List<SuperheroeDTO> resultado = superheroesService.getAllSuperheroes("");

    assertEquals(4, resultado.size());
  }

  @Test
  void whenGetSuperheroeById_ReturnSuperheroe() {
    when(superheroesRepository.findById(1L)).thenReturn(Optional.of(getSuperheroe()));
    SuperheroeDTO resultado = superheroesService.getSuperheroe(1L);

    assertNotNull(resultado);
  }

  /**
   * Devuelve una lista con varios superheroes
   *
   * @return lista de superheroes
   */
  private List<Superheroe> getListSuperheroes() {
    List<Superheroe> superheroes = new ArrayList<>();

    Superheroe superheroe = new Superheroe(1L, "Superman");
    superheroes.add(superheroe);

    superheroe = new Superheroe(2L, "Spiderman");
    superheroes.add(superheroe);

    superheroe = new Superheroe(3L, "Thor");
    superheroes.add(superheroe);

    superheroe = new Superheroe(4L, "Manolito el fuerte");
    superheroes.add(superheroe);

    return superheroes;
  }

  /**
   * Devuelve un superheroe
   *
   * @return superheroe
   */
  private Superheroe getSuperheroe() {
    return  new Superheroe(1L, "Superman");
  }

}

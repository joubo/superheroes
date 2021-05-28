package com.joubo.apisuperheroes.controller;

import com.joubo.apisuperheroes.entity.Superheroe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "API de Superheroes")
public interface SuperheroesController {

  @ApiOperation(value = "Obtener todos los superheroes", notes = "Devuelve una lista con todos los superheroes" )
  List<Superheroe> getAllSuperheroes();

  @ApiOperation(value = "Obtener un superheroe por id", notes = "Devuelve un superheroe por id" )
  Superheroe getSuperheroe(long id);

  @ApiOperation(value = "Obtener un superheroe por nombre", notes = "Devuelve un superheroe con las coincidencias en el nombre" )
  Superheroe getSuperheroe(String nombre);

  @ApiOperation(value = "Modificar un superheroe", notes = "Devuelve el superheroe modificado" )
  Superheroe updateSuperheroe(Superheroe superheroe);

  @ApiOperation(value = "Eliminar un superheroe", notes = "Se elimina el superheroe indicado" )
  void deleteSuperheroe(long id);
}

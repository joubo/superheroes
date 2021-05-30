package com.joubo.apisuperheroes.controller;

import com.joubo.apisuperheroes.entity.Superheroe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Api(value = "API de Superheroes")
public interface SuperheroesController {

  @ApiOperation(value = "Obtener todos los superheroes", notes = "Devuelve una lista con todos los superheroes" )
  ResponseEntity<List<Superheroe>> getAllSuperheroes(String palabra);

  @ApiOperation(value = "Obtener un superheroe por id", notes = "Devuelve un superheroe por id" )
  ResponseEntity<Superheroe> getSuperheroe(long id);

  @ApiOperation(value = "Modificar un superheroe", notes = "Devuelve el superheroe modificado" )
  ResponseEntity<Superheroe> updateSuperheroe(String authorization, Superheroe superheroe);

  @ApiOperation(value = "Eliminar un superheroe", notes = "Se elimina el superheroe indicado" )
  ResponseEntity<HttpStatus> deleteSuperheroe(String authorization, long id);

  @ApiOperation(value = "Limpiar caché de superheroe", notes = "Se vacía la caché de superheroes" )
  ResponseEntity<HttpStatus> limpiarCacheSuperheroes();
}

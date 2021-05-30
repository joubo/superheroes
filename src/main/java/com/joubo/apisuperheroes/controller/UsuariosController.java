package com.joubo.apisuperheroes.controller;

import com.joubo.apisuperheroes.dto.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API de Usuarios")
public interface UsuariosController {

  @ApiOperation(value = "Obtener token para un usuario", notes = "Devuelve un token para operaciones de modificación de superheroes")
  Usuario login(String usuario);

}

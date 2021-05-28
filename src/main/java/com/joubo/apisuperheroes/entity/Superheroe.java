package com.joubo.apisuperheroes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="superheroes")
@Data
public class Superheroe {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nombre;

}

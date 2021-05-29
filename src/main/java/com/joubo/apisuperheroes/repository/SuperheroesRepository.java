package com.joubo.apisuperheroes.repository;

import com.joubo.apisuperheroes.entity.Superheroe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroesRepository extends JpaRepository<Superheroe, Long> {

  @Query(value = "FROM superheroes s WHERE LOWER(s.nombre) LIKE %:palabra%")
  List<Superheroe> findByNameContaining(@Param("palabra") String palabra);

}

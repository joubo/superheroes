package com.joubo.apisuperheroes;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@Sql("/test-data.sql")
@AutoConfigureMockMvc

class ApiSuperheroesApplicationIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAllSuperheroes() throws Exception {
    mockMvc.perform(get("/superheroes"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
  }

  @Test
  void getAllSuperheroesWithFilter() throws Exception {
    mockMvc.perform(get("/superheroes?palabra=man"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
  }

  @Test
  void getSuperheroById() throws Exception {
    mockMvc.perform(get("/superheroes/4"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(4)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", Matchers.is("Manolito el fuerte")));
  }

  @Test
  void getSuperheroByIdNotFound() throws Exception {
    mockMvc.perform(get("/superheroes/5"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void updateSuperhero() throws Exception {
    String body = "{\n" +
        "\"id\":1,\n" +
        "\"nombre\":\"Arrow\"\n" +
        "}";
    mockMvc.perform(put("/superheroe")
        .content(body)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", Matchers.is("Arrow")));
    ;
  }

  @Test
  void updateSuperheroNotFound() throws Exception {
    String body = "{\n" +
        "\"id\":8,\n" +
        "\"nombre\":\"Arrow\"\n" +
        "}";
    mockMvc.perform(put("/superheroe").content(body)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void deleteSuperhero() throws Exception {
    mockMvc.perform(delete("/superheroe/1"))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  void deleteSuperheroNotFound() throws Exception {
    mockMvc.perform(delete("/superheroe/5"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

}

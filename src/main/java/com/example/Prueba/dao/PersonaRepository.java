package com.example.Prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Prueba.model.PersonaModel;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaModel, Integer> {

}

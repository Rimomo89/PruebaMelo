package com.example.Prueba.dao;

import java.util.List;

import com.example.Prueba.model.PersonaModel;

public interface IPersona {

	public List<PersonaModel> listar();

	public PersonaModel listPersonaId(int id);

	public int agregar(PersonaModel p);

	public int editar(PersonaModel p);

	public void delete(int id);

}

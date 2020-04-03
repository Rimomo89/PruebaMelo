package com.example.Prueba.services;

import java.util.List;

import com.example.Prueba.model.PersonaModel;

public interface IPersonaService {
	public PersonaModel agregar(PersonaModel p);

	public boolean actualizar(PersonaModel personaModel);

	public List<PersonaModel> consultar();
}

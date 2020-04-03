package com.example.Prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Prueba.dao.IPersona;
import com.example.Prueba.dao.PersonaRepository;
import com.example.Prueba.model.PersonaModel;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public PersonaModel agregar(PersonaModel persona) {
		personaRepository.save(persona);
		return persona;
	}

	@Override
	public boolean actualizar(PersonaModel personaModel) {
		Optional<PersonaModel> personaActualizar = personaRepository.findById(personaModel.getId());
		if(personaActualizar.isPresent()) {
			PersonaModel personaUpdate = personaActualizar.get();
			personaUpdate.setName(personaModel.getName());
			personaUpdate.setLastname(personaModel.getLastname());
			personaRepository.save(personaUpdate);
			return true;
		}
		
		return false;
	}

	@Override
	public List<PersonaModel> consultar() {
		List<PersonaModel> personasConsultadas = personaRepository.findAll();	
		return personasConsultadas;
	}

	
}

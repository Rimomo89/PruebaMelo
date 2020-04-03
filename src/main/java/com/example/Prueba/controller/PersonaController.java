package com.example.Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Prueba.services.IPersonaService;
import com.example.Prueba.services.PersonaService;
import com.example.Prueba.model.PersonaModel;

@Controller
public class PersonaController {

	@Autowired
	private IPersonaService personaService;


	@CrossOrigin
	@PostMapping(value = "/crear/", produces = "application/json")
	public ResponseEntity crear(@RequestBody final PersonaModel personaModel) {

		try {
			personaService.agregar(personaModel);
		} catch (Exception e) {
			return new ResponseEntity(personaModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(personaModel, HttpStatus.ACCEPTED);

	}	

	@CrossOrigin
	@PostMapping(value = "/actualizar/", produces = "application/json")
	public ResponseEntity actualizar(@RequestBody final PersonaModel personaModel) {
		
		boolean isUpdate = personaService.actualizar(personaModel);

		return isUpdate ? new ResponseEntity(personaModel, HttpStatus.ACCEPTED) : new ResponseEntity(personaModel, HttpStatus.NOT_FOUND);

	}
	
	@CrossOrigin
	@GetMapping(value = "/consulta/", produces = "application/json")
	public ResponseEntity consutar() {
		
		List<PersonaModel> personas;
		
		try {
			personas = personaService.consultar();
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity(personas, HttpStatus.ACCEPTED);

	}
	
	
}

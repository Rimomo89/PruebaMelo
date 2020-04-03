package com.example.Prueba.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person" ,schema = "public")
public class PersonaModel {
	
	private int id;
	private String name;
	private String lastname;
	
	public PersonaModel () {
		
	}
	
	
	public PersonaModel(int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}


	@Id
	@Column(name = "id" ,columnDefinition = "serial")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Basic
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}

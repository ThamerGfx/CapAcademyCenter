package com.example.CapAcademy.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.CrossOrigin;
@Entity(name = "Contenu")
@CrossOrigin(origins ="*")
public class contenu implements Serializable {

private static final long serialVersionUID = 1L;
	 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)

 private Long id ; 
 private String name ; 
 private String description ; 
 private String formation ;
 private Long IdFormation ; 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getFormation() {
	return formation;
}
public void setFormation(String formation) {
	this.formation = formation;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

public contenu() {
	super();
}
public contenu(String name, String description, String formation, Long idFormation) {
	super();
	this.name = name;
	this.description = description;
	this.formation = formation;
	IdFormation = idFormation;
}
 
 
	
	
}
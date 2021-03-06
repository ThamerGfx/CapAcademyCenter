	package com.example.CapAcademy.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.CrossOrigin;
@Entity(name ="Seance")
@CrossOrigin(origins ="*")
public class Seance implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ; 
	private int Idformateur ; 
	private String nameFormateur  ; 
	private int Idformation ; 
	private String  nameFormation ; 
	private String dateSeance ; 
	private String UrlSeance ;
	private String Admin  ; 
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIdformateur() {
		return Idformateur;
	}
	public void setIdformateur(int idformateur) {
		Idformateur = idformateur;
	}
	public String getNameFormateur() {
		return nameFormateur;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNameFormateur(String nameFormateur) {
		this.nameFormateur = nameFormateur;
	}
	public int getIdformation() {
		return Idformation;
	}
	public void setIdformation(int idformation) {
		Idformation = idformation;
	}
	public String getNameFormation() {
		return nameFormation;
	}
	public void setNameFormation(String nameFormation) {
		this.nameFormation = nameFormation;
	}
	public String getDateSeance() {
		return dateSeance;
	}
	public void setDateSeance(String dateFormation) {
		this.dateSeance = dateFormation;
	}
	public String getUrlSeance() {
		return UrlSeance;
	}
	public void setUrlSeance(String urlFormation) {
		UrlSeance = urlFormation;
	}
	public String getAdmin() {
		return Admin;
	}
	public void setAdmin(String admin) {
		Admin = admin;
	}

	
	
	
	
	
	
	
	
	
	
	
}

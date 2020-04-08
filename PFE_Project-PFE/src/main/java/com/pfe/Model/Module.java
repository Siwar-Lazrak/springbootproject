package com.pfe.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "module")
public class Module  {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idModule;

	@Size(max = 20)
	private String nom;
	
	@Size(max = 600)
	private String description;
	
	

	public Integer getIdModule() {
		return idModule;
	}

	public void setIdModule(Integer idModule) {
		this.idModule = idModule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Module(String nom, String description) {
	
		this.nom = nom;
		this.description = description;
	
	}

	public Module() {
	}



}

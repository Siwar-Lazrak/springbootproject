package com.pfe.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notification")
public class Notification {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idNotif;

	@Size(max = 20)
	private String nom;
	
	@Size(max = 1000)
	private String description;

	public Integer getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(Integer idNotif) {
		this.idNotif = idNotif;
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

	public Notification(Integer idNotif, @Size(max = 20) String nom, @Size(max = 1000) String description) {
		super();
		this.idNotif = idNotif;
		this.nom = nom;
		this.description = description;
	}

	public Notification() {
		super();
	}
	

}

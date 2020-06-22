package com.pfe.Model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfe.Model.Module;


@Entity
@Table(name = "sousmodule")
public class SousModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSousModule;
	
	@Size(max = 300)
	private String nomSousModule;
	
	@Size(max = 1000)
	private String descriptionSousModule;
		
	
	 @ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "idModule")
	 private Module module;
	 	
	

	public Integer getIdSousModule() {
		return idSousModule;
	}

	public void setIdSousModule(Integer idSousModule) {
		this.idSousModule = idSousModule;
	}

	public String getNomSousModule() {
		return nomSousModule;
	}

	public void setNomSousModule(String nomSousModule) {
		this.nomSousModule = nomSousModule;
	}

	public String getDescriptionSousModule() {
		return descriptionSousModule;
	}

	public void setDescriptionSousModule(String descriptionSousModule) {
		this.descriptionSousModule = descriptionSousModule;
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}



	public SousModule(Integer idSousModule, @Size(max = 20) String nomSousModule,
			@Size(max = 50) String descriptionSousModule, Module module) {
		super();
		this.idSousModule = idSousModule;
		this.nomSousModule = nomSousModule;
		this.descriptionSousModule = descriptionSousModule;
		this.module = module;
	}

	public SousModule() {
	
	}

	@Override
	public String toString() {
		return "SousModule [idSousModule=" + idSousModule + ", nomSousModule=" + nomSousModule
				+ ", descriptionSousModule=" + descriptionSousModule + ", module=" + module + "]";
	}
	
	
}

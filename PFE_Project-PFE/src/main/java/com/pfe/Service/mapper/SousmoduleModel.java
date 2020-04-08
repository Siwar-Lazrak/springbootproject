package com.pfe.Service.mapper;



public class SousmoduleModel {
	
	
	private Integer idSousModule;
	
	
	private String nomSousModule;
	
	private String descriptionSousModule;
	
	

	public SousmoduleModel() {
	}


	public SousmoduleModel(Integer idSousModule, String nomSousModule, String descriptionSousModule) {
		this.idSousModule = idSousModule;
		this.nomSousModule = nomSousModule;
		this.descriptionSousModule = descriptionSousModule;
	}


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


	
		

}

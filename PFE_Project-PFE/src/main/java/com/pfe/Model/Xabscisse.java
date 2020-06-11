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

@Entity
@Table(name = "xabscisse")
public class Xabscisse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idX;
	
	@Size(max = 600)
	private String fieldname;
	
	@Size(max = 600)
	private String fieldreporting;
	
	@Size(max = 1600)
	private String filtre;
	
	@Size(max = 1600)
	private String operation;
	
	@Size(max = 1600)
	private String tablerep;
	
	@Size(max = 1600)
	private String idfield;
	

	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "idRapport")
	 private Rapport rapport;
	

	public Integer getIdX() {
		return idX;
	}


	public void setIdX(Integer idX) {
		this.idX = idX;
	}


	public String getFieldname() {
		return fieldname;
	}


	public void setField_name(String fieldname) {
		this.fieldname = fieldname;
	}


	public String getFieldreporting() {
		return fieldreporting;
	}


	public void setField_reporting(String fieldreporting) {
		this.fieldreporting = fieldreporting;
	}


	public String getFiltre() {
		return filtre;
	}


	public void setFiltre(String filtre) {
		this.filtre = filtre;
	}


	public Rapport getRapport() {
		return rapport;
	}


	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTablerep() {
		return tablerep;
	}


	public void setTable_rep(String tablerep) {
		this.tablerep = tablerep;
	}


	public String getIdfield() {
		return idfield;
	}


	public void setId_field(String idfield) {
		this.idfield = idfield;
	}

	public Xabscisse() {
		super();
	}


	public Xabscisse(Integer idX, @Size(max = 600) String fieldname, @Size(max = 600) String fieldreporting,
			@Size(max = 1600) String filtre, @Size(max = 1600) String operation, @Size(max = 1600) String tablerep,
			@Size(max = 1600) String idfield, Rapport rapport) {
		super();
		this.idX = idX;
		this.fieldname = fieldname;
		this.fieldreporting = fieldreporting;
		this.filtre = filtre;
		this.operation = operation;
		this.tablerep = tablerep;
		this.idfield = idfield;
		this.rapport = rapport;
	}


	@Override
	public String toString() {
		return "Xabscisse [idX=" + idX + ", fieldname=" + fieldname + ", fieldreporting=" + fieldreporting
				+ ", filtre=" + filtre + ", operation=" + operation + ", tablerep=" + tablerep + ", idfield="
				+ idfield + ", rapport=" + rapport + "]";
	}
	
	

	
	

}

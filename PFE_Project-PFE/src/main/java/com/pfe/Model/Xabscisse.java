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
	private Integer id_X;
	
	@Size(max = 600)
	private String field_name;
	
	@Size(max = 600)
	private String field_reporting;
	
	@Size(max = 1600)
	private String filtre;
	
	@Size(max = 1600)
	private String operation;
	

	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "idRapport")
	 private Rapport rapport;


	public Integer getId_X() {
		return id_X;
	}


	public void setId_X(Integer id_X) {
		this.id_X = id_X;
	}


	public String getField_name() {
		return field_name;
	}


	public void setField_name(String field_name) {
		this.field_name = field_name;
	}


	public String getField_reporting() {
		return field_reporting;
	}


	public void setField_reporting(String field_reporting) {
		this.field_reporting = field_reporting;
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


	

	public Xabscisse(Integer id_X, @Size(max = 600) String field_name, @Size(max = 600) String field_reporting,
			@Size(max = 1600) String filtre, @Size(max = 1600) String operation, Rapport rapport) {
		super();
		this.id_X = id_X;
		this.field_name = field_name;
		this.field_reporting = field_reporting;
		this.filtre = filtre;
		this.operation = operation;
		this.rapport = rapport;
	}


	public Xabscisse() {
		super();
	}


	@Override
	public String toString() {
		return "Xabscisse [id_X=" + id_X + ", field_name=" + field_name + ", field_reporting=" + field_reporting
				+ ", filtre=" + filtre + ", operation=" + operation + ", rapport=" + rapport + "]";
	}


	
	

}

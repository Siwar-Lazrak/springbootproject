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
@Table(name = "yabscisse")
public class Yabscisse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Y;
	
	@Size(max = 600)
	private String field_name;
	
	@Size(max = 600)
	private String field_reporting;
	
	@Size(max = 1600)
	private String operation;
	

	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "id_X")
	 private Xabscisse xabscisse;


	public Integer getId_Y() {
		return id_Y;
	}


	public void setId_Y(Integer id_Y) {
		this.id_Y = id_Y;
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


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public Xabscisse getXabscisse() {
		return xabscisse;
	}


	public void setXabscisse(Xabscisse xabscisse) {
		this.xabscisse = xabscisse;
	}


	public Yabscisse(Integer id_Y, @Size(max = 600) String field_name, @Size(max = 600) String field_reporting,
			@Size(max = 1600) String operation, Xabscisse xabscisse) {
		super();
		this.id_Y = id_Y;
		this.field_name = field_name;
		this.field_reporting = field_reporting;
		this.operation = operation;
		this.xabscisse = xabscisse;
	}


	public Yabscisse() {
		super();
	}


	@Override
	public String toString() {
		return "Yabscisse [id_Y=" + id_Y + ", field_name=" + field_name + ", field_reporting=" + field_reporting
				+ ", operation=" + operation + ", xabscisse=" + xabscisse + "]";
	}

}

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


@Entity
@Table(name = "yabscisse")
public class Yabscisse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idY;
	
	@Size(max = 600)
	private String fieldname;
	
	@Size(max = 600)
	private String fieldreporting;
	
	@Size(max = 1600)
	private String operation;
	
    @JsonBackReference
	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "idX")
	 private Xabscisse xabscisse;


	public Integer getIdY() {
		return idY;
	}


	public void setId_Y(Integer idY) {
		this.idY = idY;
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


	public void setFieldreporting(String fieldreporting) {
		this.fieldreporting = fieldreporting;
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


	public Yabscisse(Integer idY, @Size(max = 600) String fieldname, @Size(max = 600) String fieldreporting,
			@Size(max = 1600) String operation, Xabscisse xabscisse) {
		super();
		this.idY = idY;
		this.fieldname = fieldname;
		this.fieldreporting = fieldreporting;
		this.operation = operation;
		this.xabscisse = xabscisse;
	}


	public Yabscisse() {
		super();
	}


	@Override
	public String toString() {
		return "Yabscisse [idY=" + idY + ", fieldname=" + fieldname + ", fieldreporting=" + fieldreporting
				+ ", operation=" + operation + ", xabscisse=" + xabscisse + "]";
	}


	

}

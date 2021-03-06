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
@Table(name = "rapport")
public class Rapport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRapport;
	
	@Size(max = 600)
	private String nomRapport;
	
	@Size(max = 600)
	private String title;
	
	@Size(max = 600)
	private String chartType;
	
	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 @JoinColumn(name = "idSousModule")
	 private SousModule sousmodule;

	public Integer getIdRapport() {
		return idRapport;
	}

	public void setIdRapport(Integer idRapport) {
		this.idRapport = idRapport;
	}

	public String getNomRapport() {
		return nomRapport;
	}

	public void setNomRapport(String nomRapport) {
		this.nomRapport = nomRapport;
	}


	public SousModule getSousmodule() {
		return sousmodule;
	}

	public void setSousmodule(SousModule sousmodule) {
		this.sousmodule = sousmodule;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}


	public Rapport(Integer idRapport, @Size(max = 600) String nomRapport, @Size(max = 600) String title,
			@Size(max = 600) String chartType, SousModule sousmodule) {
		super();
		this.idRapport = idRapport;
		this.nomRapport = nomRapport;
		this.title = title;
		this.chartType = chartType;
		this.sousmodule = sousmodule;
	}

	public Rapport() {
	
	}

	@Override
	public String toString() {
		return "Rapport [idRapport=" + idRapport + ", nomRapport=" + nomRapport + ", title=" + title + ", chartType="
				+ chartType + ", descriptionRapport="  + ", sousmodule=" + sousmodule + "]";
	}

	
	

}

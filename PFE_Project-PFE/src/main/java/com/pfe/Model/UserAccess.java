package com.pfe.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name = "useraccess")
public class UserAccess  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_sous_module")
	private SousModule sousmodule;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SousModule getSousmodule() {
		return sousmodule;
	}

	public void setSousmodule(SousModule sousmodule) {
		this.sousmodule = sousmodule;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "UserAccess [id=" + id + ", sousmodule=" + sousmodule + ", user=" + user + "]";
	}

	public UserAccess() {
		
	}

	public UserAccess(Integer id, SousModule sousmodule, User user) {
		super();
		this.id = id;
		this.sousmodule = sousmodule;
		this.user = user;
	}


	
	
	
}

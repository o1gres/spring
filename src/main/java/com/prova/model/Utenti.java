package com.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UTENTI")
public class Utenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	public String name;
	
	@Column
	public int eta;
	
	@Column
	public int sesso;
	
	public Utenti() {}

	public Utenti(int id, String name, int eta, int sesso) {
		super();
		this.id = id;
		this.name = name;
		this.eta = eta;
		this.sesso = sesso;
	}

	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    @Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @Column(name = "ETA")
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	@Column(name = "SESSO")
	public int getSesso() {
		return sesso;
	}

	public void setSesso(int sesso) {
		this.sesso = sesso;
	}
}

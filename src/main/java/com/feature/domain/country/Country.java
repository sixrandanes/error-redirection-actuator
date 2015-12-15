package com.feature.domain.country;

import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038037527581624919L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@RestResource
	@Column(name = "NOM", nullable = false)
	private String nom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

package com.feature.domain.user;

import com.feature.domain.country.Country;
import com.feature.domain.role.Role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038037527581624919L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@NotNull
	@Column(name = "USERNAME", unique = true, nullable = false)
	@Size(min = 3, max = 25)
	private String username;

	@Column(name = "NOM", nullable = false)
	private String nom;

	@Column(name = "PRENOM", nullable = false)
	private String prenom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ROLE", nullable = false, referencedColumnName = "ID")
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COUNTRY", nullable = false, referencedColumnName = "ID")
	private Country country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}

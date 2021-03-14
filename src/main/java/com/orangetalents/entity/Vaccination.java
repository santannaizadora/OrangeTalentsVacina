package com.orangetalents.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Vaccination implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String vaccineName;
	
	@Column(nullable = false)
	private Date vaccinationDate;
	
	@Column(nullable = false)
	@Email
	private String userEmail;
	
	public Vaccination() {
		
	}

	public Vaccination(Integer id, String vaccineName, String userEmail,Date vaccinationDate) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.userEmail = userEmail;
		this.vaccinationDate = vaccinationDate;
	}
	
	
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getVaccinationDate() {
		return vaccinationDate;
	}
	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}

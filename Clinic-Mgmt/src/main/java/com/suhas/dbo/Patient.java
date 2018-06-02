package com.suhas.dbo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_id;
	private String name;
	private int phone;
	private String email;
	private String description;

	/*@OneToMany(mappedBy = "patient", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<DtTime> dateTime;*/

	public Patient() {

	}

	public int getPatient_id() {
		return patient_id;
	}

	public String getName() {
		return name;
	}

	public int getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	/*public List<DtTime> getDateTime() {
		return dateTime;
	}*/

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public void setDateTime(List<DtTime> dateTime) {
		this.dateTime = dateTime;
	}*/

	// adding bi-directional
	/*public void add(DtTime dt) {
		if (dateTime == null) {
			dateTime = new ArrayList<>();
		}

		dateTime.add(dt);

		dt.setPatient(this);
	}*/

}

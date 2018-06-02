package com.suhas.dbo;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dt_time")
public class DtTime {
	
	
	private int appointmentId;
	private String apDate;
	private String apTime;
	
	private int patientId;
	
	/*@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;*/
	
	public DtTime() {

	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="appointment_id")
	public int getAppointmentId() {
		return appointmentId;
	}
	@Column(name="ap_date")
	public String getApDate() {
		return apDate;
	}
	
	@Column(name="ap_time")
	public String getApTime() {
		return apTime;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public void setApDate(String apDate) {
		this.apDate = apDate;
	}

	public void setApTime(String apTime) {
		this.apTime = apTime;
	}
	
	
	
	/*public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}*/
	
	

	

	@Column(name="patient_id")
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "DtTime [appointmentId=" + appointmentId + ", apDate=" + apDate + ", apTime=" + apTime + ", patient="
				 + "]";
	}

	
	
}

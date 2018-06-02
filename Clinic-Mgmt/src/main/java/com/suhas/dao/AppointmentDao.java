package com.suhas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.suhas.dbo.Appointment;
import com.suhas.dbo.DtTime;
import com.suhas.dbo.Patient;

@Transactional
public class AppointmentDao {
	
public int insert(Appointment obj){
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(DtTime.class)
									.addAnnotatedClass(Patient.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Patient patient = new Patient();
		DtTime dt = new DtTime();
		
		
		try{
			
			session.beginTransaction();
			
			patient.setName(obj.getName());
			patient.setPhone(obj.getPhone());
			patient.setEmail(obj.getEmail());
			patient.setDescription(obj.getDescription());
			dt.setApDate(obj.getDate());
			dt.setApTime(obj.getTime().toString());
			dt.setPatientId(patient.getPatient_id());
		
			System.out.println("Saving the date details for appointment");
			
			System.out.println("Saving the patient details for appointment");
			session.save(patient);
			session.getTransaction().commit();
			//session.close();
			session = factory.getCurrentSession();
			dt.setPatientId(patient.getPatient_id());
			session.beginTransaction();
			
			session.save(dt);
			session.getTransaction().commit();
		
			
			System.out.println("Done");
			
			
		}
		finally{
			factory.close();
		}
		return patient.getPatient_id();
		
	}
	

}

package com.suhas.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;


import com.suhas.dbo.Patient;

@Transactional
public class PatientDao {
	
	public int insert(Patient obj){
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Patient.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Patient patient = new Patient();
		
		try{
			
			patient.setName(obj.getName());
			patient.setPhone(obj.getPhone());
			patient.setEmail(obj.getEmail());
			patient.setDescription(obj.getDescription());
			session.beginTransaction();
			
			System.out.println("Saving the patient details for appointment");
			session.save(patient);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally{
			factory.close();
		}
		return patient.getPatient_id();
	}
	
	
	
}

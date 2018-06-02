package com.suhas.dao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.suhas.dbo.Appointment;
import com.suhas.dbo.DtTime;

@Transactional
public class AvailableTimeSlot {

	String date;
	List<String> result;

	Appointment apt = new Appointment();

	public List<String> getInfo(String date) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DtTime.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			SQLQuery query = session.createSQLQuery("Select distinct ap_time from clinic.dt_time where ap_date= ?");
			result = query.setString(0, date).list();

			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return result;
	}

	public static void main(String[] args) {
		AvailableTimeSlot at = new AvailableTimeSlot();
		String date = "03/12/2018";
		List<String> s = at.getInfo(date);
		for (String temp : s) {
			System.out.println(temp);
		}
		LinkedHashMap<String,String> map = at.availTime(s);
		System.out.println("coming here.."+map);
	}

	 public LinkedHashMap<String, String> availTime(List<String> bookedTime) {
	
		for (Iterator<Map.Entry<String, String>> it = apt.getTimeSlots().entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> x = it.next();
			for (String s : bookedTime) {
				if (x.getKey().equals(s)) {
					it.remove();
				}
			}
		}
		 return apt.getTimeSlots();
	}

}

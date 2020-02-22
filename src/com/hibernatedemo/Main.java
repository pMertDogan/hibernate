package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class).buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	//Unit of work 
	try {
		session.beginTransaction();
		// HQL => Hibernate Query Langue
		
		//Read
		
		//Select * from city
		//"from City c where c.countryCode = 'TUR' AND c.district = 'Ankara'"
		//"from City c where c.name LIKE '%kar%' " //içinde kar geçenler
			/*
			 * List<String> countryCodes = session
			 * .createQuery("select c.countryCode from City c GROUP BY c.countryCode")
			 * .getResultList();
			 * 
			 * session.getTransaction().commit();
			 * 
			 * for(String codes:countryCodes){ System.out.println(codes); }
			 */
		
		//insert -Create
//		City city = new City();
//		city.setName("Mert 763");
//		city.setCountryCode("TUR");
//		city.setDistrict("Karadeniz");
//		city.setPopulation(10000);
				
		//Update 
		
//		City city = session.get(City.class, 4100);
//		System.out.println(city.getName());
//		city.setPopulation(763367);

		//Delete
		City city =session.get(City.class, 4100);
		session.delete(city);
		
		
		
		// session.save(city); //delete de yok
		session.getTransaction().commit();
		System.out.println("Þehir silindi ");
		
	}finally {
		factory.close();
	}
	
	}

}

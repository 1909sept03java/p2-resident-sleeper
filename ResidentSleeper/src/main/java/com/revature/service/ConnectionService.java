package com.revature.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionService {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// if no SessionFactory has been created, make one
			Configuration config = new Configuration();
			// read in connection details from system environment
			// can also use a properties file like we have before
			// or hardcode (don't, but it's possible)
			config.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
			config.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			config.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
			config.configure(); // looks for src/main/resources/hibernate.cfg.xml for other properties
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}

}

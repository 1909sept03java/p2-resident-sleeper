package com.revature.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionService {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// if no SessionFatory has been created, make one
			Configuration config = new Configuration();
			// read in connection details from a system environment
			// can also use a properties file like we have before
			// or hardcode (don't but it's possible)
			// DB_USERNAME, BD_PASSWORD_D, and DB_URL are
			// the environment variables for a database
			config.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			config.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
			config.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
			// by default, looks for src/main/resources/hibernate.cfg.xml
			// for other properties
			config.configure();
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}

}

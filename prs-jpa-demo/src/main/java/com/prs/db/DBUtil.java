package com.prs.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

public class DBUtil {

	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("prsConsoleJPA");
	
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
	
	public static void closeEMF() {
		emf.close();
	}
}

package com.acc.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;


@Configuration
public class AOPConfig {
	
	@Autowired
	private SessionFactory factory;
	
	@Bean(name = "hbTxMgr")
	public HibernateTransactionManager createHbTxMgr() {
		return new HibernateTransactionManager(factory);
		
	}

}

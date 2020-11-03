package com.acc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.acc.entity.TechnicalPanel;

@Configuration
@ComponentScan (basePackages = "com.nit.dao")
public class PersistenceConfig {
	
	@Autowired
	private DataSource ds;
	
	@Bean(name="sesFact")
	public LocalSessionFactoryBean createSessionFactory() {
		LocalSessionFactoryBean factory=null;
		Properties props=null;
		
		factory=new LocalSessionFactoryBean();
		System.out.println("DataSource class::"+ds.getClass());
		factory.setDataSource(ds);
		factory.setAnnotatedClasses(TechnicalPanel.class);
		
		props=new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		factory.setHibernateProperties(props);
		
		return factory;
		
	}
    @Bean(name="template")
	public HibernateTemplate configTemplate() {
		HibernateTemplate temp=null;
		temp=new HibernateTemplate();
		temp.setSessionFactory(createSessionFactory().getObject());
		return temp;
		
	}
    

}

package com.kirosys.eticket.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScans(value= {
		@ComponentScan("com.kirosys.eticket.dao"),
		@ComponentScan("com.kirosys.eticket.service")
})
public class AppConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		//mySql property.
		properties.put(DRIVER, environment.getProperty("mysql.driver"));
		properties.put(URL, environment.getProperty("mysql.url"));
		properties.put(USER, environment.getProperty("mysql.user"));
		properties.put(PASS, environment.getProperty("mysql.password"));
		//Hibernate Property.
		properties.put(SHOW_SQL, environment.getProperty("hibernate.show_sql"));
		properties.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(DIALECT, environment.getProperty("hibernate.dialect"));
		//Connection pooling property.
		properties.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
		properties.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
		properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
		properties.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));
		
		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setPackagesToScan("com.kirosys.eticket.model");
		return localSessionFactoryBean;
	}
    @Bean
    public HibernateTransactionManager getTransactionManager() {
    	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    	hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
		return hibernateTransactionManager;
    	
    }

}

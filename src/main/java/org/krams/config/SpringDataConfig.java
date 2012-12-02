package org.krams.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.krams.repository")
public class SpringDataConfig extends WebMvcConfigurerAdapter {

	@Autowired 
	private Environment env;
	
	// Declare a datasource that has pooling capabilities
	@Bean
	public DataSource dataSource() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(env.getRequiredProperty("app.jdbc.driverClassName"));
			ds.setJdbcUrl(env.getRequiredProperty("app.jdbc.url"));
			ds.setUser(env.getRequiredProperty("app.jdbc.username"));
			ds.setPassword(env.getRequiredProperty("app.jdbc.password"));
			ds.setAcquireIncrement(5);
			ds.setIdleConnectionTestPeriod(60);
			ds.setMaxPoolSize(100);
			ds.setMaxStatements(50);
			ds.setMinPoolSize(10);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Declare a JPA entityManagerFactory
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
		em.setPersistenceUnitName("hibernatePersistenceUnit");
		em.setDataSource(dataSource());
		
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setShowSql(false);
		em.setJpaVendorAdapter(vendor);
		
		return em;
	}
	
	// Declare a transaction manager
	@Bean 
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}

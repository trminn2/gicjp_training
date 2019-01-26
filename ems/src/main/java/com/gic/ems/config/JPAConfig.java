package com.gic.ems.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class JPAConfig.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class JPAConfig.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.gic.ems" })
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan("com.gic.ems")
public class JPAConfig {

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Entity manager factory.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		lcemf.setDataSource(dataSource());
		lcemf.setPackagesToScan(new String[] { this.env.getProperty("hibernate.entity") });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		lcemf.setJpaVendorAdapter(vendorAdapter);
		lcemf.setJpaProperties(additionalProperties());
		return lcemf;
	}

	/**
	 * Data source.
	 *
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.env.getProperty("mysql.driver"));
		dataSource.setUrl(this.env.getProperty("mysql.jdbcUrl"));
		dataSource.setUsername(this.env.getProperty("mysql.username"));
		dataSource.setPassword(this.env.getProperty("mysql.password"));
		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @param emf the emf
	 * @return PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	/**
	 * Exception translation.
	 *
	 * @return PersistenceExceptionTranslationPostProcessor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return Properties
	 */
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, this.env.getProperty("hibernate.dialet"));
		properties.put(AvailableSettings.SHOW_SQL, this.env.getProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, this.env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS,
				this.env.getProperty("hibernate.enable_lazy_load_no_trans"));
		return properties;
	}
}
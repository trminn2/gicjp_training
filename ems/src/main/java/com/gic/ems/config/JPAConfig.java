package com.gic.ems.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
 * @author KYIMINHAN Jan 5, 2019 </BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems </BR>
 *        com.gic.ems.config </BR>
 *        JPAConfig.java </BR>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.gic.ems" })
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan("com.gic.ems")
public class JPAConfig {

	/** The mysql driver. */
	@Value("${mysql.driver}")
	private String mysqlDriver;

	/** The jdbcURL. */
	@Value("${mysql.jdbcUrl}")
	private String jdbcURL;

	/** The user name. */
	@Value("${mysql.username}")
	private String userName;

	/** The password. */
	@Value("${mysql.password}")
	private String password;

	/** The hibernte dialet. */
	@Value("${hibernate.dialet}")
	private String hibernteDialet;

	/** The hibernate show sql. */
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	/** The hibernage hbm ddl auto. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernageHbmDdlAuto;

	/** The hibernate lazy load. */
	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String hibernateLazyLoad;

	/** The hibernate etities. */
	@Value("${hibernate.entity}")
	private String hibernateEtities;

	/**
	 * Entity manager factory.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		lcemf.setDataSource(getDataSource());
		lcemf.setPackagesToScan(new String[] { this.hibernateEtities });
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
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.mysqlDriver);
		dataSource.setUrl(this.jdbcURL);
		dataSource.setUsername(this.userName);
		dataSource.setPassword(this.password);
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
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, this.hibernteDialet);
		properties.put(AvailableSettings.SHOW_SQL, this.hibernateShowSql);
		properties.put(AvailableSettings.HBM2DDL_AUTO, this.hibernageHbmDdlAuto);
		properties.put(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, this.hibernateLazyLoad);
		return properties;
	}
}
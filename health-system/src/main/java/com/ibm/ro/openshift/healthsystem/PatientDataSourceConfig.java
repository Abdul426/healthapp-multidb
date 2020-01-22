package com.ibm.ro.openshift.healthsystem;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.ibm.ro.openshift.healthsystem.repository.patient",
    entityManagerFactoryRef = "patientEntityManagerFactory",
    transactionManagerRef = "patientTransactionManager"
)
public class PatientDataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.patient")
    public DataSourceProperties patientDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource patientDataSource() {
        DataSourceProperties primaryDataSourceProperties = patientDataSourceProperties();
        return DataSourceBuilder.create()
            .driverClassName(primaryDataSourceProperties.getDriverClassName())
            .url(primaryDataSourceProperties.getUrl())
            .username(primaryDataSourceProperties.getUsername())
            .password(primaryDataSourceProperties.getPassword())
            .build();
    }

    @Bean
    public PlatformTransactionManager patientTransactionManager() {
        EntityManagerFactory factory = patientEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean patientEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(patientDataSource());
        factory.setPackagesToScan(new String[] {
            "com.ibm.ro.openshift.healthsystem.model.patient"
        });
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);

        return factory;

    }

}
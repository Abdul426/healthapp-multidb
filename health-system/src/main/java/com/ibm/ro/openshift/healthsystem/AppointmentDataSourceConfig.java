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
    basePackages = "com.ibm.ro.openshift.healthsystem.repository.appointment",
    entityManagerFactoryRef = "appointmentEntityManagerFactory",
    transactionManagerRef = "appointmentTransactionManager"
)
public class AppointmentDataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.appointment")
    public DataSourceProperties appointmentDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource appointmentDataSource() {
        DataSourceProperties primaryDataSourceProperties = appointmentDataSourceProperties();
        return DataSourceBuilder.create()
            .driverClassName(primaryDataSourceProperties.getDriverClassName())
            .url(primaryDataSourceProperties.getUrl())
            .username(primaryDataSourceProperties.getUsername())
            .password(primaryDataSourceProperties.getPassword())
            .build();
    }

    @Bean
    public PlatformTransactionManager appointmentTransactionManager() {
        EntityManagerFactory factory = appointmentEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean appointmentEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(appointmentDataSource());
        factory.setPackagesToScan(new String[] {
            "com.ibm.ro.openshift.healthsystem.model.appointment"
        });
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);

        return factory;

    }

}
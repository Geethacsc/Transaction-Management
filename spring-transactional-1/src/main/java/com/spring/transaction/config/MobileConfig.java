package com.spring.transaction.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;

@Configuration
@ComponentScan(basePackages = "com")
public class MobileConfig {

	@Bean
	DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/mydb", "postgres", "admin");
	}

	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	TransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}

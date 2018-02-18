package org.petka.modules;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "twoEntityManagerFactory", basePackages = {
		"org.petka.modules.servicetwo" })
public class MSServiceTwoDBConf {

	@Primary
	@Bean(name = "twoDataSource")
	@ConfigurationProperties(prefix = "two.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "twoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean fooEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("twoDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("org.petka.modules.servicetwo").persistenceUnit("two").build();
	}

	@Primary
	@Bean(name = "twoTransactionManager")
	public PlatformTransactionManager fooTransactionManager(
			@Qualifier("twoEntityManagerFactory") EntityManagerFactory fooEntityManagerFactory) {
		return new JpaTransactionManager(fooEntityManagerFactory);
	}
}

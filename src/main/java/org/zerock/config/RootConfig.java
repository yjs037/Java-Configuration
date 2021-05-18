package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.sample"})
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("book_ex");
		hikariConfig.setPassword("book_ex");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		//HikariDataSource는 DataSource를 구현함
		//DataSource가 더 상위 인터페이스 타입이라 리턴가능
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
















}

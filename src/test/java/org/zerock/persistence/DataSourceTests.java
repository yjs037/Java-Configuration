package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;
	
	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testConnection() {

		try (Connection con = dataSource.getConnection()) {

			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
		
	@Test
	public void testMybatis() {
		
		//try 괄호안에 참조변수를 여러개 생성할 수 있고, 구분은 세미콜론을 이용한다.
		//Try-with-resources
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection()
		) { 
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

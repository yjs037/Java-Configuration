package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

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
@Log4j // sts에서 기본적으로 설정되어있음
public class SampleTests {

	@Setter(onMethod_ = { @Autowired }) // onMethod_ ->setter 메서드에 추가할 어노테이션을 지정
	private Restaurant restaurant;

	@Test
	public void testExist() {
		assertNotNull(restaurant); // 변수가 null이 아니면 테스트 성공

		log.info(restaurant);
		log.info("---------------------------------------");
		log.info(restaurant.getChef());

	}

}

package com.groos.common.feature;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class ExceptionManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Before
	public void before() {
		
	}
	
	@Test public void test() {
		
	}

}

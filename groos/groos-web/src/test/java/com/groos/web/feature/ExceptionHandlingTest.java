package com.groos.web.feature;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.groos.service.admin.CreateSampleService;

public class ExceptionHandlingTest { 
	
	private CreateSampleService createSampleService;
	
	@Test public void _00_샘플데이터가조회되어야한다() { 
		
		this.createSampleService = mock(CreateSampleService.class);
		
	}
	@Test public void _01_샘플데이터가존재하지않는다() {
		
	}
	@Test public void _02_샘플데이터가조회되어야한다() {
		
	}
	@Test public void _03_샘플데이터가조회되어야한다() {
		
	}
	@Test public void _04_샘플데이터가조회되어야한다() {
		
	}
	@Test public void _05_샘플데이터가조회되어야한다() {
		
	}

}

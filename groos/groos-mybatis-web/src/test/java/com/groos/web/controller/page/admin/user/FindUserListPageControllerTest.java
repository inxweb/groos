package com.groos.web.controller.page.admin.user;

import static junit.framework.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test/application-context.xml", "classpath:spring-test/application-servlet.xml"})
public class FindUserListPageControllerTest {
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	@Test
	public void 사용자목록이조회되어야한다() {
		 MockHttpServletRequest httpRequest = new MockHttpServletRequest("GET","/page/admin/user/findUserList.do");
  
		  MockHttpServletResponse response = new MockHttpServletResponse(); 
		  
		  Object handler;
		try {
			HandlerExecutionChain handlerExecutionChain =  this.handlerMapping.getHandler(httpRequest);
			
			handler = handlerExecutionChain.getHandler();
			
			  ModelAndView modelAndView = handlerAdapter.handle(httpRequest, response, handler);
			  assertThat(modelAndView.getViewName(), nullValue());	
			  
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
	}
}

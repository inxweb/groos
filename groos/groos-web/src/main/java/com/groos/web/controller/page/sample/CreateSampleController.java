package com.groos.web.controller.page.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groos.domain.model.Sample;
import com.groos.service.admin.CreateSampleService;

@Controller
@RequestMapping("page/sample")
public class CreateSampleController {
	
	@Autowired
	private CreateSampleService createSampleService;
	
	@RequestMapping(value="findSampleList.do", method=RequestMethod.GET)
	public void showForm(Model model, String sampleId) { 
		
		Sample sample = createSampleService.findSampleBySampleId(sampleId);
		
		 
		
	}
}

package com.groos.service.admin.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.groos.common.execption.*;
import com.groos.domain.model.*;
import com.groos.repository.*;
import com.groos.service.admin.*;

@Service
public class CreateSampleServiceImpl implements CreateSampleService {

	@Autowired
	private SampleRepository sampleRepository;

	@Override
	public Sample findSampleBySampleId(String sampleId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
	
}

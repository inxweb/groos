package com.groos.repository;

import java.util.List;

import com.groos.domain.model.Sample;

public interface SampleRepository {
	
	Sample selectById(String id);
	
	List<Sample> selectAllList();
	
	String insert(Sample sample);
	
	List<String> insertList(List<Sample> sampleList);
	
	void update(Sample sample);
	
	void updateList(List<Sample> sampleList);
	
	void delete(String id); 
	
	void deleteList(List<String> idList); 

}

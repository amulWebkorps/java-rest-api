package com.spring.app.service;

import java.util.List;

import com.spring.app.dto.EmployeeDto;
import com.spring.app.model.EmployeeEntity;

public interface EmployeeService {

	EmployeeDto saveDemoModel(EmployeeEntity demoModel);
	
	List<EmployeeDto> getAllDemoModel();
	
	EmployeeEntity findById(Long id);
	
	void deleteDemoModel(Long id);
	
	EmployeeDto updateDemoModel(EmployeeEntity demoModel);	
	
}

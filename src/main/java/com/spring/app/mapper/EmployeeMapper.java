package com.spring.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.spring.app.dto.EmployeeDto;
import com.spring.app.model.EmployeeEntity;

@Component
public class EmployeeMapper {
	
	/*
	 * dtoToEntity converts employeeDto class to employeeEntity class
	 */
	public EmployeeEntity dtoToEntity(EmployeeDto demoModelDto) {
		EmployeeEntity demoModel = new EmployeeEntity();
		
		if(demoModelDto != null) {
			BeanUtils.copyProperties(demoModelDto, demoModel);
		}
		return demoModel;
	}
	
	/*
	 * entityToDto converts EmployeeEntity class to EmployeeDto class
	 */
	public EmployeeDto entityToDto(EmployeeEntity demo) {
		
		EmployeeDto demoModel = new EmployeeDto();
		if(demo != null) {
			BeanUtils.copyProperties(demo, demoModel);
		}
		return demoModel;
	}
	
	/*
	 * entityToDto converts EmployeeEntity List to EmployeeDto List
	 */
	public List<EmployeeDto> entityToDtoList(List<EmployeeEntity> dmeoModelList){
		
		List<EmployeeDto> demoDtoList = new ArrayList<EmployeeDto>();
		
		dmeoModelList.forEach( temp -> {
			EmployeeDto demoDto = new EmployeeDto();
			BeanUtils.copyProperties(temp, demoDto);
			demoDtoList.add(demoDto);
		});
		
		return demoDtoList;
	}

}

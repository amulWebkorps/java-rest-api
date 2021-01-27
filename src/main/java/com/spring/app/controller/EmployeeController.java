package com.spring.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.JsonHelperObject;
import com.spring.app.dto.EmployeeDto;
import com.spring.app.exception.RecordNotFoundException;
import com.spring.app.mapper.EmployeeMapper;
import com.spring.app.model.EmployeeEntity;
import com.spring.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService demoService;

	@Autowired
	EmployeeMapper modelDemoMapper;

	/**
	 * saveDetails API is used to save employee details.
	 * @param empDto
	 * @return
	 */
	@PostMapping(path = "/save-employee")
	public ResponseEntity<JsonHelperObject> saveDetails(@Valid @RequestBody EmployeeDto empDto) {
		HttpStatus status = HttpStatus.OK;
		JsonHelperObject body = new JsonHelperObject(true, "Data not Saved", null);

		if (empDto != null) {
			EmployeeDto employeeDto = demoService.saveDemoModel(modelDemoMapper.dtoToEntity(empDto));

			if (employeeDto != null) {
				body = new JsonHelperObject(false, "Date saved Successfully", employeeDto);
				return new ResponseEntity<>(body, status);
			}
		}
		return new ResponseEntity<>(body, status);
	}
	
	/**
	 * getAllDetails API returns a list of all the employees
	 * @return
	 */
	@GetMapping(value = "/list-all-employee")
	public ResponseEntity<JsonHelperObject> getAllDetails() {
		HttpStatus status = HttpStatus.OK;
		JsonHelperObject body = new JsonHelperObject(true, "Data not fetched", null);

		List<EmployeeDto> empDtoList = demoService.getAllDemoModel();
		if (!empDtoList.isEmpty()) {
			System.out.println("List data :" + empDtoList);
			body = new JsonHelperObject(false, "Data fetched successfully", empDtoList);
			return new ResponseEntity<>(body, status);
		}
		return new ResponseEntity<>(body, status);
	}

	/**
	 * getDetailByid API returns employee details by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/get-employee-by-id/{id}")
	private ResponseEntity<JsonHelperObject> getDetailByid(@PathVariable Long id) {
		HttpStatus status = HttpStatus.OK;
		JsonHelperObject body = new JsonHelperObject(true, "Data not found for this id", null);

		EmployeeEntity employee = demoService.findById(id);
		if (employee == null) {
			throw new RecordNotFoundException("Data not found, Invalid id : " + id);
		}

		body = new JsonHelperObject(false, "Data fetched successfully", employee);
		return new ResponseEntity<>(body, status);
	}

}

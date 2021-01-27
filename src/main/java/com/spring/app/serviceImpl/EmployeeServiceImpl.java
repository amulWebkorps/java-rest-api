package com.spring.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.dto.EmployeeDto;
import com.spring.app.mapper.EmployeeMapper;
import com.spring.app.model.EmployeeEntity;
import com.spring.app.repository.EmployeeRepository;
import com.spring.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository modelRepository;

	@Autowired
	EmployeeMapper demoModelMapper;

	@Override
	public EmployeeDto saveDemoModel(EmployeeEntity demoModel) {
		EmployeeEntity demoModel1 = modelRepository.findById(demoModel.getId());
		if (demoModel1 == null) {
			return demoModelMapper.entityToDto(modelRepository.save(demoModel));
		} else {
			return null;
		}
	}

	@Override
	public List<EmployeeDto> getAllDemoModel() {
		return demoModelMapper.entityToDtoList(modelRepository.findAll());
	}

	@Override
	public EmployeeEntity findById(Long id) {
		Optional<EmployeeEntity> deOptional = modelRepository.findById(id);
		return deOptional.isPresent() ? deOptional.get() : null;
	}

	@Override
	public void deleteDemoModel(Long id) {
		modelRepository.deleteById(id);
	}

	@Override
	public EmployeeDto updateDemoModel(EmployeeEntity demoModel) {
		return demoModelMapper.entityToDto(modelRepository.save(demoModel));
	}

}

package com.rodrigues.cost.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigues.cost.api.document.Cost;
import com.rodrigues.cost.api.dto.CostDto;
import com.rodrigues.cost.api.form.CostForm;
import com.rodrigues.cost.api.repository.CostRepository;
import com.rodrigues.cost.api.service.CostService;

@Service
public class CostServiceImpl implements CostService {

	@Autowired
	private CostRepository costRepository;
	
	@Transactional
	@Override
	public CostDto create(CostForm costForm) {
		return new CostDto(costRepository.save(costForm.toDocument()));
	}

	@Override
	public CostDto getOne(String id) {
		return new CostDto(costRepository.findById(id).get());
	}

	@Override
	public List<CostDto> getAll() {
		return new CostDto().toListDto(costRepository.findAll());
	}

	@Transactional
	@Override
	public void delete(String id) {
		costRepository.deleteById(id);
	}

	@Transactional
	@Override
	public CostDto update(CostForm costForm, String id) {
		
		Optional<Cost> findById = costRepository.findById(id);
		
		if (findById.isPresent()) {
			findById.get().setName(costForm.getName());
			findById.get().setPayer(costForm.getPayer());
			costRepository.save(findById.get());
		}
		
		return new CostDto(findById.get());
	}

}

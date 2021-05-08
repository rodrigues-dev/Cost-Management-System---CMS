package com.rodrigues.cost.api.service;

import java.util.List;

import com.rodrigues.cost.api.dto.CostDto;
import com.rodrigues.cost.api.form.CostForm;

public interface CostService {

	public CostDto create (CostForm costForm);
	
	public CostDto getOne(String id);
	
	public List<CostDto> getAll ();
	
	public void delete(String id);
	
	public CostDto update(CostForm costForm, String id);
	
}

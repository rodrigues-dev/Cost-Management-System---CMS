package com.rodrigues.cost.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigues.cost.api.dto.CostDto;
import com.rodrigues.cost.api.form.CostForm;
import com.rodrigues.cost.api.service.impl.CostServiceImpl;

@RestController
@RequestMapping("/v1/costs")
public class CostController {

	@Autowired
	private CostServiceImpl costServiceImpl;
	
	@PostMapping()
	public ResponseEntity<CostDto> create (@RequestBody CostForm costForm) {
		CostDto costDto = costServiceImpl.create(costForm);
		return ResponseEntity.ok(costDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CostDto> getOne (@PathVariable String id) {
		return ResponseEntity.ok(costServiceImpl.getOne(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<CostDto>> getAll () {
		return ResponseEntity.ok(costServiceImpl.getAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable String id) {
		costServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CostDto> update (@RequestBody CostForm costForm, @PathVariable String id) {
		return ResponseEntity.ok(costServiceImpl.update(costForm, id));
	}
	
}

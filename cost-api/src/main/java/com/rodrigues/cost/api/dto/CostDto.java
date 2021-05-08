package com.rodrigues.cost.api.dto;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.rodrigues.cost.api.document.Cost;
import com.rodrigues.cost.api.enums.CostStatus;

import lombok.Data;

@Data
public class CostDto {

	public CostDto (Cost cost) {
		this.codigo = cost.getCodigo();
		this.name = cost.getName();
		this.payer = cost.getPayer();
		this.value = cost.getValue();
		this.dueDate = cost.getDueDate();
		this.status = cost.getStatus();
		this.comments = cost.getComments();
	}
	
	public CostDto () {
		
	}
	
	private String codigo;
	
	private String name;
	
	private String payer;
	
	private double value;
	
	private Date dueDate;
	
	private CostStatus status;
	
	private String comments;
	
	public List<CostDto> toListDto (List<Cost> cost) {
		return cost.stream().map(CostDto::new).collect(Collectors.toList());
	}
	
}

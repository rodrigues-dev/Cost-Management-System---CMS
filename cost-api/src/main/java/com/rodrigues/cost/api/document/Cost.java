package com.rodrigues.cost.api.document;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rodrigues.cost.api.enums.CostStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class Cost {

	@Id
	private String codigo;
	
	private String name;
	
	private String payer;
	
	private double value;
	
	private Date dueDate;
	
	private CostStatus status;
	
	private String comments;
	
}

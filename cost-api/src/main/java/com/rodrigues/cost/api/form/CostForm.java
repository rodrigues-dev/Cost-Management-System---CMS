package com.rodrigues.cost.api.form;


import java.util.Date;

import com.rodrigues.cost.api.document.Cost;
import com.rodrigues.cost.api.enums.CostStatus;

import lombok.Data;

@Data
public class CostForm {

	private String name;
	
	private String payer;
	
	private double value;
	
	private Date dueDate;
	
	private CostStatus status;
	
	private String comments;
	
	public Cost toDocument () {
		return Cost.builder()
				.name(this.name)
				.payer(this.payer)
				.value(this.value)
				.dueDate(this.dueDate)
				.status(this.status)
				.comments(this.comments)
				.build();
	}
}

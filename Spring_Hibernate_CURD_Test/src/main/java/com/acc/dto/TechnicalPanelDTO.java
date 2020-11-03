package com.acc.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TechnicalPanelDTO implements Serializable {

	private Integer panelId;
	
	private  String panel;
	
	private String techStream;
	
	private String detailTechStack;
	
	private boolean firstLevel;
	
	private boolean secondLevel;
	
	private boolean Managerial;

	
}

package com.acc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="TECHNICAL_PANEL")
public class TechnicalPanel implements Serializable {
	
	@Id
	@Type(type ="int")
	@GeneratedValue(strategy = GenerationType.AUTO ) 
	private Integer panelId;
	
	@Column(length = 20)
	@Type(type="string")
	private  String panel;
		
	@Column(length = 20)
	@Type(type="string")
	private String techStream;
	
	@Column(length = 20)
	@Type(type="string")
	private String detailTechStack;
	
	@Type(type = "yes_no")
	private boolean firstLevel;
	
	@Type(type = "yes_no")
	private boolean secondLevel;
	
	@Type(type = "yes_no")
	private boolean Managerial;

	
}

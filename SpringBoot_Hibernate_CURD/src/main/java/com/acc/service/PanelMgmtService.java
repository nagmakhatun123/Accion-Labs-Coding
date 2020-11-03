package com.acc.service;

import java.util.List;

import com.acc.dto.TechnicalPanelDTO;

public interface PanelMgmtService {
	
	public  String registerPanel(TechnicalPanelDTO  dto);
	public  Object  fetchPanelById(int id);
	public   String  modifyPanelById(int id, boolean first,boolean second,boolean managerial);
	public  String   removePanelById(int id);
	public  List<TechnicalPanelDTO>  fetchPanelsByTechStream(String tech);

}
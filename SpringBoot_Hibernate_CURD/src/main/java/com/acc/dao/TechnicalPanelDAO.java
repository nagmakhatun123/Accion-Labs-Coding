package com.acc.dao;

import java.util.List;

import com.acc.entity.TechnicalPanel;

public interface TechnicalPanelDAO {
	public Integer insert(TechnicalPanel entity);
	 public   TechnicalPanel   getPanelById(int id);
     public    boolean updatePanelById(int id, boolean first,boolean second,boolean managerial);
     public   boolean  deletePanelById(int id);
     public  List<TechnicalPanel> getPanelsByTechStream(String stream);
}

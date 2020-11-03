package com.acc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.acc.entity.TechnicalPanel;


@Repository("panelDAO")
@ComponentScan(basePackages ="com.acc.entity.TechnicalPanel" )
public class TechnicalPanelDAOImpl implements  TechnicalPanelDAO {
	public static final String  HQL_GET_PANEL_BY_TECH_STREAM="FROM com.acc.entity.TechnicalPanel WHERE techStream=:stream";
	 @Autowired
	 private HibernateTemplate   ht;

	@Override
	public Integer insert( TechnicalPanel panel) {
	      Integer idVal=0;
		 idVal=(Integer) ht.save(panel);
		return idVal;
	}

	@Override
	public  TechnicalPanel getPanelById(int id) {
		 TechnicalPanel panel=null;
		panel=ht.get( TechnicalPanel.class, id);
		return panel;
	}

	@Override
	public boolean updatePanelById(int id, boolean first,boolean second,boolean managerial) {
		TechnicalPanel panel=null;
		boolean flag=false;
		panel=ht.get(TechnicalPanel.class, id);
		 if(panel!=null) {
			 panel.setFirstLevel(first);
			 panel.setSecondLevel(second);
			 panel.setManagerial(managerial);
			 ht.update(panel);
			 flag=true;
		 }
		return flag;
	}

	@Override
	public boolean deletePanelById(int id) {
		  boolean flag=false;
		  TechnicalPanel panel=null;
		  //Load object by id
		  panel=ht.get(TechnicalPanel.class, id);
		  if(panel!=null) {
			  ht.delete(panel);
			  flag=true;
		  }
		return flag;
	}

	@Override
	public List<TechnicalPanel> getPanelsByTechStream(String stream) {
		List<TechnicalPanel> list=null;
		list=(List<TechnicalPanel>) ht.findByNamedQuery(HQL_GET_PANEL_BY_TECH_STREAM, stream);
		return list;
	}

}

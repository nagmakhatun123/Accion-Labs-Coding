package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.TechnicalPanelDAO;
import com.acc.dto.TechnicalPanelDTO;
import com.acc.entity.TechnicalPanel;

@Service("panelService")
@Transactional
public class PanelMgmtServiceImpl implements PanelMgmtService {
	@Autowired
	private TechnicalPanelDAO dao;

	@Override
	public String registerPanel(TechnicalPanelDTO dto) {
		TechnicalPanel entity=null;
		Integer idVal=0;
		entity=new TechnicalPanel();
		BeanUtils.copyProperties(dto,entity);
		idVal=dao.insert(entity);
		return "Panel is registered with the id ::"+idVal;
	}

	@Override
	public  Object fetchPanelById(int id) {
		TechnicalPanel panel=null;
		TechnicalPanelDTO dto=null;
		panel=dao.getPanelById(id);
	 
		 if(panel!=null) {
			 dto=new TechnicalPanelDTO();
		     BeanUtils.copyProperties(panel, dto);
		 }
		return dto!=null?dto:"record not found";
          
	}

	@Override
	public String modifyPanelById(int id, boolean first,boolean second,boolean managerial) {
		boolean flag=false;
		flag=dao.updatePanelById(id, first, second, managerial);
		return flag==false?"record not found for update": "record updated";
	}

	@Override
	public String removePanelById(int id) {
		   boolean flag=false;
		   flag=dao.deletePanelById(id);
		   
		return flag==true?"record found and deleted":"record not found for deletion";
	}

	@Override
	public List<TechnicalPanelDTO> fetchPanelsByTechStream(String tech) {
		List<TechnicalPanel> listEntities=null;
		List<TechnicalPanelDTO> listDTO=new ArrayList();

		listEntities=dao.getPanelsByTechStream(tech);

		listEntities.forEach(entity->{
			TechnicalPanelDTO dto=new TechnicalPanelDTO();
		   	BeanUtils.copyProperties(entity, dto);
		   	listDTO.add(dto);
		});
		
		return listDTO;
	}

}
package com.acc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acc.dto.TechnicalPanelDTO;
import com.acc.service.PanelMgmtService;

@SpringBootApplication
public class SpringBootHibernateCurdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		PanelMgmtService service = null;
		TechnicalPanelDTO dto = null,dto1=null;
		
		ctx = SpringApplication.run(SpringBootHibernateCurdApplication.class, args);
		
		service = ctx.getBean("panelService", PanelMgmtService.class);
		// save object
/*		try {
			dto = new TechnicalPanelDTO();
			dto.setPanel("Manas Maharana");
			dto.setTechStream("JAVA");
			dto.setDetailTechStack("");
			dto.setFirstLevel(true);
			dto.setSecondLevel(true);
			dto.setManagerial(false);
			System.out.println(service.registerPanel(dto));
			
			dto1 = new TechnicalPanelDTO();
			dto1.setPanel("Manas Maharana");
			dto.setTechStream("BA");
			dto1.setDetailTechStack("");
			dto1.setFirstLevel(true);
			dto1.setSecondLevel(true);
			dto1.setManagerial(true);
			System.out.println(service.registerPanel(dto1));
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("......................................");
		System.out.println("Panel details ::" + service.fetchPanelById(81));
		
		System.out.println("................................................");
		System.out.println("Panel updation::" + service.modifyPanelById(81, true, true, false));
		
		System.out.println("................................................");
	    System.out.println(" Panel deletion::"+service.removePanelById(82)); 
	    */
		System.out.println("-------------------------------------------"); 
		List<TechnicalPanelDTO> listDTO = service.fetchPanelsByTechStream("JAVA");

		listDTO.stream().forEach(System.out::println); 

		// close container
		((AbstractApplicationContext) ctx).close();
	}

}

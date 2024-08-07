package com.cpa.ehr.service.system;


import java.util.List;

import com.cpa.ehr.service.system.dto.TemplateDTO;

public interface TemplateService {

	TemplateDTO persistTemplate(TemplateDTO templateDTO);
	
	TemplateDTO retrieveAllTemplateBySystemId(Long systemId);
	
	TemplateDTO retrieveAllTemplateByEncId(Long systemId,Long encounterId,String examName);
	
	void removeTemplate(Long templateId);

	List<TemplateDTO> retrieveAllActiveTemplates();
	
	List<TemplateDTO> retrieveActiveTemplatesByEncId(Long encounterId);
}

package com.cpa.ehr.service.system.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.TemplateRepository;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.backend.dao.system.entities.Template;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.TemplateService;
import com.cpa.ehr.service.system.dto.TemplateDTO;
import com.cpa.ehr.service.system.dto.mapper.TemplateMapper;

@Service
public class TemplateServiceImpl implements TemplateService{
	private static final Logger LOG = LoggerFactory.getLogger(TemplateServiceImpl.class);

	@Autowired
	private TemplateMapper tempMapper;

	@Autowired
	private TemplateRepository tempRepository;
	
	@Autowired
	private EncounterRepository encounterRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public TemplateDTO persistTemplate(TemplateDTO templateDTO) {
		try {
			long version = 0;
			TemplateDTO templateList = this.retrieveAllTemplateBySystemId(templateDTO.getSystemId());
			if(templateList != null) {
				version = templateList.getVersion();
				this.removeTemplate(templateList.getTemplateId());
				templateDTO.setVersion(version+1);
				return this.insertTemplate(templateDTO);
			}
			else {
				templateDTO.setVersion(version+1);
				return this.insertTemplate(templateDTO);
			}
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting new version of template {}  " + "{" + templateDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting new version of template {} ", e);
		}
		return null;
	}

	@Override
	public TemplateDTO retrieveAllTemplateBySystemId(Long systemId) {
		try {
			Template templateList = tempRepository.findAllTemplatesBySystemId(systemId);
			return (templateList != null) ? tempMapper.entityToTemplateDTO(templateList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all templates by systemId {}  " + "{" + systemId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all templates by systemId {} ", e);
		}
		return null;
	}
	
	@Override
	public TemplateDTO retrieveAllTemplateByEncId(Long systemId, Long encounterId, String examName) {
		try {
			Encounter encData = encounterRepository.findOne(encounterId);
			long templateId = getExamId(examName, encData);
			
			Template templateList = tempRepository.findOne(templateId);
			//Template templateList = tempRepository.findAllTemplatesBySystemId(systemId);
			return (templateList != null) ? tempMapper.entityToTemplateDTO(templateList) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all templates by systemId  {}  " + "{" + systemId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all templates by systemId {} ", e);
		}
		return null;
	}

	@Override
	public void removeTemplate(Long templateId) {
		try {
			Template templateToDelete = tempRepository.findOne(templateId);
			if (templateToDelete != null) {
				templateToDelete.setActiveFlag("N");
				tempRepository.saveAndFlush(templateToDelete);
			}
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing template {}  " + "{" + templateId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing template {} ", e);
		}
	}

	public TemplateDTO insertTemplate(TemplateDTO templateDTO) {
		try {
			Template templateToInsert = tempMapper.templateDTOToEntity(templateDTO);
			Template insertedTemplate = tempRepository.save(templateToInsert);
			return (insertedTemplate != null) ? tempMapper.entityToTemplateDTO(insertedTemplate) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting template{}  " + "{" + templateDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting template {} ", e);
		}
		return null;
	}

	@Override
	public List<TemplateDTO> retrieveAllActiveTemplates() {
		try {
			List<Template> templates = tempRepository.findAllActiveTemplates();
			return (templates != null) ? tempMapper.entityListToTemplateDTOList(templates) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while  retrieving all active templates  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all active templates {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<TemplateDTO> retrieveActiveTemplatesByEncId(Long encounterId) {
		try {
			Encounter encObj = encounterRepository.findOne(encounterId);
			
			List<Template> templates = tempRepository.findTemplatesById(encObj.getPhysicalExamTempId(), encObj.getSimpleNeuroExamTempId(), 
					encObj.getCardioExamTempId(), encObj.getEyeExamTempId(), encObj.getDetailedExamTempId());

			return (templates != null) ? tempMapper.entityListToTemplateDTOList(templates) : null;
			
		}catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all active templates by Encounter id {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all active templates by Encounter id{} ", e);
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public long getExamId(String examName, Encounter enc) {
		long id =0;
		try {
			if(examName.equalsIgnoreCase("PHYSICAL EXAM")) {
				id = enc.getPhysicalExamTempId();
			}else if(examName.equalsIgnoreCase("SIMPLE-NEURO EXAM")) {
				id = enc.getSimpleNeuroExamTempId();
			}else if(examName.equalsIgnoreCase("CARDIOVASCULAR EXAM")) {
				id = enc.getCardioExamTempId();
			}else if(examName.equalsIgnoreCase("EYE EXAM")) {
				id = enc.getEyeExamTempId();
			}else if(examName.equalsIgnoreCase("DETAILED-NEURO EXAM")) {
				id = enc.getDetailedExamTempId();
			}
			
			return id;
		}catch (Exception e) {
			LOG.error("Error while retrieving exam id {} ", e);
		}
		return id;
		
	}
}

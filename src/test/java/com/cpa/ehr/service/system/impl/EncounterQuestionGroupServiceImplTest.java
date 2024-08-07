package com.cpa.ehr.service.system.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.system.EncounterQuestionGroupRepository;
import com.cpa.ehr.backend.dao.system.entities.EncounterQuestionGroup;
import com.cpa.ehr.service.patients.impl.PatientDetailsServiceImpl;
import com.cpa.ehr.service.system.EncounterQuestionGroupService;
import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;
import com.cpa.ehr.service.system.dto.mapper.EncounterQuestionGroupMapper;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class EncounterQuestionGroupServiceImplTest {

	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Encounter Location service. */
	@InjectMocks
	private static EncounterQuestionGroupServiceImpl encounterQuestionGroupService;
	
	@Mock
	private static EncounterQuestionGroupMapper encounterQuestionGroupMapper;
	
	@Mock
	private static EncounterQuestionGroupRepository encQuestionGroupRepository;
	
	@Test
	public void persistEncounterQuestionGroupTest() {
	
		final EncounterQuestionGroupDTO encounterQuestionGroupDTO = podam.manufacturePojo(EncounterQuestionGroupDTO.class);
		final EncounterQuestionGroup newEncounterQuestionGroup = podam.manufacturePojo(EncounterQuestionGroup.class);
		
		when(encounterQuestionGroupMapper.encounterQuestionGroupDTOToEntity(encounterQuestionGroupDTO)).thenReturn(newEncounterQuestionGroup);
		when(encQuestionGroupRepository.save(newEncounterQuestionGroup)).thenReturn(newEncounterQuestionGroup);
		when(encounterQuestionGroupMapper.entityToEncounterQuestionGroupDTO(newEncounterQuestionGroup)).thenReturn(encounterQuestionGroupDTO);
	
		encounterQuestionGroupService.persistEncounterQuestionGroup(encounterQuestionGroupDTO);
	}

	@Test
	public void persistEncounterQuestionGroupIfNullTest() {
	
		final EncounterQuestionGroupDTO encounterQuestionGroupDTO = podam.manufacturePojo(EncounterQuestionGroupDTO.class);
		final EncounterQuestionGroup newEncounterQuestionGroup = podam.manufacturePojo(EncounterQuestionGroup.class);
		
		when(encounterQuestionGroupMapper.encounterQuestionGroupDTOToEntity(encounterQuestionGroupDTO)).thenReturn(null);

		encounterQuestionGroupService.persistEncounterQuestionGroup(encounterQuestionGroupDTO);
	}
	
	@Test
	public void persistEncounterQuestionGroupIfDTONullTest() {
	
		final EncounterQuestionGroupDTO encounterQuestionGroupDTO = null;
		final EncounterQuestionGroup newEncounterQuestionGroup = podam.manufacturePojo(EncounterQuestionGroup.class);
		
		when(encounterQuestionGroupMapper.encounterQuestionGroupDTOToEntity(encounterQuestionGroupDTO)).thenReturn(null);
//		when(encQuestionGroupRepository.save(newEncounterQuestionGroup)).thenReturn(newEncounterQuestionGroup);
//		when(encounterQuestionGroupMapper.entityToEncounterQuestionGroupDTO(newEncounterQuestionGroup)).thenReturn(encounterQuestionGroupDTO);
//	
		encounterQuestionGroupService.persistEncounterQuestionGroup(encounterQuestionGroupDTO);
	}

	
}

package com.cpa.ehr.service.system.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.system.EncQuestionOptionRepository;
import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.EncQuestionOption;
import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;
import com.cpa.ehr.service.system.dto.mapper.EncQuestionOptionMapper;
import com.cpa.ehr.service.system.dto.mapper.EncounterMapper;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class EncQuestionOptionServiceImplTest {

	protected PodamFactory podam = new PodamFactoryImpl();

	@InjectMocks
	private static EncQuestionOptionServiceImpl encQuestionOptionService;
	
	@Mock
	private static EncQuestionOptionMapper encQuestionOptionMapper;
	
	@Mock
	private static EncQuestionOptionRepository encQuestionOptionRepository;
	
	
	@Test
	public void persistEncounterQuestionOptionTest() {
		final EncQuestionOptionDTO encQuestionOptionDTO = podam.manufacturePojo(EncQuestionOptionDTO.class);
		final EncQuestionOption newEncounterQuestionOption = podam.manufacturePojo(EncQuestionOption.class);
		final EncQuestionOption createdEncounterQuestionOption =  podam.manufacturePojo(EncQuestionOption.class);
		
		when(encQuestionOptionMapper.encQuestionOptionDTOToEntity(encQuestionOptionDTO)).thenReturn(newEncounterQuestionOption);
		when(encQuestionOptionRepository.save(newEncounterQuestionOption)).thenReturn(createdEncounterQuestionOption);
		when(encQuestionOptionMapper.entityToEncQuestionOptionDTO(createdEncounterQuestionOption)).thenReturn(encQuestionOptionDTO);
	
		encQuestionOptionService.persistEncounterQuestionOption(encQuestionOptionDTO);
	}

	@Test
	public void persistEncounterQuestionOptionIfNullTest() {
		final EncQuestionOptionDTO encQuestionOptionDTO = null;
		final EncQuestionOption newEncounterQuestionOption = podam.manufacturePojo(EncQuestionOption.class);
		final EncQuestionOption createdEncounterQuestionOption =  podam.manufacturePojo(EncQuestionOption.class);
		
		when(encQuestionOptionMapper.encQuestionOptionDTOToEntity(encQuestionOptionDTO)).thenReturn(newEncounterQuestionOption);
		when(encQuestionOptionRepository.save(newEncounterQuestionOption)).thenReturn(createdEncounterQuestionOption);
		when(encQuestionOptionMapper.entityToEncQuestionOptionDTO(createdEncounterQuestionOption)).thenReturn(encQuestionOptionDTO);
	
		encQuestionOptionService.persistEncounterQuestionOption(encQuestionOptionDTO);
	}
	
	@Test
	public void persistEncounterQuestionOptionIfExceptionTest() {
		final EncQuestionOptionDTO encQuestionOptionDTO = podam.manufacturePojo(EncQuestionOptionDTO.class);
		final EncQuestionOption newEncounterQuestionOption = podam.manufacturePojo(EncQuestionOption.class);
		final EncQuestionOption createdEncounterQuestionOption =  podam.manufacturePojo(EncQuestionOption.class);
		
		when(encQuestionOptionMapper.encQuestionOptionDTOToEntity(encQuestionOptionDTO)).thenThrow(new RuntimeException());
	
		encQuestionOptionService.persistEncounterQuestionOption(encQuestionOptionDTO);
	}
	
	@Test
	public void persistEncounterQuestionOptionIfcreatedEncounterQuestionOptionTest() {
		final EncQuestionOptionDTO encQuestionOptionDTO = podam.manufacturePojo(EncQuestionOptionDTO.class);
		final EncQuestionOption newEncounterQuestionOption = podam.manufacturePojo(EncQuestionOption.class);
		final EncQuestionOption createdEncounterQuestionOption =  null;
		
		when(encQuestionOptionMapper.encQuestionOptionDTOToEntity(encQuestionOptionDTO)).thenReturn(newEncounterQuestionOption);
		when(encQuestionOptionRepository.save(newEncounterQuestionOption)).thenReturn(null);
		when(encQuestionOptionMapper.entityToEncQuestionOptionDTO(createdEncounterQuestionOption)).thenReturn(encQuestionOptionDTO);
	
		encQuestionOptionService.persistEncounterQuestionOption(encQuestionOptionDTO);
	}
}

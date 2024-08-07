package com.cpa.ehr.service.system.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.backend.dao.system.ChiefCompliantDetailsRepository;
import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.impl.PatientDetailsServiceImpl;
import com.cpa.ehr.service.system.ChiefCompliantDetailsService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.mapper.ChiefCompliantDetailsMapper;

import cucumber.runtime.Runtime;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class ChiefCompliantDetailsServiceImplTest {

	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Encounter Location service. */
	@InjectMocks
	private static ChiefCompliantDetailsServiceImpl chiefCompliantDetailsService;
	
//	@Mock
//	private ChiefCompliantDetailsService chiefCompliantDetailsService;
//	
	@Mock
	private ChiefCompliantDetailsMapper chiefCompliantDetailsMapper;

	@Mock
	private ChiefCompliantDetailsRepository chiefCompliantDetailsRepo;

	@Test
	public void persistChiefCompliantDetailsTest() {
	
		ChiefCompliantDetailsDTO chiefCompliantDetailsDTO = podam.manufacturePojo(ChiefCompliantDetailsDTO.class);
		ChiefCompliantDetails chiefCompliantDetailsToInsert = podam.manufacturePojo(ChiefCompliantDetails.class);
		ChiefCompliantDetails insertedChiefCompliantDetails = podam.manufacturePojo(ChiefCompliantDetails.class);
		
		when(chiefCompliantDetailsMapper.chiefCompliantDetailsDTOToEntity(chiefCompliantDetailsDTO)).thenReturn(chiefCompliantDetailsToInsert);
		when(chiefCompliantDetailsRepo.save(chiefCompliantDetailsToInsert)).thenReturn(chiefCompliantDetailsToInsert);
		when(chiefCompliantDetailsMapper.entityToChiefCompliantDetailsDTO(chiefCompliantDetailsToInsert)).thenReturn(chiefCompliantDetailsDTO);
	
		chiefCompliantDetailsService.persistChiefCompliantDetails(chiefCompliantDetailsDTO);		
	}
	
	@Test
	public void persistChiefCompliantDetailsIfExceptionTest() {
	
		ChiefCompliantDetailsDTO chiefCompliantDetailsDTO = podam.manufacturePojo(ChiefCompliantDetailsDTO.class);
		ChiefCompliantDetails chiefCompliantDetailsToInsert = podam.manufacturePojo(ChiefCompliantDetails.class);
		ChiefCompliantDetails insertedChiefCompliantDetails = podam.manufacturePojo(ChiefCompliantDetails.class);
		
		when(chiefCompliantDetailsMapper.chiefCompliantDetailsDTOToEntity(chiefCompliantDetailsDTO)).thenThrow(new RuntimeException());
//		when(chiefCompliantDetailsRepo.save(chiefCompliantDetailsToInsert)).thenReturn(chiefCompliantDetailsToInsert);
//		when(chiefCompliantDetailsMapper.entityToChiefCompliantDetailsDTO(chiefCompliantDetailsToInsert)).thenReturn(chiefCompliantDetailsDTO);
//	
		chiefCompliantDetailsService.persistChiefCompliantDetails(chiefCompliantDetailsDTO);
		
	}

}

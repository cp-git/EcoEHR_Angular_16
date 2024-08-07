package com.cpa.ehr.service.system.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.service.system.dto.mapper.EncounterMapper;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class EncounterServiceImplTest {

	protected PodamFactory podam = new PodamFactoryImpl();

	@InjectMocks
	private static EncounterServiceImpl encounterService;
	
	@Mock 
	private static EncounterMapper encounterMapper;

	@Mock 
	private static EncounterRepository encounterRepo;
	
	@Mock 
	private static ClinicLocationRepository clinicLocRepo;
	
	@Mock 
	private static StaffMemberRepository staffMemberRepo;
	
	@Test
	public void persistEncounterTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounterToInsert =podam.manufacturePojo(Encounter.class);
		final Encounter insertedEncounter =podam.manufacturePojo(Encounter.class);
		
		
		when(encounterMapper.encounterDTOToEntity(encounterDTO)).thenReturn(encounterToInsert);
		when(encounterRepo.save(encounterToInsert)).thenReturn(insertedEncounter);
		when(encounterMapper.entityToEncounterDTO(insertedEncounter)).thenReturn(encounterDTO);
		encounterService.persistEncounter(encounterDTO);
		
	}
	
	@Test
	public void persistEncounterIfNullTest() {
		
		final EncounterDTO encounterDTO = null;
		final Encounter encounterToInsert =podam.manufacturePojo(Encounter.class);
		final Encounter insertedEncounter =podam.manufacturePojo(Encounter.class);
		
		
		when(encounterMapper.encounterDTOToEntity(encounterDTO)).thenReturn(encounterToInsert);
		when(encounterRepo.save(encounterToInsert)).thenReturn(insertedEncounter);
		when(encounterMapper.entityToEncounterDTO(insertedEncounter)).thenReturn(encounterDTO);
		encounterService.persistEncounter(encounterDTO);
		
	}
	
	@Test
	public void persistEncounterIfEncounterNullTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounterToInsert =podam.manufacturePojo(Encounter.class);
		final Encounter insertedEncounter =null;
		
		
		when(encounterMapper.encounterDTOToEntity(encounterDTO)).thenReturn(encounterToInsert);
		when(encounterRepo.save(encounterToInsert)).thenReturn(null);
		encounterService.persistEncounter(encounterDTO);
		
	}
	
	@Test
	public void persistEncounterIfExceptionTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounterToInsert =podam.manufacturePojo(Encounter.class);
		final Encounter insertedEncounter =podam.manufacturePojo(Encounter.class);
		
		
		when(encounterMapper.encounterDTOToEntity(encounterDTO)).thenReturn(encounterToInsert);
		when(encounterRepo.save(encounterToInsert)).thenThrow(new RuntimeException());
		encounterService.persistEncounter(encounterDTO);
		
	}
	
	@Test
	public void retrieveEncounterByEncounterIdTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounter =podam.manufacturePojo(Encounter.class);
		
		
		when(encounterRepo.findOne(1L)).thenReturn(encounter);
		when(encounterMapper.entityToEncounterDTO(encounter)).thenReturn(encounterDTO);
		encounterService.retrieveEncounterByEncounterId(1L);
		
	}
	
	@Test
	public void retrieveEncounterByEncounterIdIfNullTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounter =null;
		
		
		when(encounterRepo.findOne(1L)).thenReturn(null);
		//when(encounterMapper.entityToEncounterDTO(encounter)).thenReturn(null);
		encounterService.retrieveEncounterByEncounterId(1L);
		
	}
	
	@Test
	public void retrieveEncounterByEncounterIdIfExceptionTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		final Encounter encounter =podam.manufacturePojo(Encounter.class);
		
		
		when(encounterRepo.findOne(1L)).thenThrow(new RuntimeException());
		//when(encounterMapper.entityToEncounterDTO(encounter)).thenReturn(encounterDTO);
		encounterService.retrieveEncounterByEncounterId(1L);
		
	}
	
	@Test
	public void retrieveAllEncounterByPatientIdTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		List<EncounterDTO> encounterDtolist = ImmutableList.of(encounterDTO);
		
		final Encounter encounter =podam.manufacturePojo(Encounter.class);
		List<Encounter> encounterlist = ImmutableList.of(encounter);
		
		when(encounterRepo.findAllEncounterByPatientId(1L)).thenReturn(encounterlist);
		
		when(encounterMapper.entityListToEncounterDTOList(encounterlist)).thenReturn(encounterDtolist);
		encounterService.retrieveAllEncounterByPatientId(1L);
		
	}
	
	@Test
	public void retrieveAllEncounterByPatientIdIfNUllTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		List<EncounterDTO> encounterDtolist = ImmutableList.of(encounterDTO);
		
		final Encounter encounter =null;
		List<Encounter> encounterlist =null;
		
		when(encounterRepo.findAllEncounterByPatientId(1L)).thenReturn(encounterlist);
		
		when(encounterMapper.entityListToEncounterDTOList(encounterlist)).thenReturn(encounterDtolist);
		encounterService.retrieveAllEncounterByPatientId(1L);
		
	}
	
	@Test
	public void retrieveAllEncounterByPatientIdIfExceptiopnTest() {
		
		final EncounterDTO encounterDTO = podam.manufacturePojo(EncounterDTO.class);
		List<EncounterDTO> encounterDtolist = ImmutableList.of(encounterDTO);
		
		final Encounter encounter =null;
		List<Encounter> encounterlist =null;
		
		when(encounterRepo.findAllEncounterByPatientId(1L)).thenThrow(new RuntimeException());
		
		//when(encounterMapper.entityListToEncounterDTOList(encounterlist)).thenReturn(encounterDtolist);
		encounterService.retrieveAllEncounterByPatientId(1L);
		
	}
}

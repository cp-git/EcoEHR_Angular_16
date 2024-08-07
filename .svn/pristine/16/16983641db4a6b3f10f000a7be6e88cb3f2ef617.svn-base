package com.cpa.ehr.service.patients.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.patients.PatientDetailsRepository;
import com.cpa.ehr.backend.dao.patients.PatientRecordRepository;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.service.patients.dto.mapper.PatientDetailsMapper;
import com.cpa.ehr.service.patients.dto.mapper.PatientRecordMapper;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class PatientDetailsServiceImplTest {

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Encounter Location service. */
	@InjectMocks
	private static PatientDetailsServiceImpl patientDetailsService;
	
	@Mock
	private static PatientDetailsRepository patientDetailsRepo;
	
	@Mock
	private static PatientRecordRepository patientRecordRepo;
	
	@Mock
	private static OrganizationRepository orgRepo;
	
	@Mock
	private static PatientDetailsMapper patientDetailsMapper;	
	
	@Mock
	private static PatientRecordMapper patientRecordMapper;	
	
	@Mock
	private static ClinicLocationRepository clinicLocationRepository;
	
	@Mock
	private static StaffMemberRepository staffmemberRepository;
	

	
	@Test
	public void persistPatientDetailsTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsMapper.patientDetailsDTOToEntity(patDetailsDTOResp)).thenReturn(patientDetails);
		when(patientDetailsRepo.save(patientDetails)).thenReturn(patientDetails);
		when(patientDetailsMapper.entityToPatientDetailsDTO(patientDetails)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		final PatientDetailsDTO response = patientDetailsService.persistPatientDetails(patDetailsDTOResp);

		//Assert whether the responses are correct
		assertNotNull(response);
		assertEquals(response.getPatientId(), patDetailsDTOResp.getPatientId());
		assertEquals(response.getFirstName(), patDetailsDTOResp.getFirstName());
		assertEquals(response.getMiddleName(), patDetailsDTOResp.getMiddleName());
		assertEquals(response.getLastName(), patDetailsDTOResp.getLastName());
		assertEquals(response.getPatientImage(), patDetailsDTOResp.getPatientImage());
		assertEquals(response.getGender(), patDetailsDTOResp.getGender());
		assertEquals(response.getDob(), patDetailsDTOResp.getDob());
		assertEquals(response.getPrimaryEmail(), patDetailsDTOResp.getPrimaryEmail());
		assertEquals(response.getSecondaryEmail(), patDetailsDTOResp.getSecondaryEmail());
		assertEquals(response.getPrimaryNo(), patDetailsDTOResp.getPrimaryNo());
		assertEquals(response.getSecondaryNo(), patDetailsDTOResp.getSecondaryNo());
		
	}
	
	@Test
	public void persistPatientDetailsIfNullTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		final PatientDetailsDTO patDetailsDTOResp = null;
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsMapper.patientDetailsDTOToEntity(patDetailsDTOResp)).thenReturn(patientDetails);
		when(patientDetailsRepo.save(patientDetails)).thenReturn(patientDetails);
		when(patientDetailsMapper.entityToPatientDetailsDTO(patientDetails)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.persistPatientDetails(patDetailsDTOResp);
	
	}

	@Test
	public void persistPatientDetailsIfPatientDetailIsNullTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsMapper.patientDetailsDTOToEntity(patDetailsDTOResp)).thenReturn(patientDetails);
		when(patientDetailsRepo.save(patientDetails)).thenReturn(null);
	
		//Invoke the actual service implementation
		patientDetailsService.persistPatientDetails(patDetailsDTOResp);
		
	}
	
	@Test
	public void persistPatientDetailsIfExceptionTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsMapper.patientDetailsDTOToEntity(patDetailsDTOResp)).thenReturn(patientDetails);
		when(patientDetailsRepo.save(patientDetails)).thenThrow(new NullPointerException());	
				
		//Invoke the actual service implementation
		patientDetailsService.persistPatientDetails(patDetailsDTOResp);
		
	}
	
	@Test
	public void retrieveAllPatientsTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		List<PatientDetails> patientDetailslist = ImmutableList.of(patientDetails);
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		List<PatientDetailsDTO> patDetailsDTOlist = ImmutableList.of(patDetailsDTOResp);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsMapper.entityListToPatientDetailsDTOList(patientDetailslist)).thenReturn(patDetailsDTOlist);
		
		//Invoke the actual service implementation
		patientDetailsService.retrieveAllPatients();
		
	}
	
	@Test
	public void retrieveAllPatientsIfPatientDetailIsEmptyTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		List<PatientDetails> patientDetailslist = null;
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		List<PatientDetailsDTO> patDetailsDTOlist = ImmutableList.of(patDetailsDTOResp);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsRepo.findAllPatients()).thenReturn(null);
		when(patientDetailsMapper.entityListToPatientDetailsDTOList(patientDetailslist)).thenReturn(null);
		
		//Invoke the actual service implementation
		patientDetailsService.retrieveAllPatients();
		
	}
	
	@Test
	public void retrieveAllPatientsIfExceptionTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		List<PatientDetails> patientDetailslist = ImmutableList.of(patientDetails);
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		List<PatientDetailsDTO> patDetailsDTOlist = ImmutableList.of(patDetailsDTOResp);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsRepo.findAllPatients()).thenThrow(new NullPointerException());
		
		//Invoke the actual service implementation
		patientDetailsService.retrieveAllPatients();
		
	}
	
	@Test
	public void retrieveAllActivePatientsTest() {
		
		final PatientRecord patientRecord = podam.manufacturePojo(PatientRecord.class);
		List<PatientRecord> patientRecordlist = ImmutableList.of(patientRecord);
		
		final PatientRecordDTO patrecordDTOResp = podam.manufacturePojo(PatientRecordDTO.class);
		List<PatientRecordDTO> patientRecordDtolist = ImmutableList.of(patrecordDTOResp);
		
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientRecordRepo.findAllActivePatientsfromView(1L)).thenReturn(patientRecordlist);
		when(patientRecordMapper.entityListToPatientRecordDTOList(patientRecordlist)).thenReturn(patientRecordDtolist);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrieveAllActivePatients(1L);
	
	}
	
	@Test
	public void retrieveAllActivePatientsIfNullTest() {
		
		final PatientRecord patientRecord = podam.manufacturePojo(PatientRecord.class);
		List<PatientRecord> patientRecordlist = ImmutableList.of(patientRecord);
		
		final PatientRecordDTO patrecordDTOResp = podam.manufacturePojo(PatientRecordDTO.class);
		List<PatientRecordDTO> patientRecordDtolist = ImmutableList.of(patrecordDTOResp);
		
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientRecordRepo.findAllActivePatientsfromView(1L)).thenReturn(null);
		when(patientRecordMapper.entityListToPatientRecordDTOList(patientRecordlist)).thenReturn(null);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrieveAllActivePatients(1L);
	
	}
	
	@Test
	public void retrievePatientRecordPatientIdTest() {
		
		final PatientRecord patientRecord = podam.manufacturePojo(PatientRecord.class);
		
		final PatientRecordDTO patrecordDTOResp = podam.manufacturePojo(PatientRecordDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientRecordRepo.findPatientRecordByPatientId(1L,1L)).thenReturn(patientRecord);
		when(patientRecordMapper.entityToPatientRecordDTO(patientRecord)).thenReturn(patrecordDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientRecordPatientId(1L,1L);
	
	}
	
	@Test
	public void retrievePatientRecordPatientIdIfNullTest() {
		
		final PatientRecord patientRecord = podam.manufacturePojo(PatientRecord.class);
		
		final PatientRecordDTO patrecordDTOResp = podam.manufacturePojo(PatientRecordDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientRecordRepo.findPatientRecordByPatientId(1L,1L)).thenReturn(null);
		//when(patientRecordMapper.entityToPatientRecordDTO(patientRecord)).thenReturn(null);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientRecordPatientId(1L,1L);
	
	}
	
	
	
	@Test
	public void retrievePatientRecordPatientIdIfExceptionTest() {
		
		final PatientRecord patientRecord = podam.manufacturePojo(PatientRecord.class);
		
		final PatientRecordDTO patrecordDTOResp = podam.manufacturePojo(PatientRecordDTO.class);
		List<PatientRecordDTO> patientRecordDtolist = ImmutableList.of(patrecordDTOResp);
		
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientRecordRepo.findPatientRecordByPatientId(1L,1L)).thenThrow(new NullPointerException());
		//when(patientRecordMapper.entityToPatientRecordDTO(patientRecord)).thenReturn(null);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientRecordPatientId(1L,1L);
	
	}
	
	
	@Test
	public void retrievePatientDetailsPatientIdTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsRepo.findPatientDetailsByPatientId(1L)).thenReturn(patientDetails);
		when(patientDetailsMapper.entityToPatientDetailsDTO(patientDetails)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientDetailsPatientId(1L);
	
	}
	
	@Test
	public void retrievePatientDetailsPatientIdIfExceptionTest() {
		
		final PatientDetails patientDetails = podam.manufacturePojo(PatientDetails.class);
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsRepo.findPatientDetailsByPatientId(1L)).thenThrow(new NullPointerException());
		//when(patientDetailsMapper.entityToPatientDetailsDTO(patientDetails)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientDetailsPatientId(1L);
	
	}
	
	@Test
	public void retrievePatientDetailsPatientIdIfNullTest() {
		
		final PatientDetails patientDetails =null;
		
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		//Spy the repository & mapper methods and respond with mock response object
		when(patientDetailsRepo.findPatientDetailsByPatientId(1L)).thenReturn(patientDetails);
		when(patientDetailsMapper.entityToPatientDetailsDTO(null)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.retrievePatientDetailsPatientId(1L);
	
	}
	
	@Test
	public void modifyPatientDetailsTest() {
		
		final PatientDetails patientDetailsToUpdate = podam.manufacturePojo(PatientDetails.class);
		final ClinicLocation clinicLoc = podam.manufacturePojo(ClinicLocation.class);
		final StaffMember staff =podam.manufacturePojo(StaffMember.class);
		
		final PatientDetails updatedPatientDetails = podam.manufacturePojo(PatientDetails.class);
		final PatientDetailsDTO patDetailsDTOResp = podam.manufacturePojo(PatientDetailsDTO.class);
		
		patientDetailsToUpdate.setClinicLocation(clinicLoc);
		patientDetailsToUpdate.setStaffMember(staff);
		patientDetailsToUpdate.setPatientId(1L);
		patientDetailsToUpdate.setFirstName("AAA");
		patientDetailsToUpdate.setMiddleName("BBB");
		patientDetailsToUpdate.setLastName("ZZZ");
		patientDetailsToUpdate.setGender("Female");

		when(patientDetailsRepo.findOne(1L)).thenReturn(patientDetailsToUpdate);
		when(clinicLocationRepository.findOne(1L)).thenReturn(clinicLoc);
		when(staffmemberRepository.findOne(1L)).thenReturn(staff);
		
		when(patientDetailsRepo.save(patientDetailsToUpdate)).thenReturn(updatedPatientDetails);
		when(patientDetailsMapper.entityToPatientDetailsDTO(updatedPatientDetails)).thenReturn(patDetailsDTOResp);
				
		//Invoke the actual service implementation
		 patientDetailsService.modifyPatientDetails(patDetailsDTOResp);
	
	}
	
	
}

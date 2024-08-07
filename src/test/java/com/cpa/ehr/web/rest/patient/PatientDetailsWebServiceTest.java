package com.cpa.ehr.web.rest.patient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.patients.PatientDetailsService;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import com.cpa.ehr.web.rest.admin.MasterLookupWebService;
import com.cpa.ehr.web.rest.patients.PatientDetailsWebService;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PatientDetailsWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Master Lookup Web service. */
	@InjectMocks
	protected PatientDetailsWebService patientdetailsWebService;

	/** The Encounter Location service. */
	@Mock
	private PatientDetailsService patientDetailsService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(patientdetailsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	@Test
	public void getAllPatientsTest() throws Exception {
		PatientDetailsDTO patientdetailsDto = podam.manufacturePojo(PatientDetailsDTO.class);
		List<PatientDetailsDTO> patientdetaillist = ImmutableList.of(patientdetailsDto);
		when(patientDetailsService.retrieveAllPatients()).thenReturn(patientdetaillist);
		
		mockMvc.perform(get("/api/rest/patients/getAllPatients")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getListOfActivePatientsTest() throws Exception {
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		PatientRecordDTO patientrecordDto = podam.manufacturePojo(PatientRecordDTO.class);
		List<PatientRecordDTO> patientdetaillist = ImmutableList.of(patientrecordDto);
		when(patientDetailsService.retrieveAllActivePatients(1L)).thenReturn(patientdetaillist);
		
		mockMvc.perform(get("/api/rest/patients/getListOfActivePatientsfromsView")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getPatientRecordByPatientIdTest() throws Exception {
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		PatientRecordDTO patientrecordDto = podam.manufacturePojo(PatientRecordDTO.class);
		when(patientDetailsService.retrievePatientRecordPatientId(1L,1L)).thenReturn(patientrecordDto);
		
		mockMvc.perform(get("/api/rest/patients/getPatientRecordByPatientId?patientId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getPatientDetailsPatientIdTest() throws Exception {
		
		PatientDetailsDTO patientdetailsDto = podam.manufacturePojo(PatientDetailsDTO.class);
		when(patientDetailsService.retrievePatientDetailsPatientId(1L)).thenReturn(patientdetailsDto);
		
		mockMvc.perform(get("/api/rest/patients/getPatientByPatientId?patientId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void modifyPatientDetailsTest() throws Exception{
		
		
		final PatientDetailsDTO patientDetailDto = podam.manufacturePojo(PatientDetailsDTO.class);
		
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
		
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(patientDetailDto, loginUser);
		
	
		
		mockMvc.perform(
				put("/api/rest/patients/modifyPatientDetails?patientDetailDto").contentType(MediaType.APPLICATION_JSON)
				.content(FormatConverterUtils.convertObjectToJson(patientDetailDto)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void modifyPatientDetailsWhenStaffIdIsEqualTest() throws Exception{
		
		final PatientDetailsDTO staffmemberDto_1 = podam.manufacturePojo(PatientDetailsDTO.class);
		staffmemberDto_1.setStaffId(1L);
		
		
		final PatientDetailsDTO staffmemberDto_2 = podam.manufacturePojo(PatientDetailsDTO.class);
		staffmemberDto_2.setStaffId(2L);
		
		List<PatientDetailsDTO> staffDTOList = new ArrayList<PatientDetailsDTO>();
		staffDTOList.add(staffmemberDto_1);
		staffDTOList.add(staffmemberDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(staffmemberDto_1,"staffmemberDto_1");
		
		 when(patientDetailsService.retrieveAllPatients()).thenReturn(staffDTOList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(staffmemberDto_1, loginUser);
		
		patientdetailsWebService.validatePatientData(staffmemberDto_1, errors);
		
	}
	
	@Test
	public void modifyPatientDetailsWhenFirstNameIsEqualTest() throws Exception{
		
		final PatientDetailsDTO patientDetailsDto_1 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_1.setStaffId(1L);
		patientDetailsDto_1.setFirstName("AAA");
	
		
		final PatientDetailsDTO patientDetailsDto_2 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_2.setStaffId(2L);
		patientDetailsDto_2.setFirstName("AAA");
		
		
		List<PatientDetailsDTO> patientDetailList = new ArrayList<PatientDetailsDTO>();
		patientDetailList.add(patientDetailsDto_1);
		patientDetailList.add(patientDetailsDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(patientDetailsDto_1,"patientDetailsDto_1");
		
		 when(patientDetailsService.retrieveAllPatients()).thenReturn(patientDetailList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(patientDetailsDto_1, loginUser);
		
		patientdetailsWebService.validatePatientData(patientDetailsDto_1, errors);
		
	}
	
	@Test
	public void modifyPatientDetailsWhenLastNameIsEqualTest() throws Exception{
		
		final PatientDetailsDTO patientDetailsDto_1 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_1.setStaffId(1L);
		patientDetailsDto_1.setFirstName("AAA");
		patientDetailsDto_1.setLastName("BBB");
		
		final PatientDetailsDTO patientDetailsDto_2 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_2.setStaffId(2L);
		patientDetailsDto_2.setFirstName("AAA");
		patientDetailsDto_2.setLastName("BBB");
		
		List<PatientDetailsDTO> patientDetailList = new ArrayList<PatientDetailsDTO>();
		patientDetailList.add(patientDetailsDto_1);
		patientDetailList.add(patientDetailsDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(patientDetailsDto_1,"patientDetailsDto_1");
		
		 when(patientDetailsService.retrieveAllPatients()).thenReturn(patientDetailList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(patientDetailsDto_1, loginUser);
		
		patientdetailsWebService.validatePatientData(patientDetailsDto_1, errors);
		
	}
	
	@Test
	public void modifyPatientDetailsWhenDobIsEqualTest() throws Exception{
		
		final PatientDetailsDTO patientDetailsDto_1 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_1.setStaffId(1L);
		patientDetailsDto_1.setFirstName("AAA");
		patientDetailsDto_1.setLastName("BBB");
		patientDetailsDto_1.setDob(new Date());
		final PatientDetailsDTO patientDetailsDto_2 = podam.manufacturePojo(PatientDetailsDTO.class);
		patientDetailsDto_2.setStaffId(2L);
		patientDetailsDto_2.setFirstName("AAA");
		patientDetailsDto_2.setLastName("BBB");
		patientDetailsDto_2.setDob(new Date());
		
		List<PatientDetailsDTO> patientDetailList = new ArrayList<PatientDetailsDTO>();
		patientDetailList.add(patientDetailsDto_1);
		patientDetailList.add(patientDetailsDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(patientDetailsDto_1,"patientDetailsDto_1");
		
		 when(patientDetailsService.retrieveAllPatients()).thenReturn(patientDetailList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(patientDetailsDto_1, loginUser);
		
		patientdetailsWebService.validatePatientData(patientDetailsDto_1, errors);
		
	}
	
}

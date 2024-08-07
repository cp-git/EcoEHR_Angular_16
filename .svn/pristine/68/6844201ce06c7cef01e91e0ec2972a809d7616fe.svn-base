package com.cpa.ehr.web.rest.admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class MasterLookupWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Master Lookup Web service. */
	@InjectMocks
	protected MasterLookupWebService lookupWebService;

	/** The Encounter Location service. */
	@Mock
	private MasterLookupService lookupService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(lookupWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	@Test
	public void getListOfMasterLookupTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllMasterLookup(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfMasterLookup")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfAddressStatesTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllAddressStates(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfAddressStates")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfPatientStatusTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllPatientStatus(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfPatientStatus")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfCredentialsTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllCredentials(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfCredentials")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	public void getListOfFrequencyTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllFrequency(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfFrequency")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	
	@Test
	public void getRouteTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllRoute(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getRoute")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void deleteMasterLookupByIdTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
			doNothing().when(lookupService).deleteMasterLookupById(1L);
		
		mockMvc.perform(
				delete("/api/rest/admin/removeMasterLookup?lookupId=1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent());
		// Check whether the service is actually called
		verify(lookupService, times(1)).deleteMasterLookupById(1L);
	}
	
	@Test
	public void getListOfMasterLookupByRefillTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retriveAllMasterLookupByRefill(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfMasterLookupByRefillType")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfMasterLookupByDiscontinuedReasonTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retriveAllMasterLookupByDISCONTINUEDREASON(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfMasterLookupByDiscontinuesReason")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfProviderTypesTest() throws Exception{
		final MasterLookupDTO masterlookup = podam.manufacturePojo(MasterLookupDTO.class);
		masterlookup.setActiveFlag(true);
		masterlookup.setOrganizationId(1L);
		
		List<MasterLookupDTO> masterlookuplist = ImmutableList.of(masterlookup);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllProviderTypes(1L)).thenReturn(masterlookuplist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfProviderTypes")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfMasterLookupTypeTest() throws Exception{
		final String str = "AAAAA";
		
		
		List<String> typeListResp = ImmutableList.of(str);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(lookupService.retrieveAllMasterLookupType(1L)).thenReturn(typeListResp);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfMasterLookupType")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
}

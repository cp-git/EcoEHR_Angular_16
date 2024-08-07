package com.cpa.ehr.web.rest.admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
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
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.StaffDetailsService;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class StaffDetailsWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected StaffDetailsWebService staffdetailsWebService;

	/** The Encounter Location service. */
	@Mock
	private StaffDetailsService staffDetailsService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(staffdetailsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	@Test
	public void getActiveStaffMemberByIdTest() throws Exception {
		
		final StaffDetailsDTO staffdetail = podam.manufacturePojo(StaffDetailsDTO.class);
		when(staffDetailsService.retrieveStaffDetailsById(1L)).thenReturn(staffdetail);
		
		mockMvc.perform(get("/api/rest/admin/getActiveStaffMemberFromView?staffId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getCCMProvidersTest() throws Exception {
		
		final StaffDetailsDTO staffdetail = podam.manufacturePojo(StaffDetailsDTO.class);
		staffdetail.setActiveFlag(true);
		staffdetail.setOrganizationId(1L);
		
		List<StaffDetailsDTO> staffdetaillist = ImmutableList.of(staffdetail);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(staffDetailsService.retrieveAllCCMProviders(1L)).thenReturn(staffdetaillist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getCCMProviders")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getListOfActiveStaffMembersTest() throws Exception {
		
		final StaffDetailsDTO staffdetail = podam.manufacturePojo(StaffDetailsDTO.class);
		staffdetail.setActiveFlag(true);
		staffdetail.setOrganizationId(1L);
		
		List<StaffDetailsDTO> staffdetaillist = ImmutableList.of(staffdetail);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(staffDetailsService.retrieveAllStaffMembers(1L)).thenReturn(staffdetaillist);
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/getListOfActiveStaffMembersfromsView")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
}

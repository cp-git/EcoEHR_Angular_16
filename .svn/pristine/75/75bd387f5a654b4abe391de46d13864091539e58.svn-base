package com.cpa.ehr.web.rest.admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class ProfileWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The ProfileWebService. */
	@InjectMocks
	protected ProfileWebService profileWebService;

	/** The Encounter Location service. */
	@Mock
	private StaffRolesService staffRolesService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(profileWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	
	@Test
	public void getProfileTest() throws Exception{
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		mockMvc.perform(get("/api/rest/admin/profile")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
	}
	
//	@Test
//	public void isAdminTest() throws Exception{
//		
//		final StaffRolesDTO staffroles = podam.manufacturePojo(StaffRolesDTO.class);
//		staffroles.setActiveFlag(true);
//		staffroles.setStaffId(1L);
//		
//		when(staffRolesService.staffRolesService(1L)).thenReturn(staffroles);
//	}

}

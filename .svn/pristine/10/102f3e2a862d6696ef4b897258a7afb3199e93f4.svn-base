package com.cpa.ehr.web.rest.admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;
import com.cpa.ehr.util.FormatConverterUtils;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class StaffRolesWebServiceTest {
	
	protected MockMvc mockMvc;
	
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected StaffRolesWebService staffrolesWebService;
	
	@Mock
	private StaffRolesService staffrolesService;
	
	@Mock
	private EHRBaseService ehrBaseService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);					//initialize annotation

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(staffrolesWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	@Test
	public void createStaffRolesTest() throws Exception {
		
		final StaffRolesDTO staffrolesDto1 = podam.manufacturePojo(StaffRolesDTO.class);
		final StaffRolesDTO staffrolesDto2 = podam.manufacturePojo(StaffRolesDTO.class);
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		when(ehrBaseService.currentUser()).thenReturn(staff);
		FormatConverterUtils.setInitialDefaultValues(staffrolesDto1, staff);
		when(staffrolesService.persistStaffRoles(staffrolesDto1)).thenReturn(staffrolesDto2);
		
		final BindingResult errors=new BeanPropertyBindingResult(staffrolesDto1,"staffmemberDto_1");
		 
		mockMvc.perform(post("/api/rest/admin/createStaffRoles")
				.contentType(MediaType.APPLICATION_JSON)
				.content(FormatConverterUtils.convertObjectToJson(staffrolesDto1)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void modifyStaffRolesByIdTest() throws Exception {
		
		final StaffRolesDTO staffrolesDto1 = podam.manufacturePojo(StaffRolesDTO.class);
		final StaffRolesDTO staffrolesDto2 = podam.manufacturePojo(StaffRolesDTO.class);
		final StaffMemberDTO staffMember = podam.manufacturePojo(StaffMemberDTO.class);
		staffMember.setLoginId("CCM_ADMIN");
		
		StaffMember staff = podam.manufacturePojo(StaffMember.class);
		staff.setLoginId("ccmuser");
		when(ehrBaseService.currentUser()).thenReturn(staff);
		
		FormatConverterUtils.setInitialDefaultValues(staffrolesDto1, staff);
		when(staffrolesService.updateStaffRolesById(staffrolesDto1)).thenReturn(staffrolesDto2);
		
		//Perform the MVC call and compare the results
				mockMvc.perform(put("/api/rest/admin/modifyStaffRolesById?staffrolesDto1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(FormatConverterUtils.convertObjectToJson(staffrolesDto1)))
						.andExpect(status().isOk());
	}

}

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

import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.MasterLookupService;
import com.cpa.ehr.service.admin.OrganizationService;
import com.cpa.ehr.service.admin.dto.MasterLookupDTO;
import com.cpa.ehr.service.admin.dto.OrganizationDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class OrganizationWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Master Lookup Web service. */
	@InjectMocks
	protected OrganizationWebService organizationWebService;

	/** The Encounter Location service. */
	@Mock
	private OrganizationService orgService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(organizationWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	@Test
	public void getListOfActiveOrganizationsTest() throws Exception {
		
		final OrganizationDTO organization = podam.manufacturePojo(OrganizationDTO.class);
		organization.setActiveFlag(true);
		organization.setOrganizationId(1L);
		
		List<OrganizationDTO> organizationlist = ImmutableList.of(organization);
		when(orgService.retrieveAllActiveOrganizations()).thenReturn(organizationlist);
		
		mockMvc.perform(get("/api/rest/admin/getListOfActiveOrganizations")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}

}

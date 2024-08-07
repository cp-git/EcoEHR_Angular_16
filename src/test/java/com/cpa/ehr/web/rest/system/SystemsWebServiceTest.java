package com.cpa.ehr.web.rest.system;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.system.SystemsService;
import com.cpa.ehr.service.system.dto.SystemsDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class SystemsWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected SystemsWebService systemsWebService;

	/** The Systems Service. */
	@Mock
	private SystemsService systemsService;
	
	@Mock
	private EHRBaseService ehrBaseService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(systemsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	
	@Test
	public void getListOfSystemsTest() throws Exception {
		final SystemsDTO system = podam.manufacturePojo(SystemsDTO.class);
		List<SystemsDTO> systemlist = ImmutableList.of(system);
		
		when(systemsService.retrieveAllSystems()).thenReturn(systemlist);
		
		mockMvc.perform(get("/api/rest/system/getListOfSystems")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfSystemsTestException() throws Exception {
		
		final SystemsDTO system = podam.manufacturePojo(SystemsDTO.class);
		List<SystemsDTO> systemlist = ImmutableList.of(system);
		
		when(systemsService.retrieveAllSystems()).thenThrow(new RuntimeException());
		
		mockMvc.perform(get("/api/rest/system/getListOfSystems")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
	}
}

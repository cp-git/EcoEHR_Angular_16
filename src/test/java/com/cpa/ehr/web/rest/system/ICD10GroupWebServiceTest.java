package com.cpa.ehr.web.rest.system;

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

import com.cpa.ehr.service.system.EncounterService;
import com.cpa.ehr.service.system.ICD10GroupService;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
import com.cpa.ehr.service.system.dto.SystemsDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ICD10GroupWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected ICD10GroupWebService iCD10GroupWebService;

	
	@Mock
	private ICD10GroupService iCD10GroupService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(iCD10GroupWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	
	@Test
	public void getListOfICD10GroupTest() throws Exception {
		final ICD10GroupDTO icdGroup = podam.manufacturePojo(ICD10GroupDTO.class);
		List<ICD10GroupDTO> icdGrouplist = ImmutableList.of(icdGroup);
		
		when(iCD10GroupService.retrieveAllICD10Groups()).thenReturn(icdGrouplist);
		
		mockMvc.perform(get("/api/rest/icd10Groups/getAllICD10Groups")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfICD10GroupExceptionTest() throws Exception {
		final ICD10GroupDTO icdGroup = podam.manufacturePojo(ICD10GroupDTO.class);
		List<ICD10GroupDTO> icdGrouplist = ImmutableList.of(icdGroup);
		
		when(iCD10GroupService.retrieveAllICD10Groups()).thenThrow(new RuntimeException());
		
		mockMvc.perform(get("/api/rest/icd10Groups/getAllICD10Groups")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
}

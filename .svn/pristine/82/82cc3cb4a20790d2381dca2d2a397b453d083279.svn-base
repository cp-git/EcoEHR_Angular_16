package com.cpa.ehr.web.rest.system;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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

import com.cpa.ehr.service.system.ChiefCompliantDetailsService;
import com.cpa.ehr.service.system.EncounterService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EncounterWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected EncounterWebService encounterWebService;

	
	@Mock
	private EncounterService encounterService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(encounterWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	
	@Test
	public void getAllEncounterByPatientIdTest() throws Exception {
		//Create Mock object with PODAM Factory
		final EncounterDTO encResp = podam.manufacturePojo(EncounterDTO.class);
		List<EncounterDTO> encResplist = ImmutableList.of(encResp);
		when(encounterService.retrieveAllEncounterByPatientId(1L)).thenReturn(encResplist);
		
		mockMvc.perform(get("/api/rest/encounter/getAllEncounterByPatientId?patientId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	
		
		//Check whether the service is actually called
		verify(encounterService, times(1)).retrieveAllEncounterByPatientId(1L);
		verifyNoMoreInteractions(encounterService);
	}
	
	@Test
	public void getEncounterByEncounterIdTest() throws Exception {
		//Create Mock object with PODAM Factory
		final EncounterDTO encResp = podam.manufacturePojo(EncounterDTO.class);
		
		when(encounterService.retrieveEncounterByEncounterId(1L)).thenReturn(encResp);
		
		mockMvc.perform(get("/api/rest/encounter/getEncounterByEncounterId?encounterId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	
		
		//Check whether the service is actually called
		verify(encounterService, times(1)).retrieveEncounterByEncounterId(1L);
		verifyNoMoreInteractions(encounterService);
	}
	
}

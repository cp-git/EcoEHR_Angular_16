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

import com.cpa.ehr.service.system.EncounterHistoryService;
import com.cpa.ehr.service.system.ICD10GroupService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EncounterHistoryWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected EncounterHistoryWebService encounterHistoryWebService;

	
	@Mock
	private EncounterHistoryService encounterHistoryService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(encounterHistoryWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	
	@Test
	public void getAllEncounterByEncounterIdTest() throws Exception {
		//Create Mock object with PODAM Factory
		final EncounterHistoryRecordDTO enc = podam.manufacturePojo(EncounterHistoryRecordDTO.class);
		List<EncounterHistoryRecordDTO> encList = ImmutableList.of(enc);
		when(encounterHistoryService.retrieveAllEncounterByEncounterId(2L)).thenReturn(encList);
		
		mockMvc.perform(get("/api/rest/encounterHistory/getAllEncounterByEncounterId?encounterId=2")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	
		
		//Check whether the service is actually called
		verify(encounterHistoryService, times(1)).retrieveAllEncounterByEncounterId(2L);
		verifyNoMoreInteractions(encounterHistoryService);
	}
	
}

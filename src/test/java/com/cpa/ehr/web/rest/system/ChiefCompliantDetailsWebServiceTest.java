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
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ChiefCompliantDetailsWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected ChiefCompliantDetailsWebService chiefCompliantDetailsWebService;

	
	@Mock
	private ChiefCompliantDetailsService chiefCompliantDetailsService;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(chiefCompliantDetailsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	
	@Test
	public void getAllChiefCompliantByEncounterIdTest() throws Exception {
		//Create Mock object with PODAM Factory
		final ChiefCompliantDetailsDTO compliantResp = podam.manufacturePojo(ChiefCompliantDetailsDTO.class);
		List<ChiefCompliantDetailsDTO> compliantResplist = ImmutableList.of(compliantResp);
		when(chiefCompliantDetailsService.retrieveAllChiefCompliantByEncounterId(2L)).thenReturn(compliantResplist);
		
		mockMvc.perform(get("/api/rest/chiefCompliantDtls/getAllChiefCompliantByEncounterId?encounterId=2")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	
		
		//Check whether the service is actually called
		verify(chiefCompliantDetailsService, times(1)).retrieveAllChiefCompliantByEncounterId(2L);
		verifyNoMoreInteractions(chiefCompliantDetailsService);
	}
	
	
}

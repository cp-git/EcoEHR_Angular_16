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

import com.cpa.ehr.service.system.ICD10GroupService;
import com.cpa.ehr.service.system.QuestionsService;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
import com.cpa.ehr.service.system.dto.QuestionRecordDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class QuestionsWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected QuestionsWebService questionsWebService;

	
	@Mock
	private QuestionsService questionsService;	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(questionsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	@Test
	public void getListOfAllQuestionsBySystemIdTest() throws Exception {
		//Create Mock object with PODAM Factory
		final QuestionRecordDTO questionResp = podam.manufacturePojo(QuestionRecordDTO.class);
		List<QuestionRecordDTO> quesResplist = ImmutableList.of(questionResp);
		when(questionsService.retrieveAllQuestionsBySystemId(1L)).thenReturn(quesResplist);
		
		mockMvc.perform(get("/api/rest/questions/getListOfAllQuestionsBySystemId?systemId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	
		
		//Check whether the service is actually called
		verify(questionsService, times(1)).retrieveAllQuestionsBySystemId(1L);
		verifyNoMoreInteractions(questionsService);
	}
}

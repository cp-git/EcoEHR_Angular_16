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

import com.cpa.ehr.service.system.QuestionGroupService;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;
import com.cpa.ehr.service.system.dto.QuestionGroupDTO;
import com.google.common.collect.ImmutableList;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class QuestionGroupWebServiceTest {
	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected QuestionGroupWebService questionGroupWebService;

	
	@Mock
	private QuestionGroupService questionGroupService;	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(questionGroupWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
	}
	@Test
	public void getListOfQuestionsTest() throws Exception {
		final QuestionGroupDTO group = podam.manufacturePojo(QuestionGroupDTO.class);
		List<QuestionGroupDTO> grouplist = ImmutableList.of(group);
		
		when(questionGroupService.retrieveAllQuestionGroups()).thenReturn(grouplist);
		
		mockMvc.perform(get("/api/rest/questionGroups/getAllQuestionGroups")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListOfQuestionsExceptionTest() throws Exception {
		final QuestionGroupDTO group = podam.manufacturePojo(QuestionGroupDTO.class);
		List<QuestionGroupDTO> grouplist = ImmutableList.of(group);
		
		when(questionGroupService.retrieveAllQuestionGroups()).thenThrow(new RuntimeException());
		
		mockMvc.perform(get("/api/rest/questionGroups/getAllQuestionGroups")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
	}
}

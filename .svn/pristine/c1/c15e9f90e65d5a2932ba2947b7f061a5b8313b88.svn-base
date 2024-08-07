package com.cpa.ehr.web.rest.admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffDetailsService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import com.google.common.collect.ImmutableList;

import akka.util.Collections;
import scala.collection.mutable.MutableList;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class StaffMemberWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();
	
	@InjectMocks
	protected StaffMemberWebService staffmemberWebService;

	/** The Encounter Location service. */
	@Mock
	private StaffMemberService staffMemberService;
	
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

		this.mockMvc = MockMvcBuilders.standaloneSetup(staffmemberWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();

	}
	
	
	@Test
	public void getListOfActiveStaffMembersTest() throws Exception {
		
		final StaffMemberDTO staffmember = podam.manufacturePojo(StaffMemberDTO.class);
		List<StaffMemberDTO> staffmemberlist = ImmutableList.of(staffmember);
		
		when(staffMemberService.retrieveAllStaffMembers()).thenReturn(staffmemberlist);
		
		mockMvc.perform(get("/api/rest/admin/getListOfActiveStaffMembers")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
	}

	@Test
	public void getAllPrimaryProviderTest() throws Exception {
		
		final StaffMemberDTO staffmember = podam.manufacturePojo(StaffMemberDTO.class);
		List<StaffMemberDTO> staffmemberlist = ImmutableList.of(staffmember);
		
		when(staffMemberService.retrieveAllPrimaryProvider()).thenReturn(staffmemberlist);
		
		mockMvc.perform(get("/api/rest/admin/getAllPrimaryProvider")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	public void getActiveStaffMemberByIdTest() throws Exception {
		
		final StaffMemberDTO staffmember = podam.manufacturePojo(StaffMemberDTO.class);
		
		when(staffMemberService.retrieveStaffMemberById(1L)).thenReturn(staffmember);
		
		mockMvc.perform(get("/api/rest/admin/getStaffMemberById?staffId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	public void removeStaffMemberByIdTest() throws Exception {
				
		when(staffMemberService.checkStaffMemberInUse(1L)).thenReturn(true);
		when(staffMemberService.removeStaffMemberById(1L)).thenReturn(1L);
		doNothing().when(staffRolesService).removeStaffRolesById(1L);

		// Perform the MVC call and compare the results
		mockMvc.perform(
				delete("/api/rest/admin/removeStaffMemberById?staffId=1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent());
		verify(staffMemberService, times(1)).removeStaffMemberById(1L);

		
	}
	
	@Test
	public void removeStaffMemberByIdTestFail() throws Exception {
				
		when(staffMemberService.checkStaffMemberInUse(1L)).thenReturn(false);
		//when(staffMemberService.removeStaffMemberById(1L)).thenReturn(1L);
		doNothing().when(staffRolesService).removeStaffRolesById(1L);

		// Perform the MVC call and compare the results
		mockMvc.perform(
				delete("/api/rest/admin/removeStaffMemberById?staffId=1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isPreconditionRequired());
		verify(staffRolesService, times(0)).removeStaffRolesById(1L);

		
	}
	
	
	@Test
	public void modifyStaffMemberByIdTest() throws Exception{
		
		
		final StaffMemberDTO staffmemberDto = podam.manufacturePojo(StaffMemberDTO.class);
		
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
		
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(staffmemberDto, loginUser);
		
	
		
		mockMvc.perform(
				put("/api/rest/admin/modifyStaffMemberById?staffmemberDto").contentType(MediaType.APPLICATION_JSON)
				.content(FormatConverterUtils.convertObjectToJson(staffmemberDto)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void modifyStaffMemberByIdTestWhenStaffIdIsEqual() throws Exception{
		
		final StaffMemberDTO staffmemberDto_1 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_1.setStaffId(1L);
		
		final StaffMemberDTO staffmemberDto_2 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_2.setStaffId(2L);
		
		List<StaffMemberDTO> staffDTOList = new ArrayList<StaffMemberDTO>();
		staffDTOList.add(staffmemberDto_1);
		staffDTOList.add(staffmemberDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(staffmemberDto_1,"staffmemberDto_1");
		
		 when(staffMemberService.retrieveAllStaffMembers()).thenReturn(staffDTOList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(staffmemberDto_1, loginUser);
		
		staffmemberWebService.validateStaffMember(staffmemberDto_1, errors);
		
	}
	
	@Test
	public void modifyStaffMemberByIdTestWhenLoginIdIsEqual() throws Exception{
		
		final StaffMemberDTO staffmemberDto_1 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_1.setStaffId(1L);
		staffmemberDto_1.setLoginId("AAA");
		
		final StaffMemberDTO staffmemberDto_2 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_2.setStaffId(2L);
		staffmemberDto_2.setLoginId("AAA");
		
		List<StaffMemberDTO> staffDTOList = new ArrayList<StaffMemberDTO>();
		staffDTOList.add(staffmemberDto_1);
		staffDTOList.add(staffmemberDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(staffmemberDto_1,"staffmemberDto_1");
		
		 when(staffMemberService.retrieveAllStaffMembers()).thenReturn(staffDTOList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(staffmemberDto_1, loginUser);
		
		staffmemberWebService.validateStaffMember(staffmemberDto_1, errors);
		
	}
		
	@Test
	public void modifyStaffMemberByIdTestWhenEmailIdIsEqual() throws Exception{
		
		final StaffMemberDTO staffmemberDto_1 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_1.setStaffId(1L);
		staffmemberDto_1.setEmail("aaa");
		
		final StaffMemberDTO staffmemberDto_2 = podam.manufacturePojo(StaffMemberDTO.class);
		staffmemberDto_2.setStaffId(2L);
		staffmemberDto_2.setEmail("aaa");
		List<StaffMemberDTO> staffDTOList = new ArrayList<StaffMemberDTO>();
		staffDTOList.add(staffmemberDto_1);
		staffDTOList.add(staffmemberDto_2);
		
		
		 final BindingResult errors=new BeanPropertyBindingResult(staffmemberDto_1,"staffmemberDto_1");
		
		 when(staffMemberService.retrieveAllStaffMembers()).thenReturn(staffDTOList);
		 
		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
			
		when( ehrBaseService.currentUser()).thenReturn(loginUser);
		FormatConverterUtils.setInitialDefaultValues(staffmemberDto_1, loginUser);
		
		staffmemberWebService.validateStaffMember(staffmemberDto_1, errors);
		
	}
	
//	@Test
//	public void insertStaffMemberTest() throws Exception{
//		
//		final StaffMemberDTO staffmemberDto_1 = podam.manufacturePojo(StaffMemberDTO.class);
//		staffmemberDto_1.setStaffId(1L);
//		staffmemberDto_1.setEmail("aaa");
//		
//		final StaffMemberDTO staffmemberDto_2 = podam.manufacturePojo(StaffMemberDTO.class);
//		staffmemberDto_2.setStaffId(2L);
//		staffmemberDto_2.setEmail("aaa");
//		List<StaffMemberDTO> staffDTOList = new ArrayList<StaffMemberDTO>();
//		staffDTOList.add(staffmemberDto_1);
//		staffDTOList.add(staffmemberDto_2);
//		
//		
//		 final BindingResult errors=new BeanPropertyBindingResult(staffmemberDto_1,"staffmemberDto_1");
//		
//		 when(staffMemberService.retrieveAllStaffMembers()).thenReturn(staffDTOList);
//		 
//		StaffMember loginUser =podam.manufacturePojo(StaffMember.class);
//			
//		when( ehrBaseService.currentUser()).thenReturn(loginUser);
//		FormatConverterUtils.setInitialDefaultValues(staffmemberDto_1, loginUser);
//		
//		staffmemberWebService.validateStaffMember(staffmemberDto_1, errors);
//		
//	}
	
}

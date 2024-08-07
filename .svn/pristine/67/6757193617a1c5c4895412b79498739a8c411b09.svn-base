package com.cpa.ehr.web.rest.admin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.ClinicLocationService;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;
import com.google.common.collect.ImmutableList;

import cucumber.api.java.en.Then;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ClinicLocationsWebServiceTest {

	/** The mock mvc. */
	protected MockMvc mockMvc;

	/** The Podam Factory Object */
	protected PodamFactory podam = new PodamFactoryImpl();

	/** The Clinic Locations Web service. */
	@InjectMocks
	protected ClinicLocationsWebService clinicLocationsWebService;
	
	/** The Clinic Location service. */
	@Mock
	private ClinicLocationService clinicLocationService;
	@Mock
	private EHRBaseService ehrBaseService;	
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		final StaticApplicationContext applicationContext = new StaticApplicationContext();
		
		final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
		webMvcConfigurationSupport.setApplicationContext(applicationContext);

		this.mockMvc = MockMvcBuilders.standaloneSetup(clinicLocationsWebService)
				.setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver()).build();
		
	}
	
	@Test
	public void getActiveClinicLocationByIdTest() throws Exception {
		
		//Create Mock object with PODAM Factory
		final ClinicLocationDTO clinicLocResp = podam.manufacturePojo(ClinicLocationDTO.class);
			
		when(clinicLocationService.retrieveClinicLocationById(1L)).thenReturn(clinicLocResp);
		
		mockMvc.perform(get("/api/rest/admin/getClinicLocationById?locationId=1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.locationId", is(clinicLocResp.getLocationId())))
		.andExpect(jsonPath("$.locationName", is(clinicLocResp.getLocationName())))
		.andExpect(jsonPath("$.addressDoorNo", is(clinicLocResp.getAddressDoorNo())));
		
		//Check whether the service is actually called
		verify(clinicLocationService, times(1)).retrieveClinicLocationById(1L);
		verifyNoMoreInteractions(clinicLocationService);
		
		
	}

	@Test
	public void getListOfActiveClinicLocationsSuccessTest() throws Exception {
		
		StaffMember clinicloc = podam.manufacturePojo(StaffMember.class);
		when(ehrBaseService.currentUser()).thenReturn(clinicloc);
		
		final ClinicLocationDTO clinicloc1 = podam.manufacturePojo(ClinicLocationDTO.class);
		clinicloc1.setActiveFlag(true);
		clinicloc1.setOrganizationId(1L);
		clinicloc1.setAddressStreet("AAAA");
		clinicloc1.setAddressState("MH");
				

		List<ClinicLocationDTO> clinicloclist = ImmutableList.of(clinicloc1);
		
		when(clinicLocationService.retrieveAllClinicLocations(1L)).thenReturn(clinicloclist);
		
		mockMvc.perform(get("/api/rest/admin/getListOfClinicLocations")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());
		
		verify(clinicLocationService, times(1)).retrieveAllClinicLocations(1L);
		verifyNoMoreInteractions(clinicLocationService);
		
		
	}

	@Test
	public void removeClinicLocationByIdSuccessTest() throws Exception {
		
		final ClinicLocationDTO clinicLoc = podam.manufacturePojo(ClinicLocationDTO.class);
		clinicLoc.setActiveFlag(true);
		clinicLoc.setLocationId(1L);

		when(clinicLocationService.checkClinicLocationInUse(1L)).thenReturn(true);
	//	when(clinicLocationService.removeClinicLocationById(1L)).thenReturn(1L);
		doNothing().when(clinicLocationService).removeClinicLocationById(1L);

		// Perform the MVC call and compare the results
		mockMvc.perform(
				delete("/api/rest/admin/removeClinicLocationById?locationId=1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent());
		// Check whether the service is actually called
		verify(clinicLocationService, times(1)).removeClinicLocationById(1L);

	
	}
	
	@Test
	public void removeClinicLocationByIdFailTest() throws Exception {
		
		final ClinicLocationDTO clinicLoc = podam.manufacturePojo(ClinicLocationDTO.class);
		clinicLoc.setActiveFlag(true);
		clinicLoc.setLocationId(1L);

		when(clinicLocationService.checkClinicLocationInUse(1L)).thenReturn(false);
		//when(clinicLocationService.removeClinicLocationById(1L)).thenReturn(1L);
		doNothing().when(clinicLocationService).removeClinicLocationById(1L);

		// Perform the MVC call and compare the results
		mockMvc.perform(
				delete("/api/rest/admin/removeClinicLocationById?locationId=1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isPreconditionRequired());
		// Check whether the service is actually called
		verify(clinicLocationService, times(0)).removeClinicLocationById(1L);

	
	}
	
	@Test
	public void validateClinicLocationSuccessTest() throws Exception {

		final ClinicLocationDTO clinicloc1 = podam.manufacturePojo(ClinicLocationDTO.class);
		clinicloc1.setActiveFlag(true);
		clinicloc1.setOrganizationId(1L);
		clinicloc1.setAddressStreet("AAAA");
		clinicloc1.setAddressState("MH");
				

		List<ClinicLocationDTO> clinicloclist = ImmutableList.of(clinicloc1);

		final ClinicLocationDTO clinicloc2 = podam.manufacturePojo(ClinicLocationDTO.class);
		clinicloc2.setActiveFlag(true);
		clinicloc2.setOrganizationId(2L);
		clinicloc1.setAddressStreet("BBBB");
		clinicloc1.setAddressState("MP");
		

		StaffMember clinicloc = podam.manufacturePojo(StaffMember.class);
		// staff.setLoginId("ccmuser");

		when(ehrBaseService.currentUser()).thenReturn(clinicloc);
		when(clinicLocationService.retrieveAllClinicLocations(1L)).thenReturn(clinicloclist);
	
		
	}
}

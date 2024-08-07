package com.cpa.ehr.service.admin;

import java.util.List;

import com.cpa.ehr.service.admin.dto.MasterLookupDTO;


public interface MasterLookupService {

	List<String> retrieveAllMasterLookupType(Long organizationId);

	List<MasterLookupDTO> retrieveAllMasterLookup(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllAddressStates(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllPatientStatus(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllCredentials(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllProviderTypes(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllSpecialisationForStud();
	
	List<MasterLookupDTO> retrieveAllFrequency(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllRoute(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllTitle(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllRace(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllEthnicity(Long organizationId);
	
	List<MasterLookupDTO> retrieveAllLanguage(Long organizationId);
	
	List<MasterLookupDTO> retriveAllMasterLookupByRefill(Long organizationId);
	
	List<MasterLookupDTO> retriveAllMasterLookupByDISCONTINUEDREASON(Long organizationId);
	
	MasterLookupDTO persistMasterLookup(MasterLookupDTO masterLookupDTO);

	void deleteMasterLookupById(Long lookupId);
	
}


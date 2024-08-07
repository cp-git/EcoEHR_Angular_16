package com.cpa.ehr.service.preventivecare;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cpa.ehr.service.preventivecare.dto.MasterPreventiveCareDTO;

import java.util.List;


public interface MasterPreventiveCareService {


//MasterPreventiveCareDTO persistMasterPreventiveCare(MasterPreventiveCareDTO masterPreventiveCareDTOpersist) ;
//
//
//  MasterPreventiveCareDTO retrieveMasterPreventiveCareById(Long preventiveCareId);


	List<MasterPreventiveCareDTO> retrieveAllMasterPreventiveCare(long pid);


	//MasterPreventiveCareDTO modifyMasterPreventiveCare(MasterPreventiveCareDTO masterPreventiveCareDTOUpdate) ;

	
	}

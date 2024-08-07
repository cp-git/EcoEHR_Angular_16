package com.cpa.ehr.service.system;

import java.util.List;
import com.cpa.ehr.service.system.dto.SystemsDTO;

public interface SystemsService {

	List<SystemsDTO> retrieveAllSystems();
	
	SystemsDTO getSystemCodeDetails(String sysCode);

}
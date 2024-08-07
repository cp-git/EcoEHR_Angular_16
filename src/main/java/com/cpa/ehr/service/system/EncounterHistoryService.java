package com.cpa.ehr.service.system;

import java.util.List;

import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;

public interface EncounterHistoryService {

	List<EncounterHistoryRecordDTO> retrieveAllEncounterByEncounterId(Long encounterId);
	
	List<EncounterHistoryDTO> retrieveEncounterListByEncounterId(Long encounterId);
	
	

}

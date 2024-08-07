package com.cpa.ehr.service.system;

import java.util.Date;
import java.util.List;
import com.cpa.ehr.service.system.dto.EncounterDTO;

public interface EncounterService {

	EncounterDTO persistEncounter(EncounterDTO encounterDTO);

	List<EncounterDTO> retrieveAllEncounterByPatientId(Long patientId);
	
	List<EncounterDTO> retrieveAllEncounterByPatientIdForStud(Long staffId, Date lastLoginDate);

	EncounterDTO retrieveEncounterByEncounterId(Long encounterId);

	EncounterDTO modifyEncounter(Long encounterId,Long templateId, String examName,String isEdited);

	EncounterDTO modifyCompletedEncounter(EncounterDTO encounterDTO);

	EncounterDTO modifyEncounterByEncId(EncounterDTO encounterDTO);
	
	public void removeEncounterByEncId(Long encounterId);
	
}

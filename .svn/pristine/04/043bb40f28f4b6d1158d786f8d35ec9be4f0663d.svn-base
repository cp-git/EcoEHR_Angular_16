package com.cpa.ehr.service.system;

import java.util.List;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.EncounterDTO;

public interface ChiefCompliantDetailsService {
	
	public void deleteCompliantById(Long chiefCompliantDtlId);

	ChiefCompliantDetailsDTO persistChiefCompliantDetails(ChiefCompliantDetailsDTO chiefCompliantDetailsDTO);

	List<ChiefCompliantDetailsDTO> retrieveAllChiefCompliantByEncounterId(Long encounterId);

	List<ChiefCompliantDetailsDTO> retrieveIcd10DetailsOfLastFiveEncounters(Long patientId);

	ChiefCompliantDetailsDTO retrieveCompliantByEncIdAndCode(String icd10Code,Long encounterId);

	ChiefCompliantDetailsDTO updateChiefCompliantDetails(ChiefCompliantDetailsDTO recordToUpdate,ChiefCompliantDetailsDTO chiefCompliantDetailsDTO);
}

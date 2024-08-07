package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.backend.dao.system.entities.EncounterHistory;
import com.cpa.ehr.service.system.dto.EncounterDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;

@Mapper(componentModel = "spring")
public abstract class EncounterHistoryMapper {
	
	public abstract EncounterHistoryDTO entityToEncounterHistoryDTO(EncounterHistory entity);
	
	public abstract EncounterHistory encounterHistoryDTOToEntity(EncounterHistoryDTO dto);
	

	public abstract List<EncounterHistoryDTO> entityListToEncounterHistoryDTOList(List<EncounterHistory> entities);
}

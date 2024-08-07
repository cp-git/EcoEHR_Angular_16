package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.cpa.ehr.backend.dao.system.entities.EncounterHistoryRecord;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;


@Mapper(componentModel = "spring")
public interface EncounterHistoryRecordMapper {
	
	public abstract EncounterHistoryRecordDTO entityToEncounterHistoryRecordDTO(EncounterHistoryRecord entity);
	
	public abstract EncounterHistoryRecord encounterHistoryRecordDTOToEntity(EncounterHistoryRecordDTO dto);
	
	public abstract List<EncounterHistoryRecordDTO> entityListToEncounterHistoryRecordDTOList(List<EncounterHistoryRecord> entities);
}

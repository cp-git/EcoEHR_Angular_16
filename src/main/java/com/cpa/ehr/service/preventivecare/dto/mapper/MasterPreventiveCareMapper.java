package com.cpa.ehr.service.preventivecare.dto.mapper;

import java.util.List;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.ehr.backend.dao.preventivecare.entities.MasterPreventiveCare;
import com.cpa.ehr.service.preventivecare.dto.MasterPreventiveCareDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class MasterPreventiveCareMapper {

	// This will build a fresh new MasterPreventiveCareDTO with in infos
		
public abstract  MasterPreventiveCareDTO convertEntityToMasterPreventiveCareDTO(MasterPreventiveCare entity);
	
public abstract  MasterPreventiveCare  convertMasterPreventiveCareDTOToEntity( MasterPreventiveCareDTO dto);



public abstract List<MasterPreventiveCareDTO>  entityListToMasterPreventiveCareDTOList(List<MasterPreventiveCare> list);
}

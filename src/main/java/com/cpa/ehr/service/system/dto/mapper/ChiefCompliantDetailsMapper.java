package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.cpa.ehr.backend.dao.system.EncounterRepository;
import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class ChiefCompliantDetailsMapper {

	@Autowired
	public EncounterRepository encRepo;

	@Mapping(target = "primaryFlag", expression = "java(FormatConverterUtils.convertPrimaryFlagtoBoolean(entity.getPrimaryFlag()))")
	@Mapping(target = "encounterId", expression = "java(entity.getEncounter().getEncounterId())")
	public abstract ChiefCompliantDetailsDTO entityToChiefCompliantDetailsDTO(ChiefCompliantDetails entity);

	@Mapping(target = "primaryFlag", expression = "java(FormatConverterUtils.convertBooleantoPrimaryFlag(dto.getPrimaryFlag()))")
	@Mapping(target = "encounter", expression = "java(encRepo.findOne(dto.getEncounterId()))")
	public abstract ChiefCompliantDetails chiefCompliantDetailsDTOToEntity(ChiefCompliantDetailsDTO dto);

	public abstract List<ChiefCompliantDetailsDTO> entityListToCompliantDetailsDTOList(List<ChiefCompliantDetails> entities);

}

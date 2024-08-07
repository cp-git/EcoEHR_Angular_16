

package com.cpa.ehr.service.system.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cpa.ehr.backend.dao.system.entities.ICD10Group;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;


@Mapper(componentModel = "spring")
public interface ICD10GroupMapper {
	
	public abstract ICD10GroupDTO entityToICD10Group(ICD10Group entity);
	/**
	 * Maps List of ICD10Group Entities to DTOs
	 * 
	 * @param entities
	 * 		List of ICD10Group entities
	 * @return 
	 * 		List of ICD10Group DTOs
	 */
	public abstract List<ICD10GroupDTO> entityListToICD10GroupDTOList(List<ICD10Group> entities);

}

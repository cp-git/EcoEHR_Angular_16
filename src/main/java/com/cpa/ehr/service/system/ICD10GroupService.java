package com.cpa.ehr.service.system;

import java.util.List;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;


public interface ICD10GroupService {

	List<ICD10GroupDTO> retrieveAllICD10Groups();

}
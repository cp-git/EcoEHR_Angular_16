


package com.cpa.ehr.service.students.dto.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;


/**
 * Mapper for the entity PatientDetails and its DTO called PatientDetails DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class StudentValidationMapper 
{
	
	public abstract StudentDetailsDTO entityToStudentValidationDTO(StudentDetails entity);


	


}






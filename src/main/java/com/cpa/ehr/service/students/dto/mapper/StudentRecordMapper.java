package com.cpa.ehr.service.students.dto.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.cpa.ehr.backend.dao.students.entities.StudentRecord;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})

public abstract class StudentRecordMapper 
{


	
	public abstract StudentRecordDTO entityToStudentRecordDTO(StudentRecord entity);

	
	public abstract StudentRecord studentRecordDTOToEntity(StudentRecordDTO dto);
	
	public abstract List<StudentRecordDTO> entityListToStudentRecordDTOList(List<StudentRecord> entities);


}






	









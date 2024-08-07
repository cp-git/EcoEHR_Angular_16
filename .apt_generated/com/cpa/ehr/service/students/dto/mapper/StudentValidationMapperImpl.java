package com.cpa.ehr.service.students.dto.mapper;

import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T01:39:11+0530",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.13.50.v20171007-0855, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class StudentValidationMapperImpl extends StudentValidationMapper {

    @Override
    public StudentDetailsDTO entityToStudentValidationDTO(StudentDetails entity) {
        if ( entity == null ) {
            return null;
        }

        StudentDetailsDTO studentDetailsDTO = new StudentDetailsDTO();

        studentDetailsDTO.setStuId( entity.getStuId() );
        studentDetailsDTO.setUserName( entity.getUserName() );
        studentDetailsDTO.setPassword( entity.getPassword() );
        studentDetailsDTO.setFirstName( entity.getFirstName() );
        studentDetailsDTO.setLastName( entity.getLastName() );

        return studentDetailsDTO;
    }
}

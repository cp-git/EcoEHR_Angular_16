package com.cpa.ehr.service.students.dto.mapper;

import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T12:37:53+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class StudentDetailsMapperImpl extends StudentDetailsMapper {

    @Override
    public StudentDetailsDTO entityToStudentDetailsDTO(StudentDetails entity) {
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

    @Override
    public StudentDetails studentDetailsDTOToEntity(StudentDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StudentDetails studentDetails = new StudentDetails();

        studentDetails.setStuId( dto.getStuId() );
        studentDetails.setUserName( dto.getUserName() );
        studentDetails.setPassword( dto.getPassword() );
        studentDetails.setFirstName( dto.getFirstName() );
        studentDetails.setLastName( dto.getLastName() );

        return studentDetails;
    }

    @Override
    public List<StudentDetailsDTO> entityListToStudentDetailsDTOList(List<StudentDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StudentDetailsDTO> list = new ArrayList<StudentDetailsDTO>();
        for ( StudentDetails studentDetails : entities ) {
            list.add( entityToStudentDetailsDTO( studentDetails ) );
        }

        return list;
    }
}

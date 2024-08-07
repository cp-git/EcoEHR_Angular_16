package com.cpa.ehr.service.students.dto.mapper;

import com.cpa.ehr.backend.dao.students.entities.StudentRecord;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T01:39:11+0530",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.13.50.v20171007-0855, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class StudentRecordMapperImpl extends StudentRecordMapper {

    @Override
    public StudentRecordDTO entityToStudentRecordDTO(StudentRecord entity) {
        if ( entity == null ) {
            return null;
        }

        StudentRecordDTO studentRecordDTO = new StudentRecordDTO();

        studentRecordDTO.setStuId( entity.getStuId() );
        studentRecordDTO.setUserName( entity.getUserName() );
        studentRecordDTO.setPassword( entity.getPassword() );
        studentRecordDTO.setFirstName( entity.getFirstName() );
        studentRecordDTO.setLastName( entity.getLastName() );

        return studentRecordDTO;
    }

    @Override
    public StudentRecord studentRecordDTOToEntity(StudentRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StudentRecord studentRecord = new StudentRecord();

        studentRecord.setStuId( dto.getStuId() );
        studentRecord.setUserName( dto.getUserName() );
        studentRecord.setPassword( dto.getPassword() );
        studentRecord.setFirstName( dto.getFirstName() );
        studentRecord.setLastName( dto.getLastName() );

        return studentRecord;
    }

    @Override
    public List<StudentRecordDTO> entityListToStudentRecordDTOList(List<StudentRecord> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StudentRecordDTO> list = new ArrayList<StudentRecordDTO>();
        for ( StudentRecord studentRecord : entities ) {
            list.add( entityToStudentRecordDTO( studentRecord ) );
        }

        return list;
    }
}

package com.cpa.ehr.service.students.impl;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.students.entities.StudentDetails;
import com.cpa.ehr.backend.dao.students.entities.StudentRecord;
import com.cpa.ehr.backend.dao.students.StudentDetailsRepository;
import com.cpa.ehr.backend.dao.students.StudentRecordRepository;
import com.cpa.ehr.service.students.StudentDetailsService;
import com.cpa.ehr.service.students.dto.StudentDetailsDTO;
import com.cpa.ehr.service.students.dto.StudentRecordDTO;
import com.cpa.ehr.service.students.dto.mapper.StudentDetailsMapper;
import com.cpa.ehr.service.students.dto.mapper.StudentRecordMapper;
import com.google.gson.Gson;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService
{
	private static final Logger LOG = LoggerFactory.getLogger(StudentDetailsServiceImpl.class);

	@Autowired
	private StudentDetailsRepository studentDetailsRepo;
	
	@Autowired
	private StudentRecordRepository studentRecordRepo;
	
	@Autowired
	private StudentDetailsMapper studentDetailsMapper;
	
	@Autowired
	private StudentRecordMapper studentRecordMapper;
	

	@Override
	public StudentDetailsDTO persistStudentDetails(StudentDetailsDTO studentDetailsDTO){
		try {
			if(studentDetailsDTO != null) {
				StudentDetails studentToInsert = studentDetailsMapper.studentDetailsDTOToEntity(studentDetailsDTO);
				StudentDetails insertedStudent = studentDetailsRepo.save(studentToInsert);
				StudentDetailsDTO insertedStudentDTO = studentDetailsMapper.entityToStudentDetailsDTO(insertedStudent);
				this.modifyStudentDetails(insertedStudentDTO);
				return (insertedStudent != null) ? studentDetailsMapper.entityToStudentDetailsDTO(insertedStudent) : null;
			}
		}
		catch (Exception e){
			LOG.error("Error while inserting student details {} ", e);
		}
		return null;
	}

	@Override
	public List<StudentDetailsDTO> retrieveAllStudents() {
		try {
			List<StudentDetails> student = studentDetailsRepo.findAllStudents();
			return (student != null) ? studentDetailsMapper.entityListToStudentDetailsDTOList(student) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all students {} ", e);
		}
		return Collections.emptyList();
		
	}
	

	@Override
	public StudentRecordDTO retrieveStudentRecordStudentId(Long stuId){
		try {
			StudentRecord student1 = studentRecordRepo.findStudentRecordByStudentId(stuId);
			return (studentRecordMapper != null) ? studentRecordMapper.entityToStudentRecordDTO(student1) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all encounters location by stuId {} ", e);
		}
		return null;
	}

	
	@Override
	public StudentDetailsDTO retrieveStudentDetailsStudentId(Long stuId){
		try {
			StudentDetails student1 = studentDetailsRepo.findStudentDetailsByStudentId(stuId);
			return (studentDetailsMapper != null) ? studentDetailsMapper.entityToStudentDetailsDTO(student1) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all encounters location by stuID {} ", e);
		}
		return null;
	}
	
	@Override
	public StudentDetailsDTO modifyStudentDetails(StudentDetailsDTO studentDetailsDTO) {
		try {
			StudentDetails studentDetailsToUpdate = studentDetailsRepo.findOne(studentDetailsDTO.getStuId());
			
			if ( studentDetailsToUpdate != null) {
				studentDetailsToUpdate.setStuId(studentDetailsDTO.getStuId());
				studentDetailsToUpdate.setUserName(studentDetailsDTO.getUserName());
				studentDetailsToUpdate.setPassword(studentDetailsDTO.getPassword());
				studentDetailsToUpdate.setFirstName(studentDetailsDTO.getFirstName());
				studentDetailsToUpdate.setLastName(studentDetailsDTO.getLastName());
//				studentDetailsToUpdate.setCreatedDate(studentDetailsDTO.getCreatedDate());
//				
//				studentDetailsToUpdate.setCreatedBy(studentDetailsDTO.getCreatedBy());
//				studentDetailsToUpdate.setLastUpdatedDate(studentDetailsDTO.getLastUpdatedDate());
//
//				studentDetailsToUpdate.setLastUpdatedBy(studentDetailsDTO.getLastUpdatedBy());
				StudentDetails updatedStudentDetails = studentDetailsRepo.save(studentDetailsToUpdate);
				return (updatedStudentDetails != null) ? studentDetailsMapper.entityToStudentDetailsDTO(updatedStudentDetails) : null;
			}
		}
		 catch (Exception e){
			 LOG.error("Error while updating student details {} ", e);
		 }
		return null;
	}	
	
	@Override
	public List<StudentRecordDTO> retrieveAllActiveStudents() {
		List<StudentRecord> studentList = studentRecordRepo.findAllActiveStudentsfromView();
		System.out.println("studentList"+studentList);
		return (studentList != null) ? studentRecordMapper.entityListToStudentRecordDTOList(studentList) : null;
	}
}





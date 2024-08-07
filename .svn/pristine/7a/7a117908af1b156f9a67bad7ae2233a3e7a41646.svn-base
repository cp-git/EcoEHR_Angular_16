package com.cpa.ehr.backend.dao.patients;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.patients.constants.PatientConsultantNotesConstant;
import com.cpa.ehr.backend.dao.patients.constants.PatientLabResultsConstant;
import com.cpa.ehr.backend.dao.patients.entities.ConsultantNotes;
import com.cpa.ehr.backend.dao.patients.entities.LabResults;

@Transactional
@Repository
public interface ConsultantNotesRepository  extends JpaRepository<ConsultantNotes, Long> {
	
	@Query(value = PatientConsultantNotesConstant.FIND_BY_PATIENTID, nativeQuery = true)
	List<ConsultantNotes> findPatientConsultantNotesByPatientId(@Param("patientId") Long patientId);
}
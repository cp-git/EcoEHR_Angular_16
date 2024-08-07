package com.cpa.ehr.backend.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpa.ehr.backend.dao.system.constants.PatientMedicationRecordConstants;
import com.cpa.ehr.backend.dao.system.entities.PatientMedicationRecord;
import com.cpa.ehr.service.system.dto.PatientMedicationRecordDTO;

public interface PatientMedicationRecordRepository extends JpaRepository<PatientMedicationRecord, Long>
{
	@Query(value= PatientMedicationRecordConstants.SELECTPMRQUERY,nativeQuery=true)
	List<PatientMedicationRecord> patientmedicationRecordList(@Param("patientId") long patientId);
	
}

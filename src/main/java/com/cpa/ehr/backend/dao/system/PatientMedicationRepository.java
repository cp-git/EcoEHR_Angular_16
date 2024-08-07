package com.cpa.ehr.backend.dao.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.PatientMedicationConstants;
import com.cpa.ehr.backend.dao.system.constants.PatientMedicationRecordConstants;
import com.cpa.ehr.backend.dao.system.entities.PatientMedication;

@Repository
@Transactional
public interface PatientMedicationRepository extends JpaRepository<PatientMedication, Long> {
	
	@Query(value= PatientMedicationConstants.SELECTPMBYENCID,nativeQuery=true)
	List<PatientMedication> patientmedicationlist(@Param("encounterId") long encounterId);
	
	@Query(value= PatientMedicationConstants.SELECTACTIVEPMBYENCID,nativeQuery=true)
	List<PatientMedication> findActiveMedications(@Param("encounterId") long encounterId);
	
	@Query(value= PatientMedicationConstants.SELECTINACTIVEPMBYENCID,nativeQuery=true)
	List<PatientMedication> findinActiveMedications(@Param("encounterId") long encounterId);
}

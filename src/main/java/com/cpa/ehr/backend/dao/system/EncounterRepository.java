package com.cpa.ehr.backend.dao.system;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.EncounterConstants;
import com.cpa.ehr.backend.dao.system.entities.Encounter;

@Repository
@Transactional
public interface EncounterRepository extends JpaRepository<Encounter, Long> {
	
	@Query(value = EncounterConstants.FIND_ALL_BY_PATIENT_ID, nativeQuery = true)
	List<Encounter> findAllEncounterByPatientId(@Param("patientId")Long patientId);

	@Query(value = EncounterConstants.FIND_ALL_BY_PATIENT_ID_STUD, nativeQuery = true)
	List<Encounter> findAllEncounterByPatientIdForStud(@Param("staffId")Long staffId, @Param("lastLoginDate") Date lastLoginDate);
}

package com.cpa.ehr.backend.dao.system;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.ChiefCompliantDetailsConstants;
import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;

@Repository
@Transactional
public interface ChiefCompliantDetailsRepository extends JpaRepository<ChiefCompliantDetails, Long> {
	
	@Query(value = ChiefCompliantDetailsConstants.FIND_ALL_BY_ENCOUNTER_ID, nativeQuery = true)
	List<ChiefCompliantDetails> findAllChiefCompliantByEncounterId(@Param("encounterId")Long encounterId);
	
	@Query(value = ChiefCompliantDetailsConstants.FIND_ICD10_DETAILS, nativeQuery = true)
	List<ChiefCompliantDetails> findIcd10DetailsOfLastFiveEncounters(@Param("patientId")Long patientId);
	
	@Query(value = ChiefCompliantDetailsConstants.FIND_ICD_10, nativeQuery = true)
	ChiefCompliantDetails findCompliantByEncIdAndCode(@Param("icd10Code")String icd10Code,@Param("encounterId")Long encounterId);
}

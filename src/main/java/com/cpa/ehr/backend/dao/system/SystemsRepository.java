package com.cpa.ehr.backend.dao.system;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.patients.constants.PatientRecordConstants;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.backend.dao.system.constants.SystemsConstant;
import com.cpa.ehr.backend.dao.system.entities.Systems;

@Repository
@Transactional
public interface SystemsRepository extends JpaRepository<Systems, Long> {

	@Query(value = SystemsConstant.FIND_REFERENCE_LINK, nativeQuery = true)
	Systems findReferenceLinksForSys(@Param("sysCode") String sysCode);
}

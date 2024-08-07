package com.cpa.ehr.backend.dao.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.ICD10GroupConstants;
import com.cpa.ehr.backend.dao.system.entities.ICD10Group;


@Repository
@Transactional
public interface ICD10GroupRepository extends JpaRepository<ICD10Group, Long> {
	
	@Query(value = ICD10GroupConstants.FIND_ALL, nativeQuery = true)
	List<ICD10Group> findAllIcdGroup();

}

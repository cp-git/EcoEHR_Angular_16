package com.cpa.ehr.backend.dao.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.QuestionConstants;
import com.cpa.ehr.backend.dao.system.constants.QuestionGroupConstants;
import com.cpa.ehr.backend.dao.system.entities.QuestionGroup;


@Repository
@Transactional
public interface QuestionGroupRepository extends JpaRepository<QuestionGroup, Long> {

	@Query(value = QuestionGroupConstants.FIND_ALL_COMMON_QUESTION_GROUP, nativeQuery = true)
	List<QuestionGroup> findAllQuestionsGroups();
}

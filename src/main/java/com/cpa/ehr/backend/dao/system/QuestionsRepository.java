package com.cpa.ehr.backend.dao.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.QuestionConstants;
import com.cpa.ehr.backend.dao.system.entities.Questions;

@Repository
@Transactional
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

	@Query(value = QuestionConstants.FIND_ALL_COMMON_QUESTIONS, nativeQuery = true)
	List<Object> findAllQuestionsBySystemId(@Param("systemId") Long systemId);
	
	
	@Query(value = QuestionConstants.FIND_ALL_COMMON_QUESTIONS_FAMILY, nativeQuery = true)
	List<Object> findAllQuestionsForFamilyHistory(@Param("systemId") Long systemId);

}

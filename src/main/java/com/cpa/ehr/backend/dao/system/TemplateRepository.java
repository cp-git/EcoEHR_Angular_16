package com.cpa.ehr.backend.dao.system;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cpa.ehr.backend.dao.system.constants.TemplateConstants;
import com.cpa.ehr.backend.dao.system.entities.Template;

@Repository
@Transactional
public interface TemplateRepository extends JpaRepository<Template, Long>  {
	
	@Query(value = TemplateConstants.FIND_ALL_BY_SYSTEM_ID, nativeQuery = true)
	Template findAllTemplatesBySystemId(@Param("systemId")Long systemId);
	
	@Query(value = TemplateConstants.FIND_ALL_BY_ACTIVE_FLAG, nativeQuery = true)
	List<Template> findAllActiveTemplates();
	
	@Query(value = TemplateConstants.FIND_ALL_BY_ENC_ID, nativeQuery = true)
	List<Template> findTemplatesById(@Param("phyId")Long phyId,@Param("neuroId")Long neuroId,@Param("cardioId")Long cardioId
			,@Param("eyeId")Long eyeId,@Param("detailedId")Long detailedId);

}

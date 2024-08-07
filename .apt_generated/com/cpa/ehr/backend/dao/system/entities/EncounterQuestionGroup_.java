package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EncounterQuestionGroup.class)
public abstract class EncounterQuestionGroup_ {

	public static volatile SingularAttribute<EncounterQuestionGroup, String> questionGroupAnswer;
	public static volatile SingularAttribute<EncounterQuestionGroup, String> lastUpdatedBy;
	public static volatile SingularAttribute<EncounterQuestionGroup, Long> systemId;
	public static volatile SingularAttribute<EncounterQuestionGroup, Date> lastUpdatedDate;
	public static volatile SingularAttribute<EncounterQuestionGroup, Date> createdDate;
	public static volatile SingularAttribute<EncounterQuestionGroup, String> createdBy;
	public static volatile SingularAttribute<EncounterQuestionGroup, Long> encQuestionGroupId;
	public static volatile SingularAttribute<EncounterQuestionGroup, Encounter> encounter;
	public static volatile SingularAttribute<EncounterQuestionGroup, Long> questionGroupId;

}


package com.cpa.ehr.backend.dao.system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EncounterHistory.class)
public abstract class EncounterHistory_ {

	public static volatile SingularAttribute<EncounterHistory, String> questionDesc;
	public static volatile SingularAttribute<EncounterHistory, Long> systemId;
	public static volatile SingularAttribute<EncounterHistory, Long> systemOrder;
	public static volatile SingularAttribute<EncounterHistory, String> questionDispType;
	public static volatile SingularAttribute<EncounterHistory, Long> questionId;
	public static volatile SingularAttribute<EncounterHistory, Long> encQuestionOptionId;
	public static volatile SingularAttribute<EncounterHistory, String> optionValue;
	public static volatile SingularAttribute<EncounterHistory, String> systemDesc;
	public static volatile SingularAttribute<EncounterHistory, Long> encounterId;
	public static volatile SingularAttribute<EncounterHistory, Long> questionGroupId;
	public static volatile SingularAttribute<EncounterHistory, String> questionGroupName;
	public static volatile SingularAttribute<EncounterHistory, String> answer;
	public static volatile SingularAttribute<EncounterHistory, String> systemCode;
	public static volatile SingularAttribute<EncounterHistory, String> systemType;
	public static volatile SingularAttribute<EncounterHistory, Long> questionGroupOrder;
	public static volatile SingularAttribute<EncounterHistory, Long> optionId;
	public static volatile SingularAttribute<EncounterHistory, Long> questionOrder;
	public static volatile SingularAttribute<EncounterHistory, String> questionType;

}


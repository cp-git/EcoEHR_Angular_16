package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EncQuestionOption.class)
public abstract class EncQuestionOption_ {

	public static volatile SingularAttribute<EncQuestionOption, String> lastUpdatedBy;
	public static volatile SingularAttribute<EncQuestionOption, Long> systemId;
	public static volatile SingularAttribute<EncQuestionOption, Long> questionId;
	public static volatile SingularAttribute<EncQuestionOption, Long> encQuestionOptionId;
	public static volatile SingularAttribute<EncQuestionOption, String> answerComments;
	public static volatile SingularAttribute<EncQuestionOption, String> optionValue;
	public static volatile SingularAttribute<EncQuestionOption, Encounter> encounter;
	public static volatile SingularAttribute<EncQuestionOption, Long> questionGroupId;
	public static volatile SingularAttribute<EncQuestionOption, Date> lastUpdatedDate;
	public static volatile SingularAttribute<EncQuestionOption, Date> createdDate;
	public static volatile SingularAttribute<EncQuestionOption, String> answer;
	public static volatile SingularAttribute<EncQuestionOption, String> createdBy;
	public static volatile SingularAttribute<EncQuestionOption, Long> optionId;

}


package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuestionGroup.class)
public abstract class QuestionGroup_ {

	public static volatile SingularAttribute<QuestionGroup, Long> questionCount;
	public static volatile SingularAttribute<QuestionGroup, String> lastUpdatedBy;
	public static volatile SingularAttribute<QuestionGroup, Long> systemId;
	public static volatile SingularAttribute<QuestionGroup, String> questionGroupName;
	public static volatile SingularAttribute<QuestionGroup, Date> lastUpdatedDate;
	public static volatile SingularAttribute<QuestionGroup, Date> createdDate;
	public static volatile SingularAttribute<QuestionGroup, String> createdBy;
	public static volatile SingularAttribute<QuestionGroup, Long> questionGroupOrder;
	public static volatile SingularAttribute<QuestionGroup, Long> questionGroupId;
	public static volatile SingularAttribute<QuestionGroup, Character> activeFlag;

}


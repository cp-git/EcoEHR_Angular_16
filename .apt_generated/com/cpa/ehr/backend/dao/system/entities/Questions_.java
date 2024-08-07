package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Questions.class)
public abstract class Questions_ {

	public static volatile SingularAttribute<Questions, String> questionDesc;
	public static volatile SingularAttribute<Questions, String> lastUpdatedBy;
	public static volatile SingularAttribute<Questions, Long> systemId;
	public static volatile SingularAttribute<Questions, String> questionDispType;
	public static volatile SingularAttribute<Questions, Long> questionId;
	public static volatile SingularAttribute<Questions, Long> questionGroupId;
	public static volatile SingularAttribute<Questions, Character> mandatoryFlag;
	public static volatile SingularAttribute<Questions, Long> optionsCount;
	public static volatile SingularAttribute<Questions, Date> lastUpdatedDate;
	public static volatile SingularAttribute<Questions, Date> createdDate;
	public static volatile SingularAttribute<Questions, String> createdBy;
	public static volatile SingularAttribute<Questions, Long> questionOrder;
	public static volatile SingularAttribute<Questions, String> questionType;
	public static volatile SingularAttribute<Questions, Character> activeFlag;

}


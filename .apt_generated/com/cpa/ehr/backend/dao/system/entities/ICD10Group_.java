package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICD10Group.class)
public abstract class ICD10Group_ {

	public static volatile SingularAttribute<ICD10Group, String> lastUpdatedBy;
	public static volatile SingularAttribute<ICD10Group, Date> lastUpdatedDate;
	public static volatile SingularAttribute<ICD10Group, Date> createdDate;
	public static volatile SingularAttribute<ICD10Group, String> groupDescription;
	public static volatile SingularAttribute<ICD10Group, String> createdBy;
	public static volatile SingularAttribute<ICD10Group, Long> groupId;
	public static volatile SingularAttribute<ICD10Group, Long> count;
	public static volatile SingularAttribute<ICD10Group, String> groupRange;

}


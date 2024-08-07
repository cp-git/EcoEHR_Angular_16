package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Systems.class)
public abstract class Systems_ {

	public static volatile SingularAttribute<Systems, String> lastUpdatedBy;
	public static volatile SingularAttribute<Systems, Long> systemId;
	public static volatile SingularAttribute<Systems, Integer> systemOrder;
	public static volatile SingularAttribute<Systems, Date> lastUpdatedDate;
	public static volatile SingularAttribute<Systems, Date> createdDate;
	public static volatile SingularAttribute<Systems, String> systemCode;
	public static volatile SingularAttribute<Systems, Integer> questionGroupCount;
	public static volatile SingularAttribute<Systems, String> createdBy;
	public static volatile SingularAttribute<Systems, String> systemType;
	public static volatile SingularAttribute<Systems, String> systemDesc;
	public static volatile SingularAttribute<Systems, String> externalLinks;
	public static volatile SingularAttribute<Systems, Character> activeFlag;

}


package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterLookup.class)
public abstract class MasterLookup_ {

	public static volatile SingularAttribute<MasterLookup, String> lookupCode;
	public static volatile SingularAttribute<MasterLookup, String> lastUpdatedBy;
	public static volatile SingularAttribute<MasterLookup, Long> lookupId;
	public static volatile SingularAttribute<MasterLookup, Date> lastUpdatedDate;
	public static volatile SingularAttribute<MasterLookup, Date> createdDate;
	public static volatile SingularAttribute<MasterLookup, String> createdBy;
	public static volatile SingularAttribute<MasterLookup, Organization> organization;
	public static volatile SingularAttribute<MasterLookup, String> lookupType;
	public static volatile SingularAttribute<MasterLookup, String> lookupDesc;
	public static volatile SingularAttribute<MasterLookup, String> activeFlag;

}


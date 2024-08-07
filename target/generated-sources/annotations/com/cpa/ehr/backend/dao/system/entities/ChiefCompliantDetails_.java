package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiefCompliantDetails.class)
public abstract class ChiefCompliantDetails_ {

	public static volatile SingularAttribute<ChiefCompliantDetails, String> icd10Code;
	public static volatile SingularAttribute<ChiefCompliantDetails, String> lastUpdatedBy;
	public static volatile SingularAttribute<ChiefCompliantDetails, Date> lastUpdatedDate;
	public static volatile SingularAttribute<ChiefCompliantDetails, Date> createdDate;
	public static volatile SingularAttribute<ChiefCompliantDetails, String> createdBy;
	public static volatile SingularAttribute<ChiefCompliantDetails, Encounter> encounter;
	public static volatile SingularAttribute<ChiefCompliantDetails, Long> chiefCompliantDtlId;
	public static volatile SingularAttribute<ChiefCompliantDetails, String> primaryFlag;
	public static volatile SingularAttribute<ChiefCompliantDetails, String> icd10CodeDescription;

}


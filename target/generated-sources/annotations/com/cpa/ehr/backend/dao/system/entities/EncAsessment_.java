package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EncAsessment.class)
public abstract class EncAsessment_ {

	public static volatile SingularAttribute<EncAsessment, String> icd10Code;
	public static volatile SingularAttribute<EncAsessment, String> lastUpdatedBy;
	public static volatile SingularAttribute<EncAsessment, Date> lastUpdatedDate;
	public static volatile SingularAttribute<EncAsessment, Date> createdDate;
	public static volatile SingularAttribute<EncAsessment, Long> encAsessmentId;
	public static volatile SingularAttribute<EncAsessment, Long> patientId;
	public static volatile SingularAttribute<EncAsessment, String> createdBy;
	public static volatile SingularAttribute<EncAsessment, Long> encounterId;
	public static volatile SingularAttribute<EncAsessment, String> icd10CodeDescription;
	public static volatile SingularAttribute<EncAsessment, String> activeFlag;

}


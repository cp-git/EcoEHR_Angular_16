package com.cpa.ehr.backend.dao.patients.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabResults.class)
public abstract class LabResults_ {

	public static volatile SingularAttribute<LabResults, String> lastUpdatedBy;
	public static volatile SingularAttribute<LabResults, Date> lastUpdatedDate;
	public static volatile SingularAttribute<LabResults, Date> createdDate;
	public static volatile SingularAttribute<LabResults, Long> patientId;
	public static volatile SingularAttribute<LabResults, String> createdBy;
	public static volatile SingularAttribute<LabResults, Long> labId;
	public static volatile SingularAttribute<LabResults, Date> labDate;
	public static volatile SingularAttribute<LabResults, String> documentLink;
	public static volatile SingularAttribute<LabResults, String> resultsComments;
	public static volatile SingularAttribute<LabResults, String> activeFlag;

}


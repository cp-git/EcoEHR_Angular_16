package com.cpa.ehr.backend.dao.patients.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, String> icd10Code;
	public static volatile SingularAttribute<Orders, String> lastUpdatedBy;
	public static volatile SingularAttribute<Orders, String> imagingOrderComments;
	public static volatile SingularAttribute<Orders, String> followupOrderComments;
	public static volatile SingularAttribute<Orders, Date> consultingOrderDate;
	public static volatile SingularAttribute<Orders, Long> orderId;
	public static volatile SingularAttribute<Orders, Date> labOrderDate;
	public static volatile SingularAttribute<Orders, Long> patientId;
	public static volatile SingularAttribute<Orders, Date> imagingOrderDate;
	public static volatile SingularAttribute<Orders, String> labOrderComments;
	public static volatile SingularAttribute<Orders, Long> encounterId;
	public static volatile SingularAttribute<Orders, Date> lastUpdatedDate;
	public static volatile SingularAttribute<Orders, Date> createdDate;
	public static volatile SingularAttribute<Orders, String> createdBy;
	public static volatile SingularAttribute<Orders, String> consultingOrderComments;
	public static volatile SingularAttribute<Orders, Date> followupOrderDate;
	public static volatile SingularAttribute<Orders, String> activeFlag;

}


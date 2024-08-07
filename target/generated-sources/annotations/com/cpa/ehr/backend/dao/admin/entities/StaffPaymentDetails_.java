package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StaffPaymentDetails.class)
public abstract class StaffPaymentDetails_ {

	public static volatile SingularAttribute<StaffPaymentDetails, Date> licenseStartDate;
	public static volatile SingularAttribute<StaffPaymentDetails, StaffMember> staff;
	public static volatile SingularAttribute<StaffPaymentDetails, Date> licenseEndDate;
	public static volatile SingularAttribute<StaffPaymentDetails, Long> staffPaymentId;
	public static volatile SingularAttribute<StaffPaymentDetails, String> paymentStatus;

}


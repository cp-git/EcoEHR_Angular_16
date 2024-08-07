package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StaffRoles.class)
public abstract class StaffRoles_ {

	public static volatile SingularAttribute<StaffRoles, Long> staffRoleId;
	public static volatile SingularAttribute<StaffRoles, String> lastUpdatedBy;
	public static volatile SingularAttribute<StaffRoles, Date> lastUpdatedDate;
	public static volatile SingularAttribute<StaffRoles, Date> createdDate;
	public static volatile SingularAttribute<StaffRoles, String> createdBy;
	public static volatile SingularAttribute<StaffRoles, String> authority;
	public static volatile SingularAttribute<StaffRoles, StaffMember> staff;
	public static volatile SingularAttribute<StaffRoles, String> activeFlag;

}


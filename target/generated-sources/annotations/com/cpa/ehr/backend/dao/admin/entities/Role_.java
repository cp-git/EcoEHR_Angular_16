package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, Long> securityLevel;
	public static volatile SingularAttribute<Role, Date> createdDate;
	public static volatile SingularAttribute<Role, String> createdBy;
	public static volatile SingularAttribute<Role, Long> roleId;
	public static volatile SingularAttribute<Role, String> displayName;
	public static volatile SingularAttribute<Role, String> authority;
	public static volatile SingularAttribute<Role, Date> modifiedDate;
	public static volatile SingularAttribute<Role, String> description;
	public static volatile SingularAttribute<Role, String> modifiedBy;
	public static volatile SingularAttribute<Role, String> activeFlag;

}


package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PasswordResetToken.class)
public abstract class PasswordResetToken_ {

	public static volatile SingularAttribute<PasswordResetToken, Date> expiryDate;
	public static volatile SingularAttribute<PasswordResetToken, StaffMember> staffMember;
	public static volatile SingularAttribute<PasswordResetToken, Long> id;
	public static volatile SingularAttribute<PasswordResetToken, String> token;

}


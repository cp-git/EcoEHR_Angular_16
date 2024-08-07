package com.cpa.ehr.backend.dao.students.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentRecord.class)
public abstract class StudentRecord_ {

	public static volatile SingularAttribute<StudentRecord, String> firstName;
	public static volatile SingularAttribute<StudentRecord, String> lastName;
	public static volatile SingularAttribute<StudentRecord, String> password;
	public static volatile SingularAttribute<StudentRecord, Long> stuId;
	public static volatile SingularAttribute<StudentRecord, String> userName;

}


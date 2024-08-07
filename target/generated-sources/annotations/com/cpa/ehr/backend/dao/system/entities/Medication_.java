package com.cpa.ehr.backend.dao.system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medication.class)
public abstract class Medication_ {

	public static volatile SingularAttribute<Medication, String> schedule;
	public static volatile SingularAttribute<Medication, String> dose;
	public static volatile SingularAttribute<Medication, String> route;
	public static volatile SingularAttribute<Medication, Long> medicationId;
	public static volatile SingularAttribute<Medication, String> form;
	public static volatile SingularAttribute<Medication, String> drugname;
	public static volatile SingularAttribute<Medication, String> activeingredient;

}


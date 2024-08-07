package com.cpa.ehr.backend.dao.patients.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConsultantNotes.class)
public abstract class ConsultantNotes_ {

	public static volatile SingularAttribute<ConsultantNotes, String> lastUpdatedBy;
	public static volatile SingularAttribute<ConsultantNotes, String> consultantComments;
	public static volatile SingularAttribute<ConsultantNotes, Date> lastUpdatedDate;
	public static volatile SingularAttribute<ConsultantNotes, Date> createdDate;
	public static volatile SingularAttribute<ConsultantNotes, Long> consultantNotesId;
	public static volatile SingularAttribute<ConsultantNotes, Long> patientId;
	public static volatile SingularAttribute<ConsultantNotes, String> createdBy;
	public static volatile SingularAttribute<ConsultantNotes, String> documentLink;
	public static volatile SingularAttribute<ConsultantNotes, Date> consultantDate;
	public static volatile SingularAttribute<ConsultantNotes, String> activeFlag;

}


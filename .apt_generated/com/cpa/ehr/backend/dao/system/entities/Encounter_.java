package com.cpa.ehr.backend.dao.system.entities;

import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Encounter.class)
public abstract class Encounter_ {

	public static volatile SingularAttribute<Encounter, String> lastUpdatedBy;
	public static volatile SingularAttribute<Encounter, Long> patientId;
	public static volatile SingularAttribute<Encounter, Long> detailedExamTempId;
	public static volatile SingularAttribute<Encounter, Long> eyeExamTempId;
	public static volatile SingularAttribute<Encounter, Date> encounterDate;
	public static volatile SingularAttribute<Encounter, String> patientUniqueCharacters;
	public static volatile SingularAttribute<Encounter, Long> encounterId;
	public static volatile SingularAttribute<Encounter, Long> emId;
	public static volatile SingularAttribute<Encounter, ClinicLocation> clinicLocation;
	public static volatile SingularAttribute<Encounter, Date> lastUpdatedDate;
	public static volatile SingularAttribute<Encounter, Long> cardioExamTempId;
	public static volatile SingularAttribute<Encounter, Date> createdDate;
	public static volatile SingularAttribute<Encounter, String> createdBy;
	public static volatile SingularAttribute<Encounter, StaffMember> staffMember;
	public static volatile SingularAttribute<Encounter, Organization> organization;
	public static volatile SingularAttribute<Encounter, Long> simpleNeuroExamTempId;
	public static volatile SingularAttribute<Encounter, String> chiefCompliant;
	public static volatile SingularAttribute<Encounter, Date> completionDate;
	public static volatile SingularAttribute<Encounter, Long> physicalExamTempId;
	public static volatile SingularAttribute<Encounter, String> activeFlag;

}


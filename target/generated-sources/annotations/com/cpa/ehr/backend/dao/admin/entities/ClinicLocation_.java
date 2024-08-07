package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClinicLocation.class)
public abstract class ClinicLocation_ {

	public static volatile SingularAttribute<ClinicLocation, String> lastUpdatedBy;
	public static volatile SingularAttribute<ClinicLocation, String> addressDoorNo;
	public static volatile SingularAttribute<ClinicLocation, String> locationName;
	public static volatile SingularAttribute<ClinicLocation, String> addressZip;
	public static volatile SingularAttribute<ClinicLocation, String> contactEmail;
	public static volatile SingularAttribute<ClinicLocation, String> contactName;
	public static volatile SingularAttribute<ClinicLocation, String> addressState;
	public static volatile SingularAttribute<ClinicLocation, String> primaryNo;
	public static volatile SingularAttribute<ClinicLocation, Date> lastUpdatedDate;
	public static volatile SingularAttribute<ClinicLocation, Date> createdDate;
	public static volatile SingularAttribute<ClinicLocation, String> addressStreet;
	public static volatile SingularAttribute<ClinicLocation, String> faxNo;
	public static volatile SingularAttribute<ClinicLocation, String> einNumber;
	public static volatile SingularAttribute<ClinicLocation, String> buildingNo;
	public static volatile SingularAttribute<ClinicLocation, String> createdBy;
	public static volatile SingularAttribute<ClinicLocation, Long> locationId;
	public static volatile SingularAttribute<ClinicLocation, Organization> organization;
	public static volatile SingularAttribute<ClinicLocation, String> addressCity;
	public static volatile SingularAttribute<ClinicLocation, String> activeFlag;

}


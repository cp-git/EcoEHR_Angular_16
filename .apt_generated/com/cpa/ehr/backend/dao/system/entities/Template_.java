package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Template.class)
public abstract class Template_ {

	public static volatile SingularAttribute<Template, String> lastUpdatedBy;
	public static volatile SingularAttribute<Template, Long> systemId;
	public static volatile SingularAttribute<Template, Date> lastUpdatedDate;
	public static volatile SingularAttribute<Template, Date> createdDate;
	public static volatile SingularAttribute<Template, String> templateName;
	public static volatile SingularAttribute<Template, String> createdBy;
	public static volatile SingularAttribute<Template, byte[]> templateDesc;
	public static volatile SingularAttribute<Template, Long> templateId;
	public static volatile SingularAttribute<Template, Long> version;
	public static volatile SingularAttribute<Template, String> activeFlag;

}


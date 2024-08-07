package com.cpa.ehr.backend.dao.admin.constants;

public class MasterLookupConstants { 
	public static final String AND = " AND ";
	public static final String SELECT_BASE_BY_ORG_ID="SELECT * FROM master_lookup e WHERE e.active_flag = 'Y' AND e.organization_id = :organizationId";
	public static final String SELECT_BASE="SELECT * FROM master_lookup e WHERE e.active_flag = 'Y'";
	
	public static final String FIND_ALL_MASTER_LOOKUP_TYPE = "SELECT DISTINCT m.lookup_type FROM master_lookup m WHERE m.organization_id = :organizationId"
			+ " ORDER BY m.lookup_type";
	public static final String ORDER_BY_CLAUSE = " ORDER BY lookup_id";
	public static final String LOOKUP_TYPE_ADDRESS_STATES = "e.lookup_type = 'STATE'";
	public static final String LOOKUP_TYPE_PATIENT_STATUS = "e.lookup_type = 'PATIENT_STATUS'";
	public static final String LOOKUP_TYPE_CRDENTIALS = "e.lookup_type = 'STAFF_CREDENTAILS'";
	public static final String LOOKUP_TYPE_PROVIDER_TYPES ="e.lookup_type = 'PROVIDER_TYPE'";
	public static final String LOOKUP_TYPE_SPECIALIAZATION ="e.lookup_type = 'STUDENT_SPECIALIZATION'";
	public static final String LOOKUP_TYPE_FREQUENCY ="e.lookup_type = 'FREQUENCY'";
	public static final String LOOKUP_TYPE_ROUTE= "e.lookup_type = 'ROUTE'";
	public static final String FIND_ALL_MASTER_LOOKUP = SELECT_BASE_BY_ORG_ID + ORDER_BY_CLAUSE;
	public static final String FIND_ALL_ADDRESS_STATES = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_ADDRESS_STATES;
	public static final String FIND_ALL_PATIENT_STATUS = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_PATIENT_STATUS;
	
	public static final String FIND_ALL_CREDENTIALS = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_CRDENTIALS;
	public static final String FIND_ALL_PROVIDER_TYPES = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_PROVIDER_TYPES;
	public static final String FIND_ALL_SPECIALIAZATION_TYPES = SELECT_BASE +AND+LOOKUP_TYPE_SPECIALIAZATION;
	public static final String FIND_ALL_FREQUENCY = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_FREQUENCY;
	public static final String FIND_ALL_ROUTE = SELECT_BASE_BY_ORG_ID +AND+LOOKUP_TYPE_ROUTE;
	public static final String FIND_ALL_TITLE = "SELECT * FROM master_lookup e WHERE e.lookup_type='TITLE' AND e.organization_id=:organizationId";	
	public static final String FIND_ALL_LANGUAGE = "SELECT * FROM master_lookup e WHERE e.lookup_type='LANGUAGE' AND e.organization_id=:organizationId";
	public static final String FIND_ALL_RACE = "SELECT * FROM master_lookup e WHERE e.lookup_type='RACE' AND e.organization_id=:organizationId";
	public static final String FIND_ALL_ETHNICITY = "SELECT * FROM master_lookup e WHERE e.lookup_type='ETHNICITY' AND e.organization_id=:organizationId";
	
	public static final String FIND_ALL_MASTERLOOKUP_BY_REFILL	=" SELECT * FROM master_lookup e WHERE e.lookup_type='REFILL' AND e.organization_id=:organizationId";
	public static final String FIND_ALL_MASTERLOOKUP_BY_DISCONTINUED_REASON	=" SELECT * FROM master_lookup e WHERE e.lookup_type='DISCONTINUED_REASON' AND e.organization_id=:organizationId";
	
	private MasterLookupConstants() {
		
	}
}

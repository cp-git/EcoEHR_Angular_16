package com.cpa.ehr.backend.dao.admin.constants;

public class ClinicLocationConstants {
	
	public static final String SELECT_BASE_BY_ORG_ID="SELECT * FROM clinic_loc e WHERE e.active_flag = 'Y' AND e.organization_id = :organizationId";
	public static final String SELECT_BASE="SELECT * FROM clinic_loc e WHERE e.active_flag = 'Y' AND e.location_id = :locationId";
	public static final String ORDER_BY_CLAUSE = " ORDER BY loc_name";
	public static final String FIND_ALL_CLINIC_LOCATION = SELECT_BASE_BY_ORG_ID + ORDER_BY_CLAUSE;
	public static final String FIND_ORG_BY_ID = SELECT_BASE + ORDER_BY_CLAUSE; 
	
	private ClinicLocationConstants() {
		
	}
}

package com.cpa.ehr.backend.dao.admin.constants;

public class StaffDetailsConstants {
	public static final String AND = " AND ";
	public static final String AND1 = " AND s.designation!='TRY_ME'";
	
	 public static final String SELECT_CCM_PROVIDERS ="SELECT * FROM staff_vw s WHERE s.active_flag='Y' "+ "AND s.organization_id=:orgId "+"AND s.designation='MD' "+"AND s.provider_flag='Y' ORDER BY s.login_id";

	 public static final String STAFF_ID_COND = "s.staff_id = :staffId";
	 public static final String ORDER_BY_CLAUSE = " ORDER BY s.staff_id ASC";
	 public static final String SELECT_ALL ="SELECT s.organization_id, s.staff_id, s.login_id, s.login_key, s.first_name, s.middle_name, s.last_name, s.provider_flag, s.designation, s.last_login_dt,s.last_action_dt, s.last_action, s.last_client, s.mobile_no, s.business_phone_no,s.provider_type,s.email,s.staff_image, s.staff_role_id,  case when s.staffrole = 'ROLE_ADMIN' then 'Admin' else 'User' end AS staffrole, s.staff_address_id, s.location_id,s.loc_name, s.address_door_no, s.address_street, s.address_city, s.address_state, s.address_zip,s.active_flag, s.created_date, s.created_by, s.last_updated_date, s.last_updated_by,s.npi_number,s.license_state,s.license_number,s.license_exp_date,s.dea_number,s.dea_exp_date,s.mal_coverage,s.mal_expiration,s.dob,s.gender,s.ssn,s.ehr_license_end_date,s.ehr_license_start_date,s.payment_status FROM staff_vw s WHERE s.active_flag='Y' ";
	 public static final String SELECT_ALL_STAFF ="SELECT s.organization_id, s.staff_id, s.login_id, s.login_key, s.first_name, s.middle_name, s.last_name, s.provider_flag, s.designation, s.last_login_dt,s.last_action_dt, s.last_action, s.last_client, s.mobile_no, s.business_phone_no,s.provider_type,s.email,s.staff_image, s.staff_role_id,  case when s.staffrole = 'ROLE_ADMIN' then 'Admin' else 'User' end AS staffrole, s.staff_address_id, s.location_id,s.loc_name, s.address_door_no, s.address_street, s.address_city, s.address_state, s.address_zip,s.active_flag, s.created_date, s.created_by, s.last_updated_date, s.last_updated_by,s.npi_number,s.license_state,s.license_number,s.license_exp_date,s.dea_number,s.dea_exp_date,s.mal_coverage,s.mal_expiration,s.dob,s.gender,s.ssn,s.ehr_license_end_date,s.ehr_license_start_date,s.payment_status FROM staff_vw s WHERE s.active_flag='Y' AND s.designation!='TRY_ME' AND s.organization_id= :orgId ";
	 public static final String SELECT_ONE = SELECT_ALL + AND1 + AND + STAFF_ID_COND + ORDER_BY_CLAUSE; 
	 public static final String BY_CLINIC_LOC_ID = "s.staff_address_id = :staffAddressId";
	 public static final String FIND_ALL_STAFFS_BY_CLINIC_LOC_ID = SELECT_ALL + AND + BY_CLINIC_LOC_ID;
	 
	 public static final String SELECT_TRY_ME = "SELECT * FROM staff_vw s WHERE s.designation = 'TRY_ME' ORDER BY s.active_flag ASC";

	 private StaffDetailsConstants() {
		 
	 }

}

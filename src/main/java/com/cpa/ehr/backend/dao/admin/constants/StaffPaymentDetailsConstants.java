package com.cpa.ehr.backend.dao.admin.constants;

public class StaffPaymentDetailsConstants {

	public static final String SELECT_BASE = "SELECT * FROM staff_Payment_details e";
	public static final String SELECT_BASE_1 = "";
	public static final String FIND_PAYMENT_DETAILS = SELECT_BASE + " WHERE e.staff_id = :staffId";
	public static final String GET_PAYMENT_STATUS_BY_ID = SELECT_BASE + " WHERE e.staff_id = :staffId";
}

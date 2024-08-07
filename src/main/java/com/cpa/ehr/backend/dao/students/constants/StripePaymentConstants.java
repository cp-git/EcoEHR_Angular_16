package com.cpa.ehr.backend.dao.students.constants;

public class StripePaymentConstants {
	
	public static final String TEST_PUBLIC_KEY ="pk_test_51HNMPIFtve7dlO7OLKevFQqhe6XGw1p3SctaCFtHHldZ8zk6NIT6khjbr5tnRqz75foja4WnSB4qIP9GGVZyjDxU00MmVM1bOu";
	public static final String TEST_SECERT_KEY = "sk_test_51HNMPIFtve7dlO7OlOQKWdD7QiwyyJDFybO2BLOZ5xSJm76wHJhJbnJF4sWbbaoCLmsudpld1ocZVIqtGxUn9LIr00Pae7j7xY";
	public static final String TEST_PRICE_ID = "price_1I2bapFtve7dlO7OsbnfyMIW";
	
	
	public static final String PROD_PUBLIC_KEY ="pk_live_51HNMPIFtve7dlO7ObF2i6ykEPJmjd0GhTyQcm2y5jrKiJqOy8eeXAP1ClNhMQY2XDeOtOrRsixeY9g1Hdfk9ghy9002ofRSPqB";
	public static final String PROD_SECERT_KEY = "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";
	public static final String PROD_PRICE_ID = "price_1IIYTPFtve7dlO7OxrhbmbMT";
	
	/*
	 * public static final String LOCAL_URL = "http://localhost:4300"; 
	 * public static final String LOCAL_SUCCESS_URL = LOCAL_URL + "/#/success"; 
	 * public static final String LOCAL_FAILURE_URL = LOCAL_URL + "/cancel";
	 */
	
	public static final String LOCAL_URL = "http://34.195.111.53/ehr/";
	public static final String LOCAL_SUCCESS_URL = LOCAL_URL + "/#/success";
    public static final String LOCAL_FAILURE_URL = LOCAL_URL +  "/cancel";
	
	public StripePaymentConstants() {
		
	}
}

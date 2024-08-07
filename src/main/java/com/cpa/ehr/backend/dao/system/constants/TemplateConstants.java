package com.cpa.ehr.backend.dao.system.constants;

public class TemplateConstants {
	
	public static final String FIND_ALL = "Select * from template t";
	public static final String BY_SYSTEM_ID = "t.sys_id = :systemId";
	public static final String BY_SYSTEM_IDS = "t.template_id = :phyId OR t.template_id = :neuroId OR t.template_id = :cardioId OR t.template_id = :eyeId OR t.template_id = :detailedId";
	public static final String BY_ACTIVE_FLAG = "t.active_flag = 'Y'";
	public static final String FIND_ALL_BY_SYSTEM_ID = FIND_ALL +" WHERE " + BY_SYSTEM_ID + " AND " + BY_ACTIVE_FLAG;
	public static final String FIND_ALL_BY_ACTIVE_FLAG = FIND_ALL + " WHERE "+ BY_ACTIVE_FLAG;
	public static final String FIND_ALL_BY_ENC_ID = FIND_ALL + " WHERE "+BY_SYSTEM_IDS;
	
	private TemplateConstants() {
		
	}
}

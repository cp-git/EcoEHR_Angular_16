package com.cpa.ehr.service.admin;

import java.util.List;

import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;



public interface StaffDetailsService {


	List<StaffDetailsDTO> retrieveAllCCMProviders(Long orgId);
	List<StaffDetailsDTO> retrieveAllStaffMembers(Long orgId);
	List<StaffDetailsDTO> retrieveAllStudentMembers();
	StaffDetailsDTO retrieveStaffDetailsById(Long id);
}

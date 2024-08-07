package com.cpa.ehr.service.admin;

import java.util.List;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffPaymentDetailsDTO;


/**
 * Interface StaffMember Service holds all the interfaces
 * supported for performing CRUD operations against 
 * StaffMember Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface StaffMemberService {
	
	StaffMemberDTO persistStaffMember(StaffMemberDTO staffMemberDTO);

	
	/**
	 * Retrieves list of all StaffMembers
	 * 
	 * @return List of all StaffMembers
	 */
	List<StaffMemberDTO> retrieveAllStaffMembers();
	
	void updatePassword(String password, Long staffId);
	
	StaffMember findByEmail(String email);

	List<StaffMemberDTO> retrieveAllPrimaryProvider();
	
	StaffMemberDTO retrieveStaffMemberById(Long staffId);
	
	StaffMemberDTO updateStaffMemberById(StaffMemberDTO staffMemberDTOToUpdate);
	
	boolean checkStaffMemberInUse(Long staffId);
	
	boolean setUserLoginTime();
	
	boolean setUserLogoutTime(Long staffId);
	
    public Long removeStaffMemberById(Long staffId);

    StaffMemberDTO updatePaymentStatus(StaffPaymentDetailsDTO staffPaymentDetailsDTO);
    
    StaffMemberDTO  getLoginStatus();
}

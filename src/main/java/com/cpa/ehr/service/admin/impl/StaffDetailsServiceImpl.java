package com.cpa.ehr.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.StaffDetailsRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffDetails;
import com.cpa.ehr.service.admin.StaffDetailsService;
import com.cpa.ehr.service.admin.dto.StaffDetailsDTO;
import com.cpa.ehr.service.admin.dto.mapper.StaffDetailsMapper;

/**
 * Implementation for the StaffMember Service
 * 
 * StaffMemberService holds all the interfaces
 * supported for performing CRUD operations against 
 * StaffMember Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Service
public class StaffDetailsServiceImpl implements StaffDetailsService {
	
	@Autowired
	private StaffDetailsRepository staffDetailsRepo;
	
	@Autowired
	private StaffDetailsMapper staffdetailsMapper;


	
	@Override
	public List<StaffDetailsDTO> retrieveAllCCMProviders(Long orgId) {
		List<StaffDetails> staffMemberList = staffDetailsRepo.findAllCCMProviders(orgId);
		return (staffMemberList != null) ? staffdetailsMapper.entityListToStaffDetailsDTOList(staffMemberList) : null;
	}

	@Override
	public List<StaffDetailsDTO> retrieveAllStaffMembers(Long orgId) {
		List<StaffDetails> staffMemberList = staffDetailsRepo.findAllActiveStaffMembersfromView(orgId);
		return (staffMemberList != null) ? staffdetailsMapper.entityListToStaffDetailsDTOList(staffMemberList) : null;
	}
	
	@Override
	public List<StaffDetailsDTO> retrieveAllStudentMembers() {
		List<StaffDetails> staffMemberList = staffDetailsRepo.findAllActiveStudentMembersfromView();
		return (staffMemberList != null) ? staffdetailsMapper.entityListToStaffDetailsDTOList(staffMemberList) : null;
	}

	@Override
	public StaffDetailsDTO retrieveStaffDetailsById(Long id) {
		StaffDetails staffDetails= staffDetailsRepo.findActiveOneByStaffMemberId(id);
		return (staffDetails != null) ? staffdetailsMapper.entityToStaffDetailsDTO(staffDetails) : null;
	}


}
package com.cpa.ehr.service.admin.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.StaffRolesRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;
import com.cpa.ehr.service.admin.StaffRolesService;
import com.cpa.ehr.service.admin.dto.StaffRolesDTO;
import com.cpa.ehr.service.admin.dto.mapper.StaffRolesMapper;
import com.cpa.ehr.util.FormatConverterUtils;


/**
 * Implementation for the StaffRoles Service
 * 
 * StaffRolesService holds all the interfaces
 * supported for performing CRUD operations against 
 * StaffRoles Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Service
public class StaffRolesServiceImpl implements StaffRolesService {

	@Autowired
	private StaffRolesRepository staffRolesRepo;

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private StaffRolesMapper staffRolesMapper;



	/**
	 * Persists StaffRoles information in database
	 * 
	 * @param staffRolesDTO
	 * 		DTO of the StaffRoles to be persisted in DB
	 * @return Integer
	 * 		Identifier of the created entity
	 */
	@Override
	public StaffRolesDTO persistStaffRoles(StaffRolesDTO staffRolesDTO) {
		if ( staffRolesDTO != null ) {
			//Check whether the correct Staff Member entry exists
			//before persisting Staff Roles Info
			
			StaffMember staffMember = null;
			
			if(staffRolesDTO.getAuthority().equalsIgnoreCase("TRY_ME")) {
//				System.out.println("in try me if..........");
				 staffMember = staffMemberRepo.findActiveOneByStudMemberId(staffRolesDTO.getStaffId() );
			}else {
				 staffMember = staffMemberRepo.findActiveOneByStaffMemberId(staffRolesDTO.getStaffId() );
			}
			
			//System.out.println("---------------------- "+staffMember);
			if (staffMember != null ) {
				StaffRoles newStaffRole = staffRolesMapper.staffRolesDTOToEntity(staffRolesDTO);
				StaffRoles createdStaffRole = staffRolesRepo.saveAndFlush(newStaffRole); 
				return (createdStaffRole != null) ? staffRolesMapper.entityToStaffRolesDTO(createdStaffRole) : null;
			}
		}
		return null;
	}


	@Override
	public StaffRolesDTO retrieveStaffRolesByStaffId(Long staffId) {
		StaffRoles staffRoles = staffRolesRepo.findActiveOneByStaffId(staffId);
		return (staffRoles != null) ? staffRolesMapper.entityToStaffRolesDTO(staffRoles) : null;
	}

	@Override
	public StaffRolesDTO updateStaffRolesById(StaffRolesDTO staffRolesDTOToUpdate) {
		StaffRoles staffRolesToUpdate = staffRolesRepo.findOne(staffRolesDTOToUpdate.getStaffRoleId());
		//Check whether the correct organization exists
		//before updating Service Type Info
		StaffMember staffMember = staffMemberRepo.findActiveOneByStaffMemberId(staffRolesDTOToUpdate.getStaffId());
		if ( staffRolesToUpdate != null && staffMember != null ) {
			
			// Update every field except staffMember, Created By & Created Date fields
			// !!! -- Service Type once created for an Org should not be
			// reassigned to another Org -- !!!
			staffRolesToUpdate.setActiveFlag(FormatConverterUtils.convertBooleantoActiveFlag(staffRolesDTOToUpdate.getActiveFlag()));
			staffRolesToUpdate.setAuthority(staffRolesDTOToUpdate.getAuthority());
			staffRolesToUpdate.setStaffRoleId(staffRolesDTOToUpdate.getStaffRoleId());
			staffRolesToUpdate.setLastUpdatedBy(staffRolesDTOToUpdate.getLastUpdatedBy());
			staffRolesToUpdate.setLastUpdatedDate(staffRolesDTOToUpdate.getLastUpdatedDate());
			StaffRoles updatedStaffRole = staffRolesRepo.save(staffRolesToUpdate);
			return (updatedStaffRole != null) ? staffRolesMapper.entityToStaffRolesDTO(updatedStaffRole) : null;
		}
		return null;
	}
	
	@Override
	public void removeStaffRolesById(Long staffId) {
		
		StaffRoles staffRolesToDelete = staffRolesRepo.findActiveOneByStaffId(staffId);
		if (staffRolesToDelete != null) {
			staffRolesToDelete.setActiveFlag("N");
			staffRolesRepo.saveAndFlush(staffRolesToDelete);
		}
	}

}



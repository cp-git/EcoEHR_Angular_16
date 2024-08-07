package com.cpa.ehr.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.ehr.backend.dao.admin.RoleRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.StaffPaymentDetailsRepository;
import com.cpa.ehr.backend.dao.admin.StaffRolesRepository;
import com.cpa.ehr.backend.dao.admin.entities.Role;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.backend.dao.admin.entities.StaffRoles;

@Service
@Transactional(readOnly = true)
public class CCMUserServiceImpl implements CCMUserService {

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private StaffRolesRepository staffRolesRepo;

	@Autowired
	private StaffPaymentDetailsRepository staffPaymentRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<StaffMember> staffMember = staffMemberRepo.findByLoginId(username);
		if (staffMember.isPresent()) {
			StaffRoles staffRole = staffRolesRepo.findActiveOneByStaffId(staffMember.get().getStaffId());
			StaffPaymentDetails staffPayment = staffPaymentRepo.findStaffPaymentStatus(staffMember.get().getStaffId());

			Role roles = roleRepo.findActiveRoleByAuthority(staffRole.getAuthority());
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority(roles.getAuthority()));
			String activeFlagValue = staffMember.get().getActiveFlag().trim();

			if (activeFlagValue.contentEquals("Y")) {
				CCMUser loggedUser = new CCMUser();
				loggedUser.setStaffMember(staffMember.get());
				loggedUser.setAuthorities(authorities);
				loggedUser.setPaymentStatus(staffPayment.getPaymentStatus());
				return loggedUser;

			} else {
				return null;
			}
		} else
			throw new UsernameNotFoundException(null);

	}

}

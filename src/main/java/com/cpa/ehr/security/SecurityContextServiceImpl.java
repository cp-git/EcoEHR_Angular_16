package com.cpa.ehr.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;




@Service
public class SecurityContextServiceImpl implements SecurityContextService {

	private final StaffMemberRepository staffRepository;

	@Autowired
	public SecurityContextServiceImpl(StaffMemberRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	@Override
	public StaffMember currentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		final Optional<StaffMember> currentUser = staffRepository.findByLoginId(authentication.getName());
	
		return currentUser.orElse(null);
	}
}


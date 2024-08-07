package com.cpa.ehr.service.home.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.PasswordResetTokenRepository;
import com.cpa.ehr.backend.dao.admin.entities.PasswordResetToken;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.home.PasswordResetService;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {
	@Autowired
	private PasswordResetTokenRepository tokenRepository;

	public PasswordResetToken createToken(StaffMember userName) {
		if (userName == null) {
			return null;
		}

		PasswordResetToken token = new PasswordResetToken();
		token.setToken(UUID.randomUUID().toString());
		token.setStaffMember(userName);
		token.setExpiryDate(6);
		tokenRepository.save(token);
		return token;

	}

	public PasswordResetToken findToken(String token) {
		PasswordResetToken resetToken = tokenRepository.findByToken(token);
		if (resetToken != null) {
			return resetToken;
		} else {
			return null;
		}
	}

	public void deleteToken(PasswordResetToken resetToken) {
		tokenRepository.delete(resetToken);

	}
}

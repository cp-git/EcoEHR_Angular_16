package com.cpa.ehr.service.home;

import com.cpa.ehr.backend.dao.admin.entities.PasswordResetToken;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;

public interface PasswordResetService {

	PasswordResetToken createToken(StaffMember userName);
	PasswordResetToken findToken(String token);
	void deleteToken(PasswordResetToken resetToken);
	
}

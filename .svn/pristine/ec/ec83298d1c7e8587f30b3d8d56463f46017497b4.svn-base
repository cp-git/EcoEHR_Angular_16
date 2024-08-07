package com.cpa.ehr.security;

import java.util.Collection;
import java.util.Collections;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CCMUserDTO {
	
private static final String ADMIN = "ROLE_ADMIN";
	
    private Long staffId; 
	
    @NotBlank
	@Size(max = 10)
    private String loginId; 
	
    @NotBlank
	@Size(max = 500)
    private String loginKey; 
	
	/**
	 * @return the staffId
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the loginKey
	 */
	public String getLoginKey() {
		return loginKey;
	}

	/**
	 * @param loginKey the loginKey to set
	 */
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	
	public CCMUserDTO(@JsonProperty("staffId")Long staffId, @JsonProperty("loginId") String loginId,@JsonProperty("loginKey") String loginKey) {
		super();
		this.staffId = staffId;
		this.loginId = loginId;
		this.loginKey = loginKey;
	}
	
	public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(loginId, loginKey, getAuthorities());
    }
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> ADMIN);
    }

	@Override
	public String toString() {
		return "CCMUserDTO [staffId=" + staffId + ", loginId=" + loginId + ", loginKey=" + loginKey + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	
	

}

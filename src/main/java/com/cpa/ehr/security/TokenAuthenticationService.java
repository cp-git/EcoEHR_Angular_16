package com.cpa.ehr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@CrossOrigin(origins = "*")
class TokenAuthenticationService {
	
	 private static final String AUTH_HEADER_NAME = "x-auth-token";

	 private final TokenHandler tokenHandler;
	 
	 @Autowired
	    public TokenAuthenticationService(TokenHandler tokenHandler) {
	        this.tokenHandler = tokenHandler;
	    }
	 
	 void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
		 	final UserDetails user = authentication.getDetails();
		 	String token = tokenHandler.createTokenForUser(user);
		 	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 	System.out.println( token);
		 	response.addHeader(AUTH_HEADER_NAME, token);//(AUTH_HEADER_NAME, );
	 	}
	 
	 Authentication getAuthentication(HttpServletRequest request) {
	        final String token = request.getHeader(AUTH_HEADER_NAME);
	        if (token == null || token.isEmpty()) return null;
	        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	        System.out.println(token);
	        return tokenHandler
	                .parseUserFromToken(token)
	                .map(UserAuthentication::new)
	                .orElse(null);
	    }

}

package com.cpa.ehr.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;


class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter{
	
	   private final TokenAuthenticationService tokenAuthenticationService;
	   
	   @Autowired
	   private final CCMUserService staffMemberService;
	    
	    StatelessLoginFilter(String urlMapping,
                TokenAuthenticationService tokenAuthenticationService,
                CCMUserService staffMemberService,
                AuthenticationManager authenticationManager) {
	    
	    		
	    		super(urlMapping);
	    	
	    		this.tokenAuthenticationService = tokenAuthenticationService;
	    		this.staffMemberService = staffMemberService;
	    		setAuthenticationManager(authenticationManager);
	    		
	    		}
	    
	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest request,
	                                                HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
	       
	    	final CCMUserDTO params = new ObjectMapper().readValue(request.getInputStream(), CCMUserDTO.class);
	    	final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
	        return getAuthenticationManager().authenticate(loginToken);
	    }
	    
	    @Override
	    protected void successfulAuthentication(HttpServletRequest request,
	                                            HttpServletResponse response,
	                                            FilterChain chain,
	                                            Authentication authResult) throws IOException, ServletException {
	    
	        final UserDetails authenticatedUser = staffMemberService.loadUserByUsername(authResult.getName());
	        final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);
	        tokenAuthenticationService.addAuthentication(response, userAuthentication);

	        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
	    }

}

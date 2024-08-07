package com.cpa.ehr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
	@Autowired
	private final CCMUserService staffMemberService;
	@Autowired
	private final TokenAuthenticationService tokenAuthenticationService;
	String adminURL = "/api/rest/admin/**";
	String admin = "ADMIN";

//    String studURL = "/api/rest/student/**";
//    String stud = "STUDENT";
	@Autowired
	public SecurityConfiguration(CCMUserService staffMemberService,
			TokenAuthenticationService tokenAuthenticationService) {
		super(true);
		this.staffMemberService = staffMemberService;
		this.tokenAuthenticationService = tokenAuthenticationService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("into backend");
		http.exceptionHandling().and().anonymous().and().servletApi().and().headers().cacheControl();
		http.authorizeRequests().antMatchers("/api/rest/home/auth/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/rest/admin/createStaffMember").permitAll()
				.antMatchers(HttpMethod.POST, "/api/rest/admin/createStaffMember").permitAll()
				
				.antMatchers("/api/rest/admin/createStaffRoles").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/rest/admin/modifyStaffMemberById").authenticated()
				.antMatchers(HttpMethod.PUT, "/api/rest/admin/modifyStaffRolesById").authenticated()
				
				.antMatchers(HttpMethod.POST, adminURL).hasRole(admin).antMatchers(HttpMethod.DELETE, adminURL)
				.hasRole(admin).antMatchers(HttpMethod.PUT, adminURL).hasRole(admin)
				
				.antMatchers("/api/rest/admin/modifyStaffPaymentDetails").permitAll()
				.antMatchers("/api/rest/students/**").permitAll().antMatchers("/api/rest/payment/**").permitAll();
//				  .and()
//			        .sessionManagement()
//			        .maximumSessions(1)
//			        .maxSessionsPreventsLogin(true);
//    	 .antMatchers(HttpMethod.PUT, "/api/rest/payment/setUserLoginTime").permitAll()
//    	 .antMatchers(HttpMethod.PUT, "/api/rest/payment/setUserLogoutTime").permitAll();
//    	 .antMatchers(HttpMethod.GET, "/api/rest/**").authenticated()
//         .antMatchers(HttpMethod.POST, "/api/rest/**").authenticated() ;
		http.addFilterBefore(new StatelessLoginFilter("/auth/login", tokenAuthenticationService, staffMemberService,
				authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		
		http.addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService),
				UsernamePasswordAuthenticationFilter.class);
		
//		http.sessionManagement().maximumSessions(1).expiredUrl("/")// prevents login for > 2attempts and sends to the authentication-failure-url
//				.sessionRegistry(sessionRegistry());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(staffMemberService);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return staffMemberService;
	}

}
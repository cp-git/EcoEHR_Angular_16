package com.cpa.ehr.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.cpa.ehr.backend.dao.admin.constants.StaffMemberConstants;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;



/**
 * Repository interface for Staff Member Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Repository
@Transactional
public interface StaffMemberRepository extends JpaRepository<StaffMember, Long> {
	/* Query definition constants */

	@Query(value = StaffMemberConstants.FIND_STAFF_BY_LOGIN_ID, nativeQuery = true)
	Optional<StaffMember> findByLoginId(@Param("loginId")String loginId);
	
	@Query(value = StaffMemberConstants.FIND_STAFF_BY_LOGIN_ID, nativeQuery = true)
	StaffMember getByLoginId(@Param("loginId")String loginId);
	
	@Query(value = StaffMemberConstants.SELECT_ADMIN__BASE, nativeQuery = true)
	Optional<StaffMember> findAdmin();
	
	@Query(value = StaffMemberConstants.FIND_STAFF_BY_EMAIL_ID, nativeQuery = true)
	StaffMember findByEmail(@Param("email")String email);

	@Query(value = StaffMemberConstants.SELECT_BASE, nativeQuery = true)
	List <StaffMember> findAllActiveStaffMembers();

	@Query(value = StaffMemberConstants.FIND_ORG_BY_ID, nativeQuery = true)
	StaffMember findActiveOneByStaffMemberId(@Param("staffId") Long id);
	
	@Query(value = StaffMemberConstants.FIND_ORG_BY_STUD_ID, nativeQuery = true)
	StaffMember findActiveOneByStudMemberId(@Param("staffId") Long id);
	
	@Query(value = StaffMemberConstants.FIND_ALL_PRIMARY_PROVIDER, nativeQuery = true)
	List<StaffMember> findAllPrimaryProvider();
	
}
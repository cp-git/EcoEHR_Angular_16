package com.cpa.ehr.service.admin.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.OrganizationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.StaffPaymentDetailsRepository;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.admin.entities.StaffPaymentDetails;
import com.cpa.ehr.backend.dao.patients.PatientDetailsRepository;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.admin.StaffMemberService;
import com.cpa.ehr.service.admin.dto.StaffMemberDTO;
import com.cpa.ehr.service.admin.dto.StaffPaymentDetailsDTO;
import com.cpa.ehr.service.admin.dto.mapper.StaffMemberMapper;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.util.FormatConverterUtils;

/**
 * Implementation for the StaffMember Service
 * 
 * StaffMemberService holds all the interfaces supported for performing CRUD
 * operations against StaffMember Entity
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Service
public class StaffMemberServiceImpl implements StaffMemberService {
	private static final Logger LOG = LoggerFactory.getLogger(StaffMemberServiceImpl.class);

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private StaffPaymentDetailsRepository staffPaymentRepo;

	@Autowired
	private OrganizationRepository orgRepo;

	@Autowired
	private ClinicLocationRepository clinicLocRepo;

	@Autowired
	private PatientDetailsRepository patientDetailsRepo;

	@Autowired
	private StaffMemberMapper staffMemberMapper;

	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private EmailService emailService;

	@Override
	public StaffMemberDTO persistStaffMember(StaffMemberDTO staffMemberDTO) {
		try {
			if (staffMemberDTO != null) {
				StaffMember staffMemberToInsert = staffMemberMapper.staffMemberDTOToEntity(staffMemberDTO);
				StaffMember insertedStaffMember = staffMemberRepo.save(staffMemberToInsert);

				StaffPaymentDetails insertedPaymentDetails = null;
				if (insertedStaffMember != null) {
					StaffPaymentDetails sobj = new StaffPaymentDetails();
					sobj.setStaff(insertedStaffMember);
					sobj.setPaymentStatus("pending");
					insertedPaymentDetails = staffPaymentRepo.save(sobj);
				}

				return (insertedStaffMember != null && insertedPaymentDetails != null)
						? staffMemberMapper.entityToStaffMemberDTO(insertedStaffMember)
						: null;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting staff Member {}  " + "{" + staffMemberDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while inserting staff Member {} ", e);
		}
		return null;
	}

	/**
	 * Retrieves list of all StaffMembers
	 * 
	 * @return List of all StaffMembers
	 */
	@Override
	public List<StaffMemberDTO> retrieveAllStaffMembers() {
		try {
			List<StaffMember> staffMemberList = staffMemberRepo.findAllActiveStaffMembers();
			return (staffMemberList != null) ? staffMemberMapper.entityListToStaffMemberDTOList(staffMemberList) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving staff Member {}  \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while retrieving all staff members {} ", e);
		}
		return Collections.emptyList();
	}

	public StaffMember findByEmail(String email) {
		return staffMemberRepo.findByEmail(email);
	}

	@Override
	public void updatePassword(String password, Long staffId) {
		try {
			StaffMember staff = staffMemberRepo.findOne(staffId);
			if (staff != null) {
				staff.setLoginKey(password);
				staffMemberRepo.saveAndFlush(staff);
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while Updating password {} " + " {" + staffId + " } \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while retrieving all primary provider {} ", e);
		}
	}

	@Override
	public List<StaffMemberDTO> retrieveAllPrimaryProvider() {
		try {
			List<StaffMember> primaryProviderList = staffMemberRepo.findAllPrimaryProvider();
			return (primaryProviderList != null) ? staffMemberMapper.entityListToStaffMemberDTOList(primaryProviderList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all primary provider {}  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while retrieving all primary provider {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public StaffMemberDTO retrieveStaffMemberById(Long staffId) {
		try {
			StaffMember staffMember = staffMemberRepo.findActiveOneByStaffMemberId(staffId);
			return (staffMember != null) ? staffMemberMapper.entityToStaffMemberDTO(staffMember) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving selected staff membe{} " + " {" + staffId + " } \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			LOG.error("Error while retrieving selected staff member {}", e);
		}
		return null;

	}

	@Override
	public StaffMemberDTO updateStaffMemberById(StaffMemberDTO staffMemberDTOToUpdate) {

		StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staffMemberDTOToUpdate.getStaffId());
		// Check whether the correct organization & Clinic Location exists
		// before updating Staff Member Info

		long id = 1;
		Organization org;
		ClinicLocation clinicLoc;

//		System.out.println("---------------------------- "+staffMemberDTOToUpdate.getActiveFlag());

		if (staffMemberDTOToUpdate.getDesignation().equalsIgnoreCase("TRY_ME")) {
			org = orgRepo.findActiveOneByOrganizationId(id);
			clinicLoc = clinicLocRepo.findOne(id);

			/* 30 Days Trail Free Code */
			StaffPaymentDetails detailsToUpdate = staffPaymentRepo
					.findStaffPaymentStatus(staffMemberDTOToUpdate.getStaffId());

			if (detailsToUpdate != null && staffMemberDTOToUpdate.getActiveFlag()) {
				// System.out.println("in Ifffffffffffffffffffffff");
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
				Calendar c1 = Calendar.getInstance();
				String currentDate = df.format(date);// get current date here

				// now add 30 day in Calendar instance
				c1.add(Calendar.DAY_OF_YEAR, 30);
				df = new SimpleDateFormat("yyyy-MM-dd");
				Date resultDate = c1.getTime();
				String dueDate = df.format(resultDate);

				detailsToUpdate.setPaymentStatus("approved");
				detailsToUpdate.setLicenseStartDate(date);
				detailsToUpdate.setLicenseEndDate(resultDate);

				StaffPaymentDetails updatedStaffPaymentDetails = staffPaymentRepo.save(detailsToUpdate);
			}
		} else {
			org = orgRepo.findActiveOneByOrganizationId(staffMemberDTOToUpdate.getOrganizationId());
			clinicLoc = clinicLocRepo.findOne(staffMemberDTOToUpdate.getClinicLocationId());
		}

		if (staffMemberToUpdate != null && org != null && clinicLoc != null) {

			// Update every field except Organization, Clinic Location, Created By & Created
			// Date fields
			// !!! -- Staff Member once created for an Org should not be
			// reassigned to another Org -- !!!
			staffMemberToUpdate.setClinicLocation(clinicLoc);
			staffMemberToUpdate.setActiveFlag(
					FormatConverterUtils.convertBooleantoActiveFlag(staffMemberDTOToUpdate.getActiveFlag()));
			staffMemberToUpdate.setBusinessPhoneNo(staffMemberDTOToUpdate.getBusinessPhoneNo());
			staffMemberToUpdate.setDesignation(staffMemberDTOToUpdate.getDesignation());
			staffMemberToUpdate.setEmail(staffMemberDTOToUpdate.getEmail());
			staffMemberToUpdate.setFirstName(staffMemberDTOToUpdate.getFirstName());
			staffMemberToUpdate.setLastAction(staffMemberDTOToUpdate.getLastAction());
			staffMemberToUpdate.setLastActionDate(staffMemberDTOToUpdate.getLastActionDate());
			staffMemberToUpdate.setLastClient(staffMemberDTOToUpdate.getLastClient());
			staffMemberToUpdate.setLastLoginDate(staffMemberDTOToUpdate.getLastLoginDate());
			staffMemberToUpdate.setLastName(staffMemberDTOToUpdate.getLastName());
			staffMemberToUpdate.setLoginId(staffMemberDTOToUpdate.getLoginId());
			staffMemberToUpdate.setLoginKey(staffMemberDTOToUpdate.getLoginKey());
			staffMemberToUpdate.setMiddleName(staffMemberDTOToUpdate.getMiddleName());
			staffMemberToUpdate.setMobileNo(staffMemberDTOToUpdate.getMobileNo());
			staffMemberToUpdate.setProviderFlag(staffMemberDTOToUpdate.getProviderFlag());
			staffMemberToUpdate.setProviderType(staffMemberDTOToUpdate.getProviderType());
			staffMemberToUpdate.setStaffId(staffMemberDTOToUpdate.getStaffId());
			staffMemberToUpdate.setNpiNumber(staffMemberDTOToUpdate.getNpiNumber());
			staffMemberToUpdate.setStaffImage(staffMemberDTOToUpdate.getStaffImage());
			staffMemberToUpdate.setLastUpdatedBy(staffMemberDTOToUpdate.getLastUpdatedBy());
			staffMemberToUpdate.setLastUpdatedDate(staffMemberDTOToUpdate.getLastUpdatedDate());
			staffMemberToUpdate.setLicenseState(staffMemberDTOToUpdate.getLicenseState());
			staffMemberToUpdate.setLicenseNumber(staffMemberDTOToUpdate.getLicenseNumber());
			staffMemberToUpdate.setLicenseExpDate(staffMemberDTOToUpdate.getLicenseExpDate());
			staffMemberToUpdate.setDeaNumber(staffMemberDTOToUpdate.getDeaNumber());
			staffMemberToUpdate.setDeaExpDate(staffMemberDTOToUpdate.getDeaExpDate());
			staffMemberToUpdate.setMalpracticeCoverage(staffMemberDTOToUpdate.getMalpracticeCoverage());
			staffMemberToUpdate.setMalpracticeExpiration(staffMemberDTOToUpdate.getMalpracticeExpiration());
			staffMemberToUpdate.setDob(staffMemberDTOToUpdate.getDob());
			staffMemberToUpdate.setGender(staffMemberDTOToUpdate.getGender());
			staffMemberToUpdate.setSsn(staffMemberDTOToUpdate.getSsn());
			StaffMember updatedStaffMember = staffMemberRepo.save(staffMemberToUpdate);
			return (updatedStaffMember != null) ? staffMemberMapper.entityToStaffMemberDTO(updatedStaffMember) : null;
		}
		return null;
	}

	@Override
	public boolean setUserLoginTime() {
		try {
			StaffMember staff = ehrBaseService.currentUser();
			StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staff.getStaffId());

			if (staffMemberToUpdate != null) {
				staffMemberToUpdate.setLastLoginDate(new Date());
				// staffMemberToUpdate.setLastAction("loggedIn");

				StaffMember updatedDetails = staffMemberRepo.save(staffMemberToUpdate);
				if (updatedDetails != null) {
					return true;
				}
				return true;
			}
			// return false;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating login time{} " + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);

			// e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setUserLogoutTime(Long staffId) {
		try {
			StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staffId);

			if (staffMemberToUpdate != null) {
				staffMemberToUpdate.setLastActionDate(new Date().toString());
				// staffMemberToUpdate.setLastAction("loggedOut");

				StaffMember updatedDetails = staffMemberRepo.save(staffMemberToUpdate);
				if (updatedDetails != null) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating log out time{} " + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public StaffMemberDTO getLoginStatus() {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
//			System.out.println("login User" + loginUser);
			return (loginUser != null) ? staffMemberMapper.entityToStaffMemberDTO(loginUser) : null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving login status{} " + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public StaffMemberDTO updatePaymentStatus(StaffPaymentDetailsDTO staffPaymentDetailsDTO) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();

			StaffPaymentDetails detailsToUpdate = staffPaymentRepo.findStaffPaymentStatus(loginUser.getStaffId());

			if (detailsToUpdate != null) {
				// System.out.println("in Ifffffffffffffffffffffff");
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
				Calendar c1 = Calendar.getInstance();
				String currentDate = df.format(date);// get current date here

				// now add 30 day in Calendar instance
				c1.add(Calendar.DAY_OF_YEAR, 30);
				df = new SimpleDateFormat("yyyy-MM-dd");
				Date resultDate = c1.getTime();
				String dueDate = df.format(resultDate);

				detailsToUpdate.setPaymentStatus("approved");
				detailsToUpdate.setLicenseStartDate(date);
				detailsToUpdate.setLicenseEndDate(resultDate);

				StaffPaymentDetails updatedStaffPaymentDetails = staffPaymentRepo.save(detailsToUpdate);
				return (loginUser != null) ? staffMemberMapper.entityToStaffMemberDTO(loginUser) : null;
			}

		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while updating staff payment details{} " + "{" + staffPaymentDetailsDTO
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean checkStaffMemberInUse(Long staffId) {
		try {
			List<PatientDetails> patientList = patientDetailsRepo.getPatientsByStaffId(staffId);
			if (patientList.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while checking staff already in use or not {} " + "{" + staffId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while checking staff already in use or not {}", e);
		}
		return false;
	}

	@Override
	public Long removeStaffMemberById(Long staffId) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			StaffMember staffMemberToDelete = staffMemberRepo.findOne(staffId);
			if (staffMemberToDelete != null) {

				staffMemberToDelete.setLastUpdatedBy(loginUser.getLoginId());
				staffMemberToDelete.setLastUpdatedDate(new Date());
				staffMemberToDelete.setActiveFlag("N");
				staffMemberRepo.saveAndFlush(staffMemberToDelete);
			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing staff Member {}  " + "{" + staffId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while removing staff Member  {}", e);
		}
		return staffId;

	}
}

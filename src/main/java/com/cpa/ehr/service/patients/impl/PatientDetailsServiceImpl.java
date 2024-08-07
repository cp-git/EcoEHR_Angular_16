package com.cpa.ehr.service.patients.impl;


import java.util.Date;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.patients.entities.PatientDetails;
import com.cpa.ehr.backend.dao.patients.entities.PatientRecord;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.backend.dao.admin.ClinicLocationRepository;
import com.cpa.ehr.backend.dao.admin.StaffMemberRepository;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.backend.dao.patients.PatientDetailsRepository;
import com.cpa.ehr.backend.dao.patients.PatientRecordRepository;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.patients.PatientDetailsService;
import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;
import com.cpa.ehr.service.patients.dto.PatientRecordDTO;
import com.cpa.ehr.service.patients.dto.mapper.PatientDetailsMapper;
import com.cpa.ehr.service.patients.dto.mapper.PatientRecordMapper;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService{
	private static final Logger LOG = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);

	@Autowired
	private PatientDetailsRepository patientDetailsRepo;
	
	@Autowired
	private PatientRecordRepository patientRecordRepo;
	
	@Autowired
	private PatientDetailsMapper patientDetailsMapper;
	
	@Autowired
	private PatientRecordMapper patientRecordMapper;
	
	@Autowired
	private ClinicLocationRepository clinicLocRepo;
	
	@Autowired
	private StaffMemberRepository staffMemberRepo;
	
	@Autowired
	private EHRBaseService ehrBaseService;

	@Autowired
	private EmailService emailService;
	
	@Override
	public PatientDetailsDTO persistPatientDetails(PatientDetailsDTO patientDetailsDTO){
		try {
			if(patientDetailsDTO != null) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+patientDetailsDTO);
				PatientDetails patientToInsert = patientDetailsMapper.patientDetailsDTOToEntity(patientDetailsDTO);
				PatientDetails insertedPatient = patientDetailsRepo.save(patientToInsert);
				PatientDetailsDTO insertedPatientDTO = patientDetailsMapper.entityToPatientDetailsDTO(insertedPatient);
				String mrnString = insertedPatientDTO.getLastName().toUpperCase().charAt(0)+""+insertedPatientDTO.getFirstName().toUpperCase().charAt(0);
				String mrnId = String.format("%08d", insertedPatientDTO.getPatientId());
				insertedPatientDTO.setMrn(mrnString+""+mrnId);
				this.modifyPatientDetails(insertedPatientDTO);
				insertedPatient.setMrn(mrnString+""+mrnId);
				return (insertedPatient != null) ? patientDetailsMapper.entityToPatientDetailsDTO(insertedPatient) : null;
			}
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting patient details {}  " + "{" + patientDetailsDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while inserting patient details {} ", e);
		}
		return null;
	}

	@Override
	public List<PatientDetailsDTO> retrieveAllPatients() {
		try {
			List<PatientDetails> patient = patientDetailsRepo.findAllPatients();
			return (patient != null) ? patientDetailsMapper.entityListToPatientDetailsDTOList(patient) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while inserting all patients {}  \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all patients {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public PatientRecordDTO retrievePatientRecordPatientId(Long patientId,Long orgId){
		try {
			PatientRecord partient = patientRecordRepo.findPatientRecordByPatientId(patientId,orgId);
			return (patientRecordMapper != null) ? patientRecordMapper.entityToPatientRecordDTO(partient) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while  retrieving all encounters location by patientId {}  " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all encounters location by patientId {} ", e);
		}
		return null;
	}

	
	@Override
	public PatientDetailsDTO retrievePatientDetailsPatientId(Long patientId){
		try {
			PatientDetails partient = patientDetailsRepo.findPatientDetailsByPatientId(patientId);
			return (patientDetailsMapper != null) ? patientDetailsMapper.entityToPatientDetailsDTO(partient) : null;
		}
		catch (Exception e){
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while  retrieving all encounters location by patientId {}  " + "{" + patientId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all encounters location by patientId {} ", e);
		}
		return null;
	}
	
	@Override
	public PatientDetailsDTO modifyPatientDetails(PatientDetailsDTO patientDetailsDTO) {
		try {
			PatientDetails patientDetailsToUpdate = patientDetailsRepo.findOne(patientDetailsDTO.getPatientId());
			ClinicLocation clinicLoc = clinicLocRepo.findOne(patientDetailsDTO.getClinicLocationId());
			StaffMember staff = staffMemberRepo.findOne(patientDetailsDTO.getStaffId());
			
			if ( patientDetailsToUpdate != null && clinicLoc != null) {
				patientDetailsToUpdate.setClinicLocation(clinicLoc);
				patientDetailsToUpdate.setStaffMember(staff);
				patientDetailsToUpdate.setPatientId(patientDetailsDTO.getPatientId());
				patientDetailsToUpdate.setFirstName(patientDetailsDTO.getFirstName());
				patientDetailsToUpdate.setMiddleName(patientDetailsDTO.getMiddleName());
				patientDetailsToUpdate.setLastName(patientDetailsDTO.getLastName());
				patientDetailsToUpdate.setGender(patientDetailsDTO.getGender());
				patientDetailsToUpdate.setDob(patientDetailsDTO.getDob());
				patientDetailsToUpdate.setPrimaryEmail(patientDetailsDTO.getPrimaryEmail());
				patientDetailsToUpdate.setSecondaryEmail(patientDetailsDTO.getSecondaryEmail());
				patientDetailsToUpdate.setPrimaryNo(patientDetailsDTO.getPrimaryNo());
				patientDetailsToUpdate.setSecondaryNo(patientDetailsDTO.getSecondaryNo());
				patientDetailsToUpdate.setPatientStreetAddress(patientDetailsDTO.getPatientStreetAddress());
				patientDetailsToUpdate.setPatientApartmentNo(patientDetailsDTO.getPatientApartmentNo());
				patientDetailsToUpdate.setPatientCity(patientDetailsDTO.getPatientCity());
				patientDetailsToUpdate.setPatientState(patientDetailsDTO.getPatientState());
				patientDetailsToUpdate.setZipCode(patientDetailsDTO.getZipCode());
				patientDetailsToUpdate.setEmrId(patientDetailsDTO.getEmrId());
				patientDetailsToUpdate.setAdditionalInfo(patientDetailsDTO.getAdditionalInfo());
				patientDetailsToUpdate.setPatientImage(patientDetailsDTO.getPatientImage());
				patientDetailsToUpdate.setMrn(patientDetailsDTO.getMrn());
				patientDetailsToUpdate.setLicenseNo(patientDetailsDTO.getLicenseNo());
				patientDetailsToUpdate.setBuildingNo(patientDetailsDTO.getBuildingNo());
				patientDetailsToUpdate.setSsn(patientDetailsDTO.getSsn());
				patientDetailsToUpdate.setTitle(patientDetailsDTO.getTitle());
				patientDetailsToUpdate.setAge(patientDetailsDTO.getAge());
				
				patientDetailsToUpdate.setpInsRelationship(patientDetailsDTO.getpInsRelationship());
				patientDetailsToUpdate.setsInsRelationship(patientDetailsDTO.getsInsRelationship());
				
				patientDetailsToUpdate.setpInsName(patientDetailsDTO.getpInsName());
				patientDetailsToUpdate.setsInsName(patientDetailsDTO.getsInsName());
				
				patientDetailsToUpdate.setpInsSsn(patientDetailsDTO.getpInsSsn());
				patientDetailsToUpdate.setsInsSsn(patientDetailsDTO.getsInsSsn());
				
				patientDetailsToUpdate.setpInsPlanName(patientDetailsDTO.getpInsPlanName());
				patientDetailsToUpdate.setsInsPlanName(patientDetailsDTO.getsInsPlanName());
				
				patientDetailsToUpdate.setpInsId(patientDetailsDTO.getpInsId());
				patientDetailsToUpdate.setsInsId(patientDetailsDTO.getsInsId());
				
				patientDetailsToUpdate.setpInsGroup(patientDetailsDTO.getpInsGroup());
				patientDetailsToUpdate.setsInsGroup(patientDetailsDTO.getsInsGroup());
				
				patientDetailsToUpdate.setpInsCompany(patientDetailsDTO.getpInsCompany());
				patientDetailsToUpdate.setsInsCompany(patientDetailsDTO.getsInsCompany());
				
				patientDetailsToUpdate.setsInsDob(patientDetailsDTO.getsInsDob());
				patientDetailsToUpdate.setpInsDob(patientDetailsDTO.getpInsDob());
				patientDetailsToUpdate.setpInsEmployer(patientDetailsDTO.getpInsEmployer());
				patientDetailsToUpdate.setsInsEmployer(patientDetailsDTO.getsInsEmployer());
				
				patientDetailsToUpdate.setRace(patientDetailsDTO.getRace());
				patientDetailsToUpdate.setEthnicity(patientDetailsDTO.getEthnicity());
				patientDetailsToUpdate.setPatientLanguage(patientDetailsDTO.getPatientLanguage());
				patientDetailsToUpdate.setLastUpdatedBy(patientDetailsDTO.getLastUpdatedBy());
				patientDetailsToUpdate.setLastUpdatedDate(patientDetailsDTO.getLastUpdatedDate());
				PatientDetails updatedPatientDetails = patientDetailsRepo.save(patientDetailsToUpdate);
				return (updatedPatientDetails != null) ? patientDetailsMapper.entityToPatientDetailsDTO(updatedPatientDetails) : null;
			}
		}
		 catch (Exception e){
				String username = SecurityUtils.getCurrentUserLogin();
				String exceptionString = "Error while updating patient details " + "{" + patientDetailsDTO + "} \n"
						+ emailService.getStackTrace(e);
				emailService.sendExceptionEmail(exceptionString,username);
				
			 LOG.error("Error while updating patient details {} ", e);
		 }
		return null;
	}	
	
	@Override
	public List<PatientRecordDTO> retrieveAllActivePatients(Long orgId) {
		List<PatientRecord> patientList = patientRecordRepo.findAllActivePatientsfromView(orgId);
		return (patientList != null) ? patientRecordMapper.entityListToPatientRecordDTOList(patientList) : null;
	}

	@Override
	public List<PatientRecordDTO> retrieveAllActivePatientsByUserId(String userName , Date lastLoginDate) {
		try {
			List<PatientRecord> patientList = patientRecordRepo.findAllActivePatientsByUserId(userName, lastLoginDate);
			return (patientList != null) ? patientRecordMapper.entityListToPatientRecordDTOList(patientList) : null;
		}catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieveAllActivePatients " + "{" + userName + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
		 LOG.error("Error while retrieveAllActivePatients {} ", e);
		}
		return null;
	}
	
}
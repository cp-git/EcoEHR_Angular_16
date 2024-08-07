package com.cpa.ehr.service.admin;

import java.sql.SQLException;
import java.util.List;
import com.cpa.ehr.service.admin.dto.ClinicLocationDTO;


/**
 * Interface ClinicLocation Service holds all the interfaces
 * supported for performing CRUD operations against 
 * ClinicLocation Entity 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface ClinicLocationService {
	
	
	/**
	 * 
	 * @param orgId
	 * 		Identifier of the Organization
	 * @return list of ClinicLocation 
	 * @throws EhrBaseException 
	 * 		if the exceptions are other than 
	 * 		NullPointerException and SQLException
	 * @throws NullPointerException
	 * 		if the list of clinicLocations is null 
	 * @throws SQLException
	 * 		if there are any errors in Database
	 */
	List <ClinicLocationDTO> retrieveAllClinicLocations(Long orgId);
	
	ClinicLocationDTO persistClinicLocation(ClinicLocationDTO clinicLocationDTO);	
	
	ClinicLocationDTO retrieveClinicLocationById(Long clinicLocId);
	
	ClinicLocationDTO updateClinicLocationById(ClinicLocationDTO clinicLocDTOToUpdate);
	
	public void removeClinicLocationById(Long clinicLocId);
	
	public boolean checkClinicLocationInUse(Long clinicLocId);
}


package com.cpa.ehr.web.rest.system;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.service.system.ICD10GroupService;
import com.cpa.ehr.service.system.dto.ICD10GroupDTO;


@RestController
@RequestMapping("/api/rest/icd10Groups")
@CrossOrigin(origins = { "http://localhost:4300" })
public class ICD10GroupWebService {
	private static final Logger LOG = LoggerFactory.getLogger(ICD10GroupWebService.class);
	@Autowired
	private ICD10GroupService icd10GroupService;
	
	@GetMapping("/getAllICD10Groups")
	public ResponseEntity<List<ICD10GroupDTO>> getListOfICD10Group()  throws SQLException{
		List<ICD10GroupDTO> icd10groupListResp=null;
		try {
		icd10groupListResp = icd10GroupService.retrieveAllICD10Groups();
		}
		 catch (Exception e) {
				LOG.error("Error while retrieving all Icd10 group List {}",e);
	    }
		return new ResponseEntity<> (icd10groupListResp, HttpStatus.OK); 
	}
}

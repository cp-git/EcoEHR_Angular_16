package com.cpa.ehr.web.rest.system;


import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.system.EncAsessmentService;
import com.cpa.ehr.service.system.dto.EncAsessmentDTO;
import com.cpa.ehr.service.system.dto.PatientAllergyDTO;
import com.cpa.ehr.util.FormatConverterUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/rest/assessment")
@CrossOrigin(origins = { "http://localhost:4300" })
public class EncAsessmentWebService {

	private static final Logger LOG = LoggerFactory.getLogger( EncAsessmentWebService.class);

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private  EncAsessmentService encAsessmentService;

	
	@PostMapping("/createEncAsessment")
	public ResponseEntity<EncAsessmentDTO> insertEncAsessment(@Valid @RequestBody List<EncAsessmentDTO> encAsessmentDTO,
			BindingResult result){
				if(result.hasErrors()){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_FAILED);
			}

			HttpHeaders headers = new HttpHeaders();
			EncAsessmentDTO dataencAsessmentDTO=null;
			StaffMember loginUser = ehrBaseService.currentUser();
			for(EncAsessmentDTO encAsessmentDTOobj : encAsessmentDTO) {
								FormatConverterUtils.setInitialDefaultValues(encAsessmentDTOobj, loginUser);
				
				encAsessmentService.persistEncAsessment(encAsessmentDTOobj);
			}
			
//		
			return new ResponseEntity<>(dataencAsessmentDTO, headers, HttpStatus.CREATED);
	}

	@GetMapping("/getAllEncAsessment")
	public ResponseEntity<List<EncAsessmentDTO>> getAllEncAsessment() {
		List<EncAsessmentDTO> encAsessmentDTOResp=null;
		try {
			encAsessmentDTOResp = encAsessmentService.retrieveAllEncAsessment();
		} catch (Exception e) {
			LOG.error("Error while retrieving all  EncAsessment {}",e);
		}
		return new ResponseEntity<>(encAsessmentDTOResp, HttpStatus.OK);
	}

		

		@GetMapping("/getEncAssessmentByEncId")
		public ResponseEntity<List<EncAsessmentDTO>> getEncAsessmentByencounterId(@RequestParam("encounterId") Long encounterId) {
		
			List<EncAsessmentDTO> EncAsessmentDTOResp=null;
			try {
			
				EncAsessmentDTOResp = encAsessmentService.getAllEncAssessmentByEncounterId(encounterId);

			} catch (Exception e) {
				LOG.error("Error while retrieving all  PatientAllergy {}",e);
			}
			
			System.out.println("--------------------------- >"+EncAsessmentDTOResp);
			return new ResponseEntity<>(EncAsessmentDTOResp, HttpStatus.OK);
		}
	


	@DeleteMapping("/removeEncAsessmentById")
	public ResponseEntity<Void> removeEncAsessmentById( @RequestParam("encAsessmentId") Long encAsessmentId){
	EncAsessmentDTO encAsessmentDTO = encAsessmentService.retrieveEncAsessmentById(encAsessmentId);

	if(encAsessmentDTO !=null){
	encAsessmentService.deleteById( encAsessmentId);
	HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	
	}

	else{
	HttpHeaders headers= new HttpHeaders();
		    return new ResponseEntity<>(headers, HttpStatus.PRECONDITION_REQUIRED);
	}
	
	}

}











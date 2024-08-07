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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.service.system.SystemsService;
import com.cpa.ehr.service.system.dto.SystemsDTO;

@RestController
@RequestMapping("/api/rest/system")
@CrossOrigin(origins = { "http://localhost:4300" })
public class SystemsWebService {
	private static final Logger LOG = LoggerFactory.getLogger(SystemsWebService.class);
	@Autowired
	private SystemsService sytemService;
	
	@GetMapping("/getListOfSystems")
	public ResponseEntity<List<SystemsDTO>> getListOfSystems() throws SQLException {
		List<SystemsDTO> systemListResp=null;
		try {
		systemListResp = sytemService.retrieveAllSystems();
		}
	 catch (Exception e) {
		LOG.error("Error while retrieving all System List {}",e);
	   }
		return new ResponseEntity<> (systemListResp, HttpStatus.OK); 
	}
	
	@GetMapping("/getSystemInfoById")
	public ResponseEntity<SystemsDTO> getSystemInfoById(@RequestParam("sysCode") String sysCode){
		SystemsDTO sysDetails=sytemService.getSystemCodeDetails(sysCode);
		return new ResponseEntity<>(sysDetails, HttpStatus.OK);
	}
}
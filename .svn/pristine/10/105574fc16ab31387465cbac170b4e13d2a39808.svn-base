
package com.cpa.ehr.web.rest.patients;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cpa.ehr.service.patients.dto.FileDataDTO;

@RestController
@RequestMapping("/api/rest/files")
@CrossOrigin(origins = { "http://localhost:4300" })
public class FileUploadWebService {

	@Value("${spring.config.location}")
	String fileStorageRoot;

	@PostMapping(value="/uploadFile",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<FileDataDTO> uploadFile(@RequestPart("fileData") FileDataDTO fileData, @RequestPart("file") MultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		String strDate= formatter.format(fileData.getSelectedDate());  

		File storageTmp  = new File(fileStorageRoot+fileData.getModType()+"/"+fileData.getPatientId()+"/"+strDate+"/");
		if(!storageTmp.exists())
			storageTmp.mkdirs();

		File destFile = new File(storageTmp,fileName);
		file.transferTo(destFile.getAbsoluteFile());
		fileData.setFileUrl(destFile.getPath());
		return new ResponseEntity<> (fileData, HttpStatus.OK); 
	}

	@GetMapping(value="/getUploadedFiles")
	public ResponseEntity<FileDataDTO> getUploadedFiles(@RequestParam("fileUrl") String fileUrl) throws IOException {
		FileDataDTO fileData = new FileDataDTO();
		Path rootLocation = Paths.get(fileUrl);
		Resource resource = new UrlResource(rootLocation.toAbsolutePath().toUri());

		File uFile = resource.getFile();

		String fileType = FilenameUtils.getExtension(resource.getFilename());
		byte[] contents = FileUtils.readFileToByteArray(new File(fileUrl));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/"+fileType));
		headers.setContentDispositionFormData(uFile.getName(), uFile.getName());
		
		fileData.setFile(contents);
		fileData.setHeaders(headers);
		return new ResponseEntity<>(fileData, HttpStatus.OK);
	}
}

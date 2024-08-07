package com.cpa.ehr.service.patients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cpa.ehr.service.patients.dto.ConsultantNotesDTO;
import com.cpa.ehr.service.patients.dto.LabResultsDTO;

import java.util.List;


public interface ConsultantNotesService {


ConsultantNotesDTO persistConsultantNotes(ConsultantNotesDTO consultantNotesDTOpersist) ;


  ConsultantNotesDTO retrieveConsultantNotesById(Long consultantNotesId);

  List<ConsultantNotesDTO> retrievePatientConsultantNotesById(Long patientId);


	List<ConsultantNotesDTO> retrieveAllConsultantNotes();


	ConsultantNotesDTO modifyConsultantNotes(ConsultantNotesDTO consultantNotesDTOUpdate) ;

	 public void deleteById(Long consultantNotesId);
	}

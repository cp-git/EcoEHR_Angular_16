package com.cpa.ehr.service.patients.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.patients.ConsultantNotesRepository;
import com.cpa.ehr.backend.dao.patients.entities.ConsultantNotes;
import com.cpa.ehr.service.patients.ConsultantNotesService;
import com.cpa.ehr.service.patients.dto.ConsultantNotesDTO;
import com.cpa.ehr.service.patients.dto.mapper.ConsultantNotesMapper;

@Service
public class ConsultantNotesServiceImpl implements ConsultantNotesService {

	private static final Logger LOG = LoggerFactory.getLogger(ConsultantNotesServiceImpl.class);

	@Autowired
	private ConsultantNotesRepository consultantNotesRepository;

	@Autowired
	private ConsultantNotesMapper consultantNotesMapper;

	public ConsultantNotesDTO persistConsultantNotes(ConsultantNotesDTO consultantNotesDTOpersist) {
		try {
			if (consultantNotesDTOpersist != null) {

				ConsultantNotes consultantNotes = consultantNotesMapper
						.convertConsultantNotesDTOToEntity(consultantNotesDTOpersist);
				ConsultantNotes consultantNotesIn = consultantNotesRepository.saveAndFlush(consultantNotes);
				return (consultantNotesIn != null)
						? consultantNotesMapper.convertEntityToConsultantNotesDTO(consultantNotesIn)
						: null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting ConsultantNotes {} ", e);
		}
		return null;
	}

	public ConsultantNotesDTO retrieveConsultantNotesById(Long consultantNotesId) {

//	try {
//		
//			ConsultantNotes consultantNotes = consultantNotesRepository.findById(consultantNotesId).get();
//			return (consultantNotes != null) ?  consultantNotesMapper.convertEntityToConsultantNotesDTO(consultantNotes) :null;
//		}
//		catch (Exception e){
//			LOG.error("Error Message",e);
//		}
		return null;
	}

	public List<ConsultantNotesDTO> retrievePatientConsultantNotesById(Long patientId) {
		try {

			List<ConsultantNotes> consultantNotesList = consultantNotesRepository
					.findPatientConsultantNotesByPatientId(patientId);
			return (consultantNotesList != null)
					? consultantNotesMapper.entityListToConsultantNotesDTOList(consultantNotesList)
					: null;
		} catch (Exception e) {
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

	public List<ConsultantNotesDTO> retrieveAllConsultantNotes() {
		try {
			List<ConsultantNotes> consultantNotesList = consultantNotesRepository.findAll();
			return (consultantNotesList != null)
					? consultantNotesMapper.entityListToConsultantNotesDTOList(consultantNotesList)
					: null;
		} catch (Exception e) {
			LOG.error("Error message", e);
		}
		return Collections.emptyList();

	}

	public ConsultantNotesDTO modifyConsultantNotes(ConsultantNotesDTO consultantNotesDTOUpdate) {
//	try{
//	if(consultantNotesDTOUpdate !=null){
//					ConsultantNotes  consultantNotes = consultantNotesRepository.findById(consultantNotesDTOUpdate.getConsultantNotesId()).get();
//	 ConsultantNotes consultantNotesUpdate =  consultantNotesRepository.save(consultantNotes);
//	return (consultantNotesUpdate !=null) ?  consultantNotesMapper.convertEntityToConsultantNotesDTO(consultantNotesUpdate) : null;
//					
//	}
//}
//	catch (Exception e){
//			LOG.error("Error while updating ConsultantNotes {} ", e);
//		}
		return null;
	}

	public void deleteById(Long consultantNotesId) {

	}

}

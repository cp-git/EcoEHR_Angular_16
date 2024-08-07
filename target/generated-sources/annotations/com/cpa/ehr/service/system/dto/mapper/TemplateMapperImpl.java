package com.cpa.ehr.service.system.dto.mapper;

import com.cpa.ehr.backend.dao.system.entities.Template;
import com.cpa.ehr.service.system.dto.TemplateDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-05T12:37:53+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class TemplateMapperImpl implements TemplateMapper {

    @Override
    public TemplateDTO entityToTemplateDTO(Template entity) {
        if ( entity == null ) {
            return null;
        }

        TemplateDTO templateDTO = new TemplateDTO();

        templateDTO.setIsEdited( entity.getIsEdited() );
        templateDTO.setTemplateId( entity.getTemplateId() );
        templateDTO.setSystemId( entity.getSystemId() );
        templateDTO.setTemplateName( entity.getTemplateName() );
        if ( entity.getTemplateDesc() != null ) {
            byte[] templateDesc = entity.getTemplateDesc();
            templateDTO.setTemplateDesc( Arrays.copyOf( templateDesc, templateDesc.length ) );
        }
        templateDTO.setVersion( entity.getVersion() );
        templateDTO.setCreatedDate( entity.getCreatedDate() );
        templateDTO.setCreatedBy( entity.getCreatedBy() );
        templateDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );
        templateDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );

        templateDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return templateDTO;
    }

    @Override
    public Template templateDTOToEntity(TemplateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Template template = new Template();

        template.setIsEdited( dto.getIsEdited() );
        template.setTemplateId( dto.getTemplateId() );
        template.setSystemId( dto.getSystemId() );
        template.setTemplateName( dto.getTemplateName() );
        if ( dto.getTemplateDesc() != null ) {
            byte[] templateDesc = dto.getTemplateDesc();
            template.setTemplateDesc( Arrays.copyOf( templateDesc, templateDesc.length ) );
        }
        template.setVersion( dto.getVersion() );
        template.setCreatedDate( dto.getCreatedDate() );
        template.setCreatedBy( dto.getCreatedBy() );
        template.setLastUpdatedDate( dto.getLastUpdatedDate() );
        template.setLastUpdatedBy( dto.getLastUpdatedBy() );

        template.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return template;
    }

    @Override
    public List<TemplateDTO> entityListToTemplateDTOList(List<Template> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TemplateDTO> list = new ArrayList<TemplateDTO>();
        for ( Template template : entities ) {
            list.add( entityToTemplateDTO( template ) );
        }

        return list;
    }
}

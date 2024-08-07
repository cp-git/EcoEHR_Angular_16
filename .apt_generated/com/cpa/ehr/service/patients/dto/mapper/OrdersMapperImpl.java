package com.cpa.ehr.service.patients.dto.mapper;

import com.cpa.ehr.backend.dao.patients.entities.Orders;
import com.cpa.ehr.service.patients.dto.OrdersDTO;
import com.cpa.ehr.util.FormatConverterUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T01:39:11+0530",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.13.50.v20171007-0855, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl extends OrdersMapper {

    @Override
    public OrdersDTO convertEntityToOrdersDTO(Orders entity) {
        if ( entity == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setOrderId( entity.getOrderId() );
        ordersDTO.setLabOrderDate( entity.getLabOrderDate() );
        ordersDTO.setLabOrderComments( entity.getLabOrderComments() );
        ordersDTO.setImagingOrderDate( entity.getImagingOrderDate() );
        ordersDTO.setImagingOrderComments( entity.getImagingOrderComments() );
        ordersDTO.setConsultingOrderDate( entity.getConsultingOrderDate() );
        ordersDTO.setConsultingOrderComments( entity.getConsultingOrderComments() );
        ordersDTO.setFollowupOrderDate( entity.getFollowupOrderDate() );
        ordersDTO.setFollowupOrderComments( entity.getFollowupOrderComments() );
        ordersDTO.setConditionComments(entity.getConditionComments());
        ordersDTO.setConditionType(entity.getConditionType());
        ordersDTO.setPatientId( entity.getPatientId() );
        ordersDTO.setEncounterId( entity.getEncounterId() );
        ordersDTO.setIcd10Code( entity.getIcd10Code() );
        ordersDTO.setIcd10CodeDesc(entity.getIcd10CodeDesc());
        ordersDTO.setCreatedBy( entity.getCreatedBy() );
        ordersDTO.setCreatedDate( entity.getCreatedDate() );
        ordersDTO.setLastUpdatedBy( entity.getLastUpdatedBy() );
        ordersDTO.setLastUpdatedDate( entity.getLastUpdatedDate() );

        ordersDTO.setActiveFlag( FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()) );

        return ordersDTO;
    }

    @Override
    public Orders convertOrdersDTOToEntity(OrdersDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( dto.getOrderId() );
        orders.setLabOrderDate( dto.getLabOrderDate() );
        orders.setLabOrderComments( dto.getLabOrderComments() );
        orders.setImagingOrderDate( dto.getImagingOrderDate() );
        orders.setImagingOrderComments( dto.getImagingOrderComments() );
        orders.setConsultingOrderDate( dto.getConsultingOrderDate() );
        orders.setConsultingOrderComments( dto.getConsultingOrderComments() );
        orders.setFollowupOrderDate( dto.getFollowupOrderDate() );
        orders.setFollowupOrderComments( dto.getFollowupOrderComments() );
        orders.setPatientId( dto.getPatientId() );
        orders.setEncounterId( dto.getEncounterId() );
        orders.setIcd10Code( dto.getIcd10Code() );
        orders.setIcd10CodeDesc(dto.getIcd10CodeDesc());
        orders.setCreatedBy( dto.getCreatedBy() );
        orders.setCreatedDate( dto.getCreatedDate() );
        orders.setLastUpdatedBy( dto.getLastUpdatedBy() );
        orders.setLastUpdatedDate( dto.getLastUpdatedDate() );
        orders.setConditionComments(dto.getConditionComments());
        orders.setConditionType(dto.getConditionType());

        orders.setActiveFlag( FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()) );

        return orders;
    }

    @Override
    public List<OrdersDTO> entityListToOrdersDTOList(List<Orders> list) {
        if ( list == null ) {
            return null;
        }

        List<OrdersDTO> list_ = new ArrayList<OrdersDTO>();
        for ( Orders orders : list ) {
            list_.add( convertEntityToOrdersDTO( orders ) );
        }

        return list_;
    }
}

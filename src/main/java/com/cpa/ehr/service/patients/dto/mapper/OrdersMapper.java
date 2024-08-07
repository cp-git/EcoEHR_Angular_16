package com.cpa.ehr.service.patients.dto.mapper;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.cpa.ehr.backend.dao.patients.entities.Orders;
import com.cpa.ehr.service.patients.dto.OrdersDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.ehr.util.FormatConverterUtils.class})
public abstract class OrdersMapper {

	// This will build a fresh new OrdersDTO with in infos
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract  OrdersDTO convertEntityToOrdersDTO(Orders entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract  Orders  convertOrdersDTOToEntity( OrdersDTO dto);



	public abstract List<OrdersDTO>  entityListToOrdersDTOList(List<Orders> list);
}

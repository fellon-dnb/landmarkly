package com.fellon.landmarkly.mappers;

import com.fellon.landmarkly.dtos.TicketInfoDto;
import com.fellon.landmarkly.model.TicketInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketInfoMapper {
    TicketInfoMapper INSTANCE = Mappers.getMapper(TicketInfoMapper.class);

    @Mapping(source = "attraction.id", target = "attractionId")
    TicketInfoDto toDto(TicketInfo ticketInfo);

    // При обратном маппинге поле attraction игнорируем – его установим в сервисе вручную
    @Mapping(target = "attraction", ignore = true)
    TicketInfo toEntity(TicketInfoDto ticketInfoDto);
}

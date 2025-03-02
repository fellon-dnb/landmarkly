package com.fellon.landmarkly.mappers;

import com.fellon.landmarkly.dtos.ServiceDto;
import com.fellon.landmarkly.model.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "id", ignore = true) // ID генерируется БД
    ServiceEntity toEntity(ServiceDto serviceDto);

    ServiceDto toDto(ServiceEntity serviceEntity);

    List<ServiceDto> toDtoList(List<ServiceEntity> services);

    List<ServiceEntity> toEntityList(List<ServiceDto> services);
}

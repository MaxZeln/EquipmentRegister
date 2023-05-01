package ru.testproject.equipmentregister.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.testproject.equipmentregister.dto.BrandDto;
import ru.testproject.equipmentregister.model.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandMapper BRAND_MAPPER = Mappers.getMapper(BrandMapper.class);

    Brand mapFromDto(BrandDto dto);

    BrandDto mapToDto(Brand entity);

    void updateEntityFromDto(BrandDto dto, @MappingTarget Brand entity);
}

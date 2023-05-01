package ru.testproject.equipmentregister.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.testproject.equipmentregister.dto.CategoryCharacteristicDto;
import ru.testproject.equipmentregister.model.CategoryCharacteristic;

@Mapper(componentModel = "spring")
public interface CategoryCharacteristicMapper {

    CategoryCharacteristicMapper CATEGORY_CHARACTERISTIC_MAPPER = Mappers.getMapper(CategoryCharacteristicMapper.class);

    CategoryCharacteristic mapFromDto(CategoryCharacteristicDto dto);

    CategoryCharacteristicDto mapToDto(CategoryCharacteristic entity);

    void updateEntityFromDto(CategoryCharacteristicDto dto, @MappingTarget CategoryCharacteristic entity);

}

package ru.testproject.equipmentregister.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import ru.testproject.equipmentregister.dto.ProductCharacteristicDto;
import ru.testproject.equipmentregister.model.poduct.ProductCharacteristic;

@Mapper(componentModel = "spring")
public interface ProductCharacteristicMapper {

    ProductCharacteristicMapper PRODUCT_CHARACTERISTIC_MAPPER = Mappers.getMapper(ProductCharacteristicMapper.class);

    ProductCharacteristic mapFromDto(ProductCharacteristicDto dto);

    ProductCharacteristicDto mapToDto(ProductCharacteristic entity);

    void updateEntityFromDto(ProductCharacteristicDto dto, @MappingTarget ProductCharacteristic entity);

}

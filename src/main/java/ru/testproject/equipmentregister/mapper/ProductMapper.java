package ru.testproject.equipmentregister.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.testproject.equipmentregister.dto.ProductDto;
import ru.testproject.equipmentregister.model.poduct.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    Product mapFromDto(ProductDto dto);

    ProductDto mapToDto(Product entity);

    void updateEntityFromDto(ProductDto dto, @MappingTarget Product entity);

}

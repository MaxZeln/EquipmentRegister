package ru.testproject.equipmentregister.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.testproject.equipmentregister.dto.CategoryDto;
import ru.testproject.equipmentregister.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    Category mapFromDto(CategoryDto dto);

    CategoryDto mapToDto(Category entity);

    void updateEntityFromDto(CategoryDto dto, @MappingTarget Category entity);

}

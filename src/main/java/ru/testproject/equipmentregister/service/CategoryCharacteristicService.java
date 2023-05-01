package ru.testproject.equipmentregister.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.equipmentregister.dto.CategoryCharacteristicDto;
import ru.testproject.equipmentregister.mapper.CategoryCharacteristicMapper;
import ru.testproject.equipmentregister.model.CategoryCharacteristic;
import ru.testproject.equipmentregister.repository.CategoryCharacteristicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCharacteristicService {

    private final CategoryCharacteristicRepository categoryCharacteristicRepository;

    public CategoryCharacteristicService(CategoryCharacteristicRepository categoryCharacteristicRepository) {
        this.categoryCharacteristicRepository = categoryCharacteristicRepository;
    }

    public List<CategoryCharacteristicDto> findAll() {
        return categoryCharacteristicRepository.findAll().stream()
                .map(CategoryCharacteristicMapper.CATEGORY_CHARACTERISTIC_MAPPER::mapToDto)
                .toList();
    }

    public CategoryCharacteristicDto findById(Long id) {
        Optional<CategoryCharacteristic> categoryCharacteristic = categoryCharacteristicRepository.findById(id);
        if (categoryCharacteristic.isPresent()) {
            return CategoryCharacteristicMapper.CATEGORY_CHARACTERISTIC_MAPPER.mapToDto(categoryCharacteristic.get());
        } else {
            throw new EntityNotFoundException("Category characteristic with id: " + id.intValue() + " not found in DB ");
        }
    }

    @Transactional
    public CategoryCharacteristicDto create(CategoryCharacteristicDto dto) {
        CategoryCharacteristic entity = CategoryCharacteristicMapper.CATEGORY_CHARACTERISTIC_MAPPER.mapFromDto(dto);
        categoryCharacteristicRepository.save(entity);
        return CategoryCharacteristicMapper.CATEGORY_CHARACTERISTIC_MAPPER.mapToDto(entity);
    }

    @Transactional
    public void update(CategoryCharacteristicDto dto) {
        CategoryCharacteristic entity = categoryCharacteristicRepository.getReferenceById(dto.getId());
        CategoryCharacteristicMapper.CATEGORY_CHARACTERISTIC_MAPPER.updateEntityFromDto(dto, entity);
        categoryCharacteristicRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        CategoryCharacteristic entity = categoryCharacteristicRepository.getReferenceById(id);
        categoryCharacteristicRepository.delete(entity);
    }

}

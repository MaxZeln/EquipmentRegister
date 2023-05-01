package ru.testproject.equipmentregister.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.equipmentregister.dto.CategoryDto;
import ru.testproject.equipmentregister.mapper.CategoryMapper;
import ru.testproject.equipmentregister.model.Category;
import ru.testproject.equipmentregister.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        return  categoryRepository.findAll().stream()
                .map(CategoryMapper.CATEGORY_MAPPER::mapToDto)
                .toList();
    }

    public CategoryDto findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return CategoryMapper.CATEGORY_MAPPER.mapToDto(category.get());
        } else {
            throw new EntityNotFoundException("Category with id: " + id.intValue() + " not found in DB ");
        }
    }

    @Transactional
    public CategoryDto create(CategoryDto dto) {
        Category entity = CategoryMapper.CATEGORY_MAPPER.mapFromDto(dto);
        categoryRepository.save(entity);
        return CategoryMapper.CATEGORY_MAPPER.mapToDto(entity);
    }

    @Transactional
    public void update(CategoryDto dto) {
        Category entity = categoryRepository.getReferenceById(dto.getId());
        CategoryMapper.CATEGORY_MAPPER.updateEntityFromDto(dto, entity);
        categoryRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        Category entity = categoryRepository.getReferenceById(id);
        categoryRepository.delete(entity);
    }

}

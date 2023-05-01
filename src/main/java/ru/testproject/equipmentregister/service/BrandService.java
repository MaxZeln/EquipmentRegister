package ru.testproject.equipmentregister.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.equipmentregister.dto.BrandDto;
import ru.testproject.equipmentregister.mapper.BrandMapper;
import ru.testproject.equipmentregister.model.Brand;
import ru.testproject.equipmentregister.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDto> findAll() {
        return brandRepository.findAll().stream()
                .map(BrandMapper.BRAND_MAPPER::mapToDto)
                .toList();
    }

    public BrandDto findById(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            return BrandMapper.BRAND_MAPPER.mapToDto(brand.get());
        } else {
            throw new EntityNotFoundException("Brand with id: " + id.intValue() + " not found in DB ");
        }
    }

    @Transactional
    public BrandDto create(BrandDto dto) {
        Brand entity = BrandMapper.BRAND_MAPPER.mapFromDto(dto);
        brandRepository.save(entity);
        return BrandMapper.BRAND_MAPPER.mapToDto(entity);
    }

    @Transactional
    public void update(BrandDto dto) {
        Brand entity = brandRepository.getReferenceById(dto.getId());
        BrandMapper.BRAND_MAPPER.updateEntityFromDto(dto, entity);
        brandRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        Brand entity = brandRepository.getReferenceById(id);
        brandRepository.delete(entity);
    }

}

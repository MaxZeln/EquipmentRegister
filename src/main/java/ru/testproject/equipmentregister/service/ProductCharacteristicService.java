package ru.testproject.equipmentregister.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.equipmentregister.dto.ProductCharacteristicDto;
import ru.testproject.equipmentregister.mapper.ProductCharacteristicMapper;
import ru.testproject.equipmentregister.model.poduct.ProductCharacteristic;
import ru.testproject.equipmentregister.repository.ProductCharacteristicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCharacteristicService {

    private final ProductCharacteristicRepository productCharacteristicRepository;

    public ProductCharacteristicService(ProductCharacteristicRepository productCharacteristicRepository) {
        this.productCharacteristicRepository = productCharacteristicRepository;
    }

    public List<ProductCharacteristicDto> findAll() {
        return productCharacteristicRepository.findAll().stream()
                .map(ProductCharacteristicMapper.PRODUCT_CHARACTERISTIC_MAPPER::mapToDto)
                .toList();
    }

    public ProductCharacteristicDto findById(Long id) {
        Optional<ProductCharacteristic> brand = productCharacteristicRepository.findById(id);
        if (brand.isPresent()) {
            return ProductCharacteristicMapper.PRODUCT_CHARACTERISTIC_MAPPER.mapToDto(brand.get());
        } else {
            throw new EntityNotFoundException("Product characteristic with id: " + id.intValue() + " not found in DB ");
        }
    }

    @Transactional
    public ProductCharacteristicDto create(ProductCharacteristicDto dto) {
        ProductCharacteristic entity = ProductCharacteristicMapper.PRODUCT_CHARACTERISTIC_MAPPER.mapFromDto(dto);
        productCharacteristicRepository.save(entity);
        return ProductCharacteristicMapper.PRODUCT_CHARACTERISTIC_MAPPER.mapToDto(entity);
    }

    @Transactional
    public void update(ProductCharacteristicDto dto) {
        ProductCharacteristic entity = productCharacteristicRepository.getReferenceById(dto.getId());
        ProductCharacteristicMapper.PRODUCT_CHARACTERISTIC_MAPPER.updateEntityFromDto(dto, entity);
        productCharacteristicRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        ProductCharacteristic entity = productCharacteristicRepository.getReferenceById(id);
        productCharacteristicRepository.delete(entity);
    }

}

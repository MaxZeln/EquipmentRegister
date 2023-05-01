package ru.testproject.equipmentregister.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.equipmentregister.dto.ProductDto;
import ru.testproject.equipmentregister.mapper.ProductMapper;
import ru.testproject.equipmentregister.model.poduct.Product;
import ru.testproject.equipmentregister.repository.CategoryRepository;
import ru.testproject.equipmentregister.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper.PRODUCT_MAPPER::mapToDto)
                .toList();
    }

    public ProductDto findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ProductMapper.PRODUCT_MAPPER.mapToDto(product.get());
        } else {
            throw new EntityNotFoundException("Brand with id: " + id.intValue() + " not found in DB ");
        }
    }
    public ProductDto findByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        if (product.isPresent()) {
            return ProductMapper.PRODUCT_MAPPER.mapToDto(product.get());
        } else {
            throw new EntityNotFoundException("Brand with name: " + name + " not found in DB ");
        }
    }

    @Transactional
    public ProductDto create(ProductDto dto) {
        Product entity = ProductMapper.PRODUCT_MAPPER.mapFromDto(dto);
        productRepository.save(entity);
        return ProductMapper.PRODUCT_MAPPER.mapToDto(entity);
    }

    @Transactional
    public void update(ProductDto dto) {
        Product entity = productRepository.getReferenceById(dto.getId());
        ProductMapper.PRODUCT_MAPPER.updateEntityFromDto(dto, entity);
        productRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        Product entity = productRepository.getReferenceById(id);
        productRepository.delete(entity);
    }

    public List<ProductDto> findAllProductByCategoryId(Long id) {
        return productRepository.findAllByCategoryId(id).stream()
                .map(ProductMapper.PRODUCT_MAPPER::mapToDto)
                .toList();
    }

    public List<ProductDto> findAllProductByName(String productName) {
        return productRepository.findAllByName(productName).stream()
                .map(ProductMapper.PRODUCT_MAPPER::mapToDto)
                .toList();
    }

    public List<ProductDto> findAllProductByColor(String productColor) {
        return productRepository.findAllByColor(productColor).stream()
                .map(ProductMapper.PRODUCT_MAPPER::mapToDto)
                .toList();
    }

    public List<ProductDto> findAllProductByPriceBetween(int start, int end) {
        return productRepository.findAllByPriceBetween(start, end).stream()
                .map(ProductMapper.PRODUCT_MAPPER::mapToDto)
                .toList();
    }

}

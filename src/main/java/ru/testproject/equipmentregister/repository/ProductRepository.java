package ru.testproject.equipmentregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.equipmentregister.model.poduct.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAllByCategoryId(Long categoryId);

    public List<Product> findAllByName(String productName);

    public List<Product> findAllByColor(String productColor);

    public List<Product> findAllByPriceBetween(int start, int end);

    public Optional<Product> findByName(String name);

}

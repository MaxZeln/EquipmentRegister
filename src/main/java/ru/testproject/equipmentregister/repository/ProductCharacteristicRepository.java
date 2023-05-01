package ru.testproject.equipmentregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.equipmentregister.model.poduct.ProductCharacteristic;

@Repository
public interface ProductCharacteristicRepository extends JpaRepository<ProductCharacteristic, Long> {
}

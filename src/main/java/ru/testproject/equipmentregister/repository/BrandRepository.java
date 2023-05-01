package ru.testproject.equipmentregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.equipmentregister.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}

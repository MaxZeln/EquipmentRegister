package ru.testproject.equipmentregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.equipmentregister.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

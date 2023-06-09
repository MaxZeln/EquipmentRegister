package ru.testproject.equipmentregister.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@Schema(description = "Entity of category ")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_categories")
    @SequenceGenerator(name = "global_seq_categories", sequenceName = "global_seq_categories", allocationSize = 1)
    @Schema(description = "Category id in database", example = "20")
    private Long id;

    @Column(name = "category_name", nullable = false)
    @Schema(description = "Name of category", example = "smartphones")
    private String categoryName;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}

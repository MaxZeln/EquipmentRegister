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
@Table(name="category_characteristics")
@Schema(description = "Entity of category characteristic ")
public class CategoryCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_category_characteristic")
    @SequenceGenerator(name = "global_seq_category_characteristic", sequenceName = "global_seq_category_characteristic", allocationSize = 1)
    @Column(name = "id", nullable = false)
    @Schema(description = "category characteristic id in batabase", example = "")
    private Long id;

    @Column(name = "characteristic_name")
    @Schema(description = "characteristic name ", example = "cameras")
    private String characteristicName;

    @Column(name = "category_id", nullable = false)
    @Schema(description = "Id of category for category characteristic", example = "")
    private long categoryId;

    @Override
    public String toString() {
        return "CategoryCharacteristic{" +
                "id=" + id +
                ", characteristicName='" + characteristicName + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

}

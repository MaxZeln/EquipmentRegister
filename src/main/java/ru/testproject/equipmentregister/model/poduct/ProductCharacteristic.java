package ru.testproject.equipmentregister.model.poduct;

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
@Table(name="product_characteristics")
@Schema(description = "Entity of unique characteristic for product ")
public class ProductCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_product_characteristic")
    @SequenceGenerator(name = "global_seq_product_characteristic", sequenceName = "global_seq_product_characteristic", allocationSize = 1)
    @Column(name = "id", nullable = false)
    @Schema(description = "Product characteristic id in batabase", example = "1023")
    private Long id;

    @Column(name = "product_id", nullable = false)
    @Schema(description = "Id of product for product characteristic", example = "1023")
    private long productId;

    @Column(name = "category_id", nullable = false)
    @Schema(description = "Id of category for product characteristic", example = "20")
    private long categoryId;

    @Column(name = "category_characteristic_id", nullable = false)
    @Schema(description = "Id of category characteristic for product characteristic", example = "3")
    private long categoryCharacteristicId;

    @Column(name = "characteristic_value")
    @Schema(description = "value of product characteristic, depends on category and category characteristic o which it belongs ", example = "6")
    private String characteristicValue;

    @Override
    public String toString() {
        return "ProductCharacteristic{" +
                "id=" + id +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", categoryCharacteristicId=" + categoryCharacteristicId +
                ", characteristicValue='" + characteristicValue + '\'' +
                '}';
    }

}

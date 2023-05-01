package ru.testproject.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object of unique characteristic for product ")
public class ProductCharacteristicDto {
    @Schema(description = "Product characteristic id in batabase", example = "1023")
    private Long id;

    @Schema(description = "Id of product for product characteristic", example = "1023")
    private long productId;

    @Schema(description = "Id of category for product characteristic", example = "20")
    private long categoryId;

    @Schema(description = "Id of category characteristic for product characteristic", example = "3")
    private long categoryCharacteristicId;

    @Schema(description = "value of product characteristic, depends on category and category characteristic o which it belongs ", example = "2")
    private String characteristicValue;

    @Override
    public String toString() {
        return "ProductCharacteristicDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", categoryCharacteristicId=" + categoryCharacteristicId +
                ", characteristicValue='" + characteristicValue + '\'' +
                '}';
    }

}

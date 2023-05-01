package ru.testproject.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object of product ")
public class ProductDto {

    @Schema(description = "Product id in batabase", example = "1023")
    private Long id;

    @Schema(description = "Product name", example = "iPhone 13 nano")
    private String name;

    @Schema(description = "Serial number of product", example = "153628")
    private String serialNumber;

    @Schema(description = "Color of product", example = "black")
    private String color;

    @Schema(description = "Size of product", example = "71.5x146.7x7.65 mm")
    private String size;

    @Schema(description = "Price of Product", example = "62890.99")
    private double price;

    @Schema(description = "Availability to buy the product online", example = "true")
    private boolean onlineOrder;

    @Schema(description = "Availability to buy the product in installments", example = "true")
    private boolean installmentPayment;

    @Schema(description = "Availability of product for sale", example = "true")
    private boolean availability;

    @Schema(description = "Id of brand for product", example = "23")
    private long brandId;

    @Schema(description = "Id of category for product", example = "20")
    private long categoryId;

    @Schema(description = "List of unique features for a specific product")
    private List<ProductCharacteristicDto> characteristics = new ArrayList<>();

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", onlineOrder=" + onlineOrder +
                ", installmentPayment=" + installmentPayment +
                ", availability=" + availability +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", characteristics=" + characteristics +
                '}';
    }

}

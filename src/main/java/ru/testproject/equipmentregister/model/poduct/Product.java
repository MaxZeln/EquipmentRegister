package ru.testproject.equipmentregister.model.poduct;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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
@Entity
@Table(name="products")
@Schema(description = "Entity of product ")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_products")
    @SequenceGenerator(name = "global_seq_products", sequenceName = "global_seq_products", allocationSize = 1)
    @Column(name = "id", nullable = false)
    @Schema(description = "Product id in batabase", example = "1023")
    private Long id;

    @Column(name = "product_name", nullable = false)
    @Schema(description = "Product name", example = "iPhone 13 nano")
    private String name;

    @Column(name = "serial_number", nullable = false)
    @Schema(description = "Serial number of product", example = "153628")
    private String serialNumber;

    @Column(name = "color", nullable = false)
    @Schema(description = "Color of product", example = "black")
    private String color;

    @Column(name = "product_size", nullable = false)
    @Schema(description = "Size of product", example = "71.5x146.7x7.65 mm")
    private String size;

    @Column(name = "price", nullable = false)
    @Schema(description = "Price of Product", example = "62890.99")
    private double price;

    @Column(name = "online_order", nullable = false)
    @Schema(description = "Availability to buy the product online", example = "true")
    private boolean onlineOrder;

    @Column(name = "installment_payment", nullable = false)
    @Schema(description = "Availability to buy the product in installments", example = "true")
    private boolean installmentPayment;

    @Column(name = "availability", nullable = false)
    @Schema(description = "Availability of product for sale", example = "true")
    private boolean availability;

    @Column(name = "brand_id", nullable = false)
    @Schema(description = "Id of brand for product", example = "23")
    private long brandId;

    @Column(name = "category_id", nullable = false)
    @Schema(description = "Id of category for product", example = "20")
    private long categoryId;

    @OneToMany(cascade = CascadeType.ALL)
    @Schema(description = "List of unique features for a specific product")
    private List<ProductCharacteristic> characteristics = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
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

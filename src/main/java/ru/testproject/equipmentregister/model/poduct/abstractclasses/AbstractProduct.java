package ru.testproject.equipmentregister.model.poduct.abstractclasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "online_order", nullable = false)
    private boolean onlineOrder;

    @Column(name = "installment_payment", nullable = false)
    private boolean installmentPayment;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "brand_id", nullable = false)
    private long brandId;

    @Column(name = "category_id", nullable = false)
    private long categoryId;

}

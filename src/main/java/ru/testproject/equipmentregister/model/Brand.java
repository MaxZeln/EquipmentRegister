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
@Table(name = "brands")
@Schema(description = "Entity of brand ")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_brands")
    @SequenceGenerator(name = "global_seq_brands", sequenceName = "global_seq_brands", allocationSize = 1)
    @Column(name = "id", nullable = false)
    @Schema(description = "Brand id in batabase", example = "5")
    private Long id;

    @Column(name = "brand_name", nullable = false)
    @Schema(description = "Brand name", example = "Apple")
    private String name;

    @Column(name = "manufacturer_country", nullable = false)
    @Schema(description = "production country", example = "America")
    private String Country;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

}

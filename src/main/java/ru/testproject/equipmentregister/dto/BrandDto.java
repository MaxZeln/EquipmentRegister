package ru.testproject.equipmentregister.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "brands")
@Schema(description = "Data transfer object of brand")
public class BrandDto {

    @Schema(description = "Brand id in batabase", example = "5")
    private Long id;

    @Schema(description = "Brand name", example = "Apple")
    private String name;

    @Schema(description = "production country", example = "America")
    private String manufacturerCountry;

    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturerCountry='" + manufacturerCountry + '\'' +
                '}';
    }

}

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
@Schema(description = "Data transfer object of category characteristic ")
public class CategoryCharacteristicDto {

    @Schema(description = "category characteristic id in batabase", example = "3")
    private Long id;

    @Schema(description = "characteristic name ", example = "cameras")
    private String characteristicName;

    @Schema(description = "Id of category for category characteristic", example = "20")
    private long categoryId;

    @Override
    public String toString() {
        return "CategoryCharacteristicDto{" +
                "id=" + id +
                ", characteristicName='" + characteristicName + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

}

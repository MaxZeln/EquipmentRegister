package ru.testproject.equipmentregister.dto;

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
@Schema(description = "Data transfer object of category ")
public class CategoryDto {

    @Schema(description = "Category id in database", example = "20")
    private Long id;

    @Schema(description = "Name of category", example = "smartphones")
    private String categoryName;

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}

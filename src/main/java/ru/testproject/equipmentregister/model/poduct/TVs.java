package ru.testproject.equipmentregister.model.poduct;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.testproject.equipmentregister.model.poduct.abstractclasses.AbstractProduct;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Entity
@Table(name="tvs")
public class TVs extends AbstractProduct {

    @Column(name = "technology", nullable = false)
    private String technology;

}

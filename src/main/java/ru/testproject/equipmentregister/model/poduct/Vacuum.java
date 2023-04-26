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
@Table(name="vacuums")
public class Vacuum extends AbstractProduct {

    @Column(name = "dust_container_volume", nullable = false)
    private String dustContainerVolume;

    @Column(name = "number_of_modes", nullable = false)
    private Short numberOfModes;

}

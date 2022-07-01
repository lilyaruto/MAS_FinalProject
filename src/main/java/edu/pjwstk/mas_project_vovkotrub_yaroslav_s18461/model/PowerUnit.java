package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class PowerUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Power Unit name cannot be empty value!")
    private String name;

    //Association with Vehicle
    @OneToMany(mappedBy = "powerUnit", fetch = FetchType.LAZY, targetEntity = Vehicle.class)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Vehicle> vehicles = new HashSet<>();
}

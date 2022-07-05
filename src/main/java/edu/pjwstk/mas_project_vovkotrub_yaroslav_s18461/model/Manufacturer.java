package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity that connected with Vehicle using composition,
 * vehicle cannot exist without having manufacturer
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Manufacturer name cannot be empty value!")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Manufacturer country cannot be empty value!")
    private String country;

    @NotBlank(message = "Manufacturer logo cannot be empty value!")
    private String logo;

    //Composition with Vehicle
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, targetEntity = Vehicle.class, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Vehicle> vehicles = new HashSet<>();
}

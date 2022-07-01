package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Address city cannot be empty value!")
    private String city;

    @NotBlank(message = "Address street cannot be empty value!")
    private String street;

    @Min(value = 1, message = "Address minimal number of building is 1!")
    private int building;

    @Min(value = 10000, message = "Address zip value must be 5-digits number!")
    @Max(value = 99999, message = "Address zip value must be 5-digits number!")
    private int zip;

    //Association with Salon
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, targetEntity = Salon.class, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Salon> salons = new HashSet<>();

    //Association with Salon
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, targetEntity = ServiceCentre.class, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ServiceCentre> serviceCentres = new HashSet<>();
}

package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity that represents service centre for vehicles,
 * and making service passport for them
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ServiceCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Service Centre name cannot be empty value!")
    private String name;

    @NotBlank(message = "Service Centre phone number cannot be empty value!")
    private String phoneNumber;

    @Min(value = 1, message = "Service Centre rating cannot be less then 1!")
    @Max(value = 5, message = "Service Centre rating cannot be more then 5!")
    private double rating;

    //Association with Address
    @ManyToOne(targetEntity = Address.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "address_id")
    @EqualsAndHashCode.Exclude
    private Address address;

    //Association with ServicePassport
    @NotNull
    @OneToMany(mappedBy = "serviceCentre", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ServicePassport> passports = new HashSet<>();
}

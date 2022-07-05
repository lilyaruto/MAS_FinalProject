package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception.DataValidationException;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Main entity of the whole system, which is representing vehicle,
 * and its' associations with all other entities
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private static final int minProductionYear = 1930;

    @NotBlank(message = "Model name cannot be empty value!")
    private String modelName;

    @Min(1)
    private int price;

    @Min(minProductionYear)
    private int productionYear;

    @Min(1)
    private int horsepower;

    @Min(0)
    private int kmAge;

    @Builder.Default
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Features_Vehicle", joinColumns = @JoinColumn(name = "Vehicle_Id"))
    private Set<String> features = new HashSet<>();

    //Association with ServicePassport
    @NotNull
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER, optional = false, mappedBy = "vehicle")
    @EqualsAndHashCode.Exclude
    private ServicePassport passport;

    //Composition with Manufacturer
    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Manufacturer.class)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Manufacturer manufacturer;

    //Association with Power Unit
    @ManyToOne(optional = false, targetEntity = PowerUnit.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "powerUnit_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private PowerUnit powerUnit;

    //XOR
    //Association with Owner
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private Owner owner;

    //Association with Salon
    @ManyToOne
    @JoinColumn(name = "salon_id")
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private Salon salon;

    public void setOwner(Owner owner) {
        if (this.owner == owner) {
            return;
        }
        if (owner == null) {
            throw new DataValidationException("Vehicle: owner cannot be empty value!");
        }
        if (this.salon != null) {
            this.salon.getVehicles().remove(this);
            this.salon = null;
        }
        this.owner = owner;
        owner.addVehicle(this);
    }

    public void setSalon(Salon salon) {
        if (this.salon == salon) {
            return;
        }
        if (salon == null) {
            throw new DataValidationException("Vehicle: salon cannot be empty value!");
        }
        if (this.owner != null) {
            this.owner.getVehicles().remove(this);
            this.owner = null;
        }
        this.salon = salon;
        salon.addVehicle(this);
    }

    //Derived attribute
    private String getOldnessRank() {
        float coeficient = ((float)kmAge*7/300000) +
                ((float) (LocalDate.now().getYear() - productionYear)*3/50);
        if (coeficient >= 0f && coeficient <= 3f) {
            return "Low";
        } else if (coeficient > 3f && coeficient <= 7f) {
            return "Medium";
        } else if (coeficient > 7f && coeficient <= 10f) {
            return "High";
        } else {
            return "Extremely high";
        }
    }
}

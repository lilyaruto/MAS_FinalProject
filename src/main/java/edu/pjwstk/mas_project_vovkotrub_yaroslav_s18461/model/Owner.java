package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception.DataValidationException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity that has construction of vehicles' owner,
 * and could be changed with Salon
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Owner name cannot be empty value!")
    private String name;

    @NotBlank(message = "Owner surname cannot be empty value!")
    private String surname;

    @NotBlank(message = "Owner phone number cannot be empty value!")
    private String phoneNumber;

    @NotNull(message = "Owner sex cannot be empty value!")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    //XOR
    //Association with Vehicle
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, targetEntity = Vehicle.class)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Vehicle> vehicles = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new DataValidationException("Owner: vehicle cannot be empty value!");
        }
        if (vehicle.getSalon() != null) {
            throw new DataValidationException("Owner: vehicle is a " + vehicle.getSalon().getName() + " property!");
        }
        if (this.vehicles.contains(vehicle)) {
            return;
        }
        this.vehicles.add(vehicle);
        vehicle.setOwner(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new DataValidationException("Owner: the removal vehicle cannot be null!");
        }
        if (!this.vehicles.contains(vehicle)) {
            return;
        }
        this.vehicles.remove(vehicle);
        vehicle.setOwner(null);
    }

    public boolean hasVehicle(Vehicle v) {
        // TODO: 6/18/2022
        return false;
    }
}

package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception.DataValidationException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity that has construction of vehicles' salon,
 * and could be changed with Owner
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Salon name cannot be empty value!")
    private String name;

    @NotBlank(message = "Salon phone number cannot be empty value!")
    private String phoneNumber;

    @Min(value = 1, message = "Salon rating cannot be less then 1!")
    @Max(value = 5, message = "Salon rating cannot be more then 5!")
    private double rating;

    //Association with Address
    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Address.class)
    @JoinColumn(name = "address_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Address address;

    //XOR
    //Association with Vehicle
    @OneToMany(mappedBy = "salon", fetch = FetchType.LAZY, targetEntity = Vehicle.class)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Vehicle> vehicles = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new DataValidationException("Salon: vehicle cannot be empty value!");
        }
        if (vehicle.getOwner() != null) {
            throw new DataValidationException("Salon: vehicle is property of " + vehicle.getOwner().getName() + " " + vehicle.getOwner().getSurname());
        }
        if (this.vehicles.contains(vehicle)) {
            return;
        }
        this.vehicles.add(vehicle);
        vehicle.setSalon(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new DataValidationException("Salon: the removal vehicle cannot be null!");
        }
        if (!this.vehicles.contains(vehicle)) {
            return;
        }
        this.vehicles.remove(vehicle);
        vehicle.setSalon(null);
    }

    public boolean hasVehicle(Vehicle v) {
        // TODO: 6/18/2022
        return false;
    }
}

package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

/**
 * Entity representing a "child" class for PowerUnit, construction of batteries for vehicles
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Battery extends PowerUnit implements IBattery{

    @Min(value = 1, message = "Battery capacity cannot be zero or negative value!")
    private int batteryCapacity;

    @Min(value = 1, message = "Battery power cannot be zero or negative value!")
    private int batteryPower;
}

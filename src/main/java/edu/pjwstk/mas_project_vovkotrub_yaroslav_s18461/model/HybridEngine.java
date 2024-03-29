package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

/**
 * Entity representing a Hybrid Engine that is an Engine and a Battery at the same time
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class HybridEngine extends Engine implements IBattery{

    @Min(value = 1, message = "Battery capacity cannot be zero or negative value!")
    private int batteryCapacity;

    @Min(value = 1, message = "Battery power cannot be zero or negative value!")
    private int batteryPower;

    @Min(1)
    private int maxBatteryPower;
}
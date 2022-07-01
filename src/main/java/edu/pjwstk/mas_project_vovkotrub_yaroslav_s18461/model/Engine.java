package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception.DataValidationException;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Engine extends PowerUnit{

    @Setter(AccessLevel.NONE)
    private double capacity;

    @Min(value = 1, message = "Engine power cannot be zero or negative value!")
    private int enginePower;

    public void setCapacity(double capacity) {
        if (capacity < 0.5) {
            throw new DataValidationException("Engine capacity cannot be less than 0.5L!");
        }
        this.capacity = capacity;
    }
}

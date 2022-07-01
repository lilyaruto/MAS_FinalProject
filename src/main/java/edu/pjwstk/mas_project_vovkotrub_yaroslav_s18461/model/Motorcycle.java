package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.exception.DataValidationException;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Motorcycle extends Vehicle{

    @Setter(AccessLevel.NONE)
    private double swingarmLength;

    public void setSwingarmLength(double swingarmLength) {
        if (swingarmLength < 0.1 || swingarmLength > 0.9) {
            throw new DataValidationException("Motorcycle swingarm value must be between 0.1 and 0.9!");
        }
        this.swingarmLength = swingarmLength;
    }
}

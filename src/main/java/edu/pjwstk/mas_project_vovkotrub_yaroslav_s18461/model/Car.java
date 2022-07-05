package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Entity representing a "child" class for Vehicle,
 * construction that gives an opportunity to create car, type of vehicle
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Car extends Vehicle{

    @NotNull(message = "Car body type value cannot be empty value!")
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
}

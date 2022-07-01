package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints =
    @UniqueConstraint(columnNames = {"service_centre_id", "vehicle_id"}))
public class ServicePassport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Service Passport date cannot be empty value!")
    private LocalDate date;

    @NotNull(message = "Service Passport service type cannot be empty value!")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    
    public LocalDate endDate() {
        return LocalDate.of(date.getYear() + 2,
                date.getMonth(),
                date.getDayOfMonth());
    }

    //Association with ServiceCentre
    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_centre_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private ServiceCentre serviceCentre;

    //Association with Vehicle
    @NotNull
    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Vehicle vehicle;
    
    public void createPassport() {
        // TODO: 6/18/2022
    }
}

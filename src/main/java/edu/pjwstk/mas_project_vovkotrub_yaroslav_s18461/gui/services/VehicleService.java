package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to fetch data from construction repository
 */
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    /**
     * gets list of vehicles in salon
     * @param salon
     * @return list of vehicles which stored in certain salon
     */
    public List<Vehicle> getBySalon(Salon salon) {
        return vehicleRepository.findBySalon(salon);
    }

    /**
     * Using VehicleRepository to get a list of all vehicles
     * @return list of all vehicles
     */
    public List<Vehicle> getAllVehicles() {
        Iterable<Vehicle> all = vehicleRepository.findAll();
        List<Vehicle> vehicleList = new ArrayList<>();
        all.forEach(vehicleList::add);
        return vehicleList;
    }
}

package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to fetch data from construction repository
 */
@Service
@RequiredArgsConstructor
public class SalonService {
    private final SalonRepository salonRepository;

    /**
     * Using SalonRepository to get a list of all salons
     * @return list of all salons
     */
    public List<Salon> getAllSalons() {
        Iterable<Salon> all = salonRepository.findAll();
        List<Salon> salonsList = new ArrayList<>();
        all.forEach(salonsList::add);
        return salonsList;
    }
}

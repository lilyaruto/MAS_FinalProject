package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonService {
    private final SalonRepository salonRepository;

    public List<Salon> getAllSalons() {
        Iterable<Salon> all = salonRepository.findAll();
        List<Salon> salonsList = new ArrayList<>();
        all.forEach(salonsList::add);
        return salonsList;
    }
}

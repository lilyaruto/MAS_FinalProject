package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalonRepository extends CrudRepository<Salon, Long> {

    public List<Salon> findAll();

    public List<Salon> findByName(String name);

    public List<Salon> findByRating(double rating);
}

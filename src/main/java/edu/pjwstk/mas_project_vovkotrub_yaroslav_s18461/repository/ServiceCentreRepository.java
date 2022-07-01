package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.ServiceCentre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceCentreRepository extends CrudRepository<ServiceCentre, Long> {

    public List<ServiceCentre> findAll();

    public List<ServiceCentre> findByName(String name);

    public List<ServiceCentre> findByRating(double rating);
}

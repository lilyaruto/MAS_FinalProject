package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

    public List<Manufacturer> findAll();

    public List<Manufacturer> findByName(String name);
}

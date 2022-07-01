package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.PowerUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PowerUnitRepository extends CrudRepository<PowerUnit, Long> {

    public List<PowerUnit> findAll();

    public List<PowerUnit> findByName(String name);
}

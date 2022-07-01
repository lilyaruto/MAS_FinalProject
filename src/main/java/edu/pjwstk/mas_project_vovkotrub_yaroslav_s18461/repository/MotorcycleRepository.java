package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Motorcycle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MotorcycleRepository extends CrudRepository<Motorcycle, Long> {

    public List<Motorcycle> findBySwingarmLength(double swingarmLength);
}

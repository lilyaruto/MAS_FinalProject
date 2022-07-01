package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.BodyType;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    public List<Car> findByBodyType(BodyType bodyType);
}

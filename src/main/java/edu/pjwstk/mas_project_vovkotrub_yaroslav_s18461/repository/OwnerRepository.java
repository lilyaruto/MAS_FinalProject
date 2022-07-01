package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.repository;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public List<Owner> findAll();

    public List<Owner> findBySurname(String surname);
}

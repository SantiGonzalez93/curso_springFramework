package santi.sprigboot_course.jpa_relationships.repository;

import org.springframework.data.repository.CrudRepository;
import santi.sprigboot_course.jpa_relationships.entity.Client;


public interface ClienteRepository extends CrudRepository<Client,Long> {


}

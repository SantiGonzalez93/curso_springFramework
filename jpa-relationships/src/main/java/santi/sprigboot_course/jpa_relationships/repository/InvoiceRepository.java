package santi.sprigboot_course.jpa_relationships.repository;

import org.springframework.data.repository.CrudRepository;
import santi.sprigboot_course.jpa_relationships.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {


}

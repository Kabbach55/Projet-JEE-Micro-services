package ma.emsi.Customerservice.repositories;

import ma.emsi.Customerservice.entities.Customer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

package ma.emsi.Billingservice.repositories;
import ma.emsi.Billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface BillRepository extends JpaRepository<Bill,Long> {}

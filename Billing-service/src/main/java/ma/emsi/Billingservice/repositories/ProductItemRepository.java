package ma.emsi.Billingservice.repositories;

import ma.emsi.Billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
     Collection<ProductItem> findByBillId(Long id);

}
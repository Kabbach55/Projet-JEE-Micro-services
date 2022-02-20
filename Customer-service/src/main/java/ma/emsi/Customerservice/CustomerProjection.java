package ma.emsi.Customerservice;


import ma.emsi.Customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;


@Projection(name = "fullCustomer",types =
        Customer.class)
public interface CustomerProjection extends Projection {
    public Long getId();
    public String getName();
    public String getEmail();
}

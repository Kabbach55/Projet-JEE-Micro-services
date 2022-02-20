package ma.emsi.Billingservice;


import ma.emsi.Billingservice.entities.Bill;
import ma.emsi.Billingservice.entities.ProductItem;
import ma.emsi.Billingservice.feign.CustomerServiceClient;
import ma.emsi.Billingservice.feign.InventoryServiceClient;
import ma.emsi.Billingservice.model.Customer;
import ma.emsi.Billingservice.model.Product;
import ma.emsi.Billingservice.repositories.BillRepository;
import ma.emsi.Billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.Random;
@CrossOrigin("*")
@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			BillRepository billRepository,
			ProductItemRepository productItemRepository,
			CustomerServiceClient customerServiceClient,
			InventoryServiceClient inventoryServiceClient
	){
		return args -> {
			Customer customer=customerServiceClient.findCustomerById(1L);
			Bill bill1=billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
			PagedModel<Product> productPagedModel=inventoryServiceClient.findAll();
			productPagedModel.forEach(p -> {
				ProductItem productItem = new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(1+new Random().nextInt(100));
				productItem.setBill(bill1);
				productItem.setProductID(p.getId());
				productItemRepository.save(productItem);
			});


		};
	}
}

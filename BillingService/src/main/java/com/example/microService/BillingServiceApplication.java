package com.example.microService;

import com.example.microService.Service.CustomerRepository;
import com.example.microService.entities.Bill;
import com.example.microService.entities.ProductItem;
import com.example.microService.feign.CustomerRestClient;
import com.example.microService.feign.ProductItemRestClient;
import com.example.microService.model.Customer;
import com.example.microService.model.Product;
import com.example.microService.repository.BillRepository;
import com.example.microService.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

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
            CustomerRestClient customerRestClient,
            ProductItemRestClient productItemRestClient
          ){
        return args -> {
            Customer customer= customerRestClient.getCustomerById(1L) ;
            Bill bill=billRepository.save(new Bill(null,new Date(),null, customer.getId(), customer));
            PagedModel<Product> productPagedModel=productItemRestClient.pageProducts();
            productPagedModel.forEach(p->{
                ProductItem productItem=new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill);
                productItemRepository.save(productItem);

            });


            System.out.println("-----------------------");

        };
    }

}


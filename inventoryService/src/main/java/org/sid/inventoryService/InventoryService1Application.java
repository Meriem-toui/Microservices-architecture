package org.sid.inventoryService;

import org.sid.inventoryService.entities.Product;
import org.sid.inventoryService.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication

public class InventoryService1Application {

    public static void main(String[] args) {

        SpringApplication.run(InventoryService1Application.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository,  RepositoryRestConfiguration restConfiguration ) {
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null, "Ordinateur", 23412, 234));
            productRepository.save(new Product(null, "PC ", 2342, 34243));
            productRepository.save(new Product(null, "telephone", 12334, 31123));
            productRepository.findAll().forEach(product -> {
                System.out.println((product.toString()));
            });


        };
    }

}

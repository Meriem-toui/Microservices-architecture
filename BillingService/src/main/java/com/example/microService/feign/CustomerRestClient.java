package com.example.microService.feign;

import com.example.microService.model.Customer;
import com.example.microService.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Customer-SERVICE")
public interface CustomerRestClient {
  @GetMapping(path = "/Customers")
    PagedModel<Customer> pageCustomer(@RequestParam(value = "page")int page,
                                     @RequestParam(value = "size")int size );
  @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable (name = "id") Long id);

}

package com.example.microService.web;

import com.example.microService.entities.Bill;
import com.example.microService.feign.CustomerRestClient;
import com.example.microService.feign.ProductItemRestClient;
import com.example.microService.model.Customer;
import com.example.microService.model.Product;
import com.example.microService.repository.BillRepository;
import com.example.microService.repository.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository,
                                 ProductItemRepository productItemRepository,
                                  CustomerRestClient customerRestClient,
                                 ProductItemRestClient productItemRestClient
                                ) {
        this.customerRestClient = customerRestClient;
        this.billRepository=billRepository;
        this.productItemRepository=productItemRepository;
        this.productItemRestClient=productItemRestClient;
    }


    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill=billRepository.findById(id).get();
       Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
       bill.setCustomer(customer);
       bill.getProductItems().forEach(pi->{
           Product product=productItemRestClient.getProductById(pi.getProductID());
       });

        return  bill;
   }
}

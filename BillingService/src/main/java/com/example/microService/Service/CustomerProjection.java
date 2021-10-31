package com.example.microService.Service;

import com.example.microService.model.Customer;
import org.hibernate.criterion.Projection;

@org.springframework.data.rest.core.config.Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerProjection extends Projection {
    public Long getId();

    public String getName();

    public String getEmail();
}

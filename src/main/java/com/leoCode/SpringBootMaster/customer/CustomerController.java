package com.leoCode.SpringBootMaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

}

/*  BEFORE DEPENDENCY INJECTION
    private final CustomerService customerService;
    public CustomerController() {
        customerService = new CustomerService();
    }
    This causes issues when we want to test because we are instantiating
    the CustomerService. To solve this issue we use dependency injection
    such as above.

    @Autowired: It is optional, but it tells the Spring application that
    we want to inject the object in this case the CustomerService.
*/
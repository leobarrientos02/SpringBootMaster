package com.leoCode.SpringBootMaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

    public Customer getCustomer(Long id){
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer not found"));
    }
}

/*
    We can use @Component to create a bean to inject in multiple places
    and making it a singleton object.

    We use the @Qualifier annotation to tell the Spring application to look
    for a bean with the name specified in this case "fake", which is the
    CustomerFakeRepository. Without the @Qualifier annotation it would
    search for the correct bean.

    @Autowired
    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
*/

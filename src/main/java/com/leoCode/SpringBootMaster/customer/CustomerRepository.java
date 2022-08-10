package com.leoCode.SpringBootMaster.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        // TODO connect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db")
        );
    }
}

/*
    The @Primary annotation is used to tell the Spring application
    that this class would be the primary bean.
 */

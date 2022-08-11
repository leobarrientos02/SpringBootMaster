package com.leoCode.SpringBootMaster.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123", "email@gmail.com"),
                new Customer(2L, "Leonel Barrientos", "password123", "email@gmail.com")
        );
    }
}
/*
    We can add a value within the parenthesis in the @Repository
    annotation to set a name to the bean.
 */
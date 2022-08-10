package com.leoCode.SpringBootMaster.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond"),
                new Customer(2L, "Leonel Barrientos")
        );
    }
}

/*
    We can add a value within the parenthesis in the @Component
    annotation to set a name to the bean.
 */
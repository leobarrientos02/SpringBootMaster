package com.leoCode.SpringBootMaster.customer;

import com.leoCode.SpringBootMaster.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customers")
public class CustomerControllerV2 {

    private final CustomerService customerService;
    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomer(@PathVariable("customerId") Long id){
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomerException(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST");
        System.out.println(customer);
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
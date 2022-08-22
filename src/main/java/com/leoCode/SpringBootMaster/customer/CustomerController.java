package com.leoCode.SpringBootMaster.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
@AllArgsConstructor
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }
    @PostMapping
    public void createNewCustomer(@Valid @RequestBody Customer customer){
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

    We can use the @Deprecated annotation to tell the Spring application
    that the controller is no longer supported.

    We can use the @Valid annotation to ensure the request body is in the
    format we want it to be.

    Using Lombok allows us to use the @AllArgsConstructor annotation
    to remove the all args constructor from the class in which lombok
    would generate one for us.
*/
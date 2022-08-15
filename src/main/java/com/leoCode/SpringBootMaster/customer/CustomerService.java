package com.leoCode.SpringBootMaster.customer;

import com.leoCode.SpringBootMaster.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException(
                                "customer with id " + id + " not found"
                        )
                );
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

    We can configure the application.properties files to display error
    messages to the client by adding,
        server.error.include-message=always
        server.error.include-binding-errors=always
        server.error.include-stacktrace=on_param
    to on_param tells us that we can specify in the url to display the
    stacktrace by adding '?trace=true' to the url.

    ** Easy way to find a customer by id without SpringDataJPA
    public Customer getCustomer(Long id){
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new NotFoundException(
                                "Customer with id "+ id + " does not exist."));
    }
*/

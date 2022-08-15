package com.leoCode.SpringBootMaster.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(){
            return args -> {
                System.out.println("Command line runner hooray");
            };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}

/*
    CommandLineRunner is class specific to Spring, this is used when
    we want to do a setup when the application starts. With the use of
    the @Bean annotation we tell the Spring application to instantiate
    the method which means the code would be executed.

    @Configuration annotation is used to wire everything up.

    @Value("${app.useFakeCustomerRepo:false}")
    This is used to tell the program to check for arguments on
    configuration. This allows us to switch between the CustomerRepository
    and the CustomerFakeRepository by easily changing the program
    arguments.
 */

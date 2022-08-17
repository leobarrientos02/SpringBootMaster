package com.leoCode.SpringBootMaster.customer;

import com.leoCode.SpringBootMaster.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.app.name}")
    private String appName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
            return args -> {
                System.out.println("Command line runner hooray");
                System.out.println(appName);
                System.out.println(environment.getProperty("info.app.description"));
                System.out.println(infoApp);
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

    We can use @Value to extract data from the application.properties file
    ex: @Value("${info.company.name}") ** we add the key we want in the parenthesis
        private String companyName;

    Another way we can extract data from the application.properties file is by using
    the Environment class with the getProperty method.
    ex: @Autowired
        private Environment environment;
        System.out.println(environment.getProperty("info.app.description"));
 */

package com.leoCode.SpringBootMaster.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void itShouldGetCustomers() {
        // Given
        Customer jamila = new Customer(
                1L,
                "jamila",
                "test",
                "jamila@gmail.com"
                );
        Customer leo = new Customer(
                2L,
                "leo",
                "test",
                "leo@gmail.com"
        );

        customerRepository.saveAll(Arrays.asList(jamila, leo));

        // When
        List<Customer> customers = underTest.getCustomers();

        // Then
        assertEquals(2, customers.size());
    }

    @Test
    void itShouldGetCustomer() {
        // Given
        Customer leo = new Customer(
                1L,
                "leo",
                "test",
                "leo@gmail.com"
        );

        customerRepository.save(leo);

        // When
        Customer expected = underTest.getCustomer(1L);

        // Then
        assertEquals(leo, expected);
    }
}
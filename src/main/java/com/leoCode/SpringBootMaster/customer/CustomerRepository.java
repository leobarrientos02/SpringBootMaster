package com.leoCode.SpringBootMaster.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

/*
    The @Primary annotation is used to tell the Spring application
    that this class would be the primary bean.
 */

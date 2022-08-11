package com.leoCode.SpringBootMaster.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private final Long id;
    private final String name;

    private final String password;

    Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Long getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
/*
    Jackson is a powerful JSON parser library that allows to work with
    JSON objects in Java. It uses the getter methods in the class to
    return data, for example it would use the getId method to display
    the id, but we can add additional getter methods such as,
        public getCustomerId(){
            return id;
        }
    and it would return a new line in the JSON object titled CustomerId.

    The @JsonIgnore annotation can be used to ignore a method from showing up
    in the JSON object.

    The @JsonProperty annotation can be used to change the name of the key
    in the JSON object.
 */
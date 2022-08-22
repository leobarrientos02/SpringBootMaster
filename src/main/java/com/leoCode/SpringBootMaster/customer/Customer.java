package com.leoCode.SpringBootMaster.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private Long id;
    @NotBlank(message = "please provide a name")
    private String name;
    @NotBlank(message = "please provide a password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "please provide an email")
    @Email
    private String email;

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
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

    If you are using @JsonIgnore on a getter method then you can use
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) on the variable that
    haves its getter method ignored. This is great for hiding information that
    we do not want to pass in the JSON object such as a user's password.

    We can use @NotNull and @NotBlank to ensure specific data gets passed
    in the json request body. These only work when we use the @Valid
    annotation on the request body.

    We can use the @Email annotation to perform email validation very
    easily. You can also add regex expression within it to customize
    your email validation form.
 */
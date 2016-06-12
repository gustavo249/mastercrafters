package com.mastercrafters.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Author:      Covaciu;
 * Date:        09/06/2016;
 * <p>
 * HAPPY CODING!
 */
@Entity
public class User extends BaseEntity {

    @NotNull
    @Size(min = 5, max = 20, message = "username must be between 5 and 20 characters")
    private String username;

    @NotNull
    //@Size(min = 5, max = 100, message = "password must be between 5 and 20 characters")
    private String password;

    @NotNull
    @Size(min = 5, max = 20, message = "email must be between 5 and 20 characters")
//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@\"\n" +
//            "+\"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "email must contain an @ sign")
    private String email;

    @NotNull
    //@Size(min = 5, max = 20, message = "name must be between 5 and 20 characters")
    private String firstName;

    @NotNull
    //@Size(min = 5, max = 20, message = "name must be between 5 and 20 characters")
    private String lastName;


    @NotNull
    @Size(min=10, max = 10, message = "Phone number must have 10 characters")
    private String telephone;

    @NotNull
    //@Size(min = 5, max = 20)
    private String address;

    @NotNull
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.mastercrafters.model.accounts;

import com.mastercrafters.model.BaseEntity;

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
    @Size(min = 5, max = 20, message = "password must be between 5 and 20 characters")
    private String password;

    @NotNull
    @Size(min = 5, max = 20, message = "email must be between 5 and 20 characters")
//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@\"\n" +
//            "+\"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "email must contain an @ sign")
    private String email;

    @NotNull
    @Size(min = 5, max = 20, message = "name must be between 5 and 20 characters")
    private String firstName;

    @NotNull
    @Size(min = 5, max = 20, message = "name must be between 5 and 20 characters")
    private String lastName;


    @NotNull
    @Size(min=10, max = 10, message = "Phone number must have 10 characters")
    private String telephone;

    @NotNull
    private String type;

}

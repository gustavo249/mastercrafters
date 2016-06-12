package com.mastercrafters.controllers;

import com.mastercrafters.model.User;
import com.mastercrafters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Gustavo on 11/06/2016.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    /**
     * After all the field from the registration are filled and the submit button is clicked this
     * method takes over and processes the user object from the model
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) { //if some fields are incorrect we return to the registration

            System.err.println("Filed errors");
            return "register";
        } else { //TODO insert the new user into the database ---------
            service.create(user);
            System.out.println(user);
            System.out.println("Filled correctly");
        }
        return "redirect::login"; //if everything went fine we redirect the new user to the login page
    }

    /**
     * This is very important before we go to the registration page we have to create an empty user object
     * and add it to the model in order to be filled with values from the registration form
     * This method takes over when the client pressed register a new account button from the homepage
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    public void setService(UserService service) {
        this.service = service;
    }
}

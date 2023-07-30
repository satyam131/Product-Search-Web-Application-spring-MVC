package com.nagarro.javaAdvance.assignment4.controller;

import com.nagarro.javaAdvance.assignment4.dao.UserDao;
import com.nagarro.javaAdvance.assignment4.model.LoginDetails;
import com.nagarro.javaAdvance.assignment4.model.User;
import com.nagarro.javaAdvance.assignment4.util.AppContextUtil;

import jakarta.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/**
 * This is a Java class implementing a controller for a login functionality in a web application
 * using Spring MVC framework, this controller handles the login functionality in a web application by validating
 * the user's login details, retrieving the user's information from the database, and checking if the provided password
 * matches the hashed password stored in the database. If the login is successful, it adds the user object to the session 
 * and redirects to the search page.
 *
 */
@Controller
@SessionAttributes("loginedUser")
public class LoginController {
	/**
	 * The getLogin() method maps to the GET request of the URL "/login" 
	 * @return new instance of ModelAndView class with the view name "login"
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }
    
    /**
     * The getLoginRedirect() method maps to the GET request of the URL "/"
     * @return redirects to the login page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginRedirect() {
        return "redirect:login";
    }
    
    /**
     * The provideLogin() method maps to the POST request of the URL "/login".This method validates the LoginDetails
     * object using the @Valid annotation and adds any errors to the BindingResult object. 
     * @param loginDetails receives the user's login details as a LoginDetails object
     * @param result receives a BindingResult object which holds the errors if there are any validation errors
     * @return instance of ModelAndView class
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView provideLogin(@Valid @ModelAttribute("loginDetails") LoginDetails loginDetails, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (result.hasErrors()) {
            return modelAndView;
        }

        UserDao obj = (UserDao) AppContextUtil.context.getBean("userDao");
        User user = obj.getUser(loginDetails.getUserId());
        
        if (user == null) {
            ObjectError error = new ObjectError("loginError", "No such User Exists");
            result.addError(error);
            modelAndView.addObject("InvalidationMsg", "No such User Exists");
            return modelAndView;
        } else if (!BCrypt.checkpw(loginDetails.getPass(), user.getPass())) {
            ObjectError error = new ObjectError("loginError", "Password is incorrect");
            result.addError(error);
            modelAndView.addObject("InvalidationMsg", "Password is incorrect");
            return modelAndView;
        }

        modelAndView = new ModelAndView("redirect:tshirtSearch");
        modelAndView.addObject("loginedUser", user);
        return modelAndView;
    }
}

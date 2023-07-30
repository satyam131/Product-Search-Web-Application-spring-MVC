package com.nagarro.javaAdvance.assignment4.controller;

import com.nagarro.javaAdvance.assignment4.model.Tshirt;
import com.nagarro.javaAdvance.assignment4.model.TshirtDetailsEntered;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import java.util.List;
/**
 * This is a Java class named TshirtSearchController. It is a Spring MVC controller that handles requests related
 * to searching for T-shirts.
 *
 */
@Controller
public class TshirtSearchController {
	/**
	 * This method handles GET requests to /tshirtSearch  
	 * It is used to display the T-shirt search form
	 * @return new ModelAndView object with the view name tshirtSearch
	 */
    @RequestMapping(value = "/tshirtSearch", method = RequestMethod.GET)
    public ModelAndView getTshirtSearch() {
        return new ModelAndView("tshirtSearch");
    }
    
    /**
     * 
     * @param tshirtDetails is an object of TshirtDetailsEntered as a model attribute
     * @param result is an object of BindingResult
     * @return the instance of modelAndView 
     */
    @RequestMapping(value = "/tshirtSearch", method = RequestMethod.POST)
    public ModelAndView tshirtSearch(
            @Valid @ModelAttribute("tshirtDetails") TshirtDetailsEntered tshirtDetails, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("tshirtSearch");
        if (result.hasErrors()) {
            System.err.println(result);
            return modelAndView;
        }
        // listofMatchingTshirts stores the matching content of Tshirts using getListOfMatchingTshirts()
        List<Tshirt> listOfMatchingTshirts = tshirtDetails.getListOfMatchingTshirts();
        modelAndView = new ModelAndView("tshirtList");
        modelAndView.addObject("list", listOfMatchingTshirts);
        return modelAndView;
    }
}

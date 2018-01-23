package com.baeldung.springbootdispatcherservlet.controllers;

import com.baeldung.springbootdispatcherservlet.domain.Example;
import com.baeldung.springbootdispatcherservlet.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/controller")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    /** Model */
    @RequestMapping(value = "/exampleone", method = RequestMethod.GET)
    public String exampleOne(Model model, @RequestParam(value = "text") String yourText) {
        model.addAttribute("yourText", yourText);
        return "ExampleOne";
    }

    /** JSP */
    @RequestMapping(value = "/exampletwo", method = RequestMethod.GET)
    public void exampleTwo(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "text") String name) {
        try {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/WEB-INF/jsp/ExampleTwo.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    /** ModelMap */
    @GetMapping("/examplethree")
    public String exampleThree(ModelMap model, @RequestParam(value = "text") String hey) {
        model.addAttribute("hey", hey);
        return "ExampleThree";
    }

    /** JSON */
    @RequestMapping(value = "/examplefour", method = RequestMethod.GET)
    @ResponseBody
    public Example exampleFour() {
        return exampleService.fetchExample();
    }
}


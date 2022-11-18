package com.example.demo_orm.controller;

import com.example.demo_orm.model.Customer;
import com.example.demo_orm.repository.CustomerHibernate;
import com.example.demo_orm.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    //tiêm service thông qua interface
    @Autowired
    private ICRUDService icrudService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAll() {
        List<Customer> customers = icrudService.findAll();
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}

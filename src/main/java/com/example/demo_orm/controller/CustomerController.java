package com.example.demo_orm.controller;

import com.example.demo_orm.model.Customer;
import com.example.demo_orm.repository.CustomerHibernate;
import com.example.demo_orm.repository.ICustomerRepository;
import com.example.demo_orm.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    //tiêm service thông qua interface
    @Autowired
    private ICRUDService icrudService;

    @Autowired
    private ICustomerRepository customerRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAll() {
        //sử dụng hibernate + HQL
//        List<Customer> customers = icrudService.findAll();
        //sử dụng JPQ
        Iterable<Customer> customers = customerRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable("id") int id) {
        //sử dụng hibernate + HQL
//        Customer customer = icrudService.findById(id);
        //sử dụng JPA
        Optional<Customer> customer = customerRepository.findById(Long.parseLong(String.valueOf(id)));
        ModelAndView modelAndView = new ModelAndView("display1");
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView creatForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String creatFormPost(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:http://localhost:8080";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("id") int id) {
//        Customer customer = icrudService.findById(id);
        Optional<Customer> customer = customerRepository.findById(Long.parseLong(String.valueOf(id)));
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateFormPost(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:http://localhost:8080";
    }
}

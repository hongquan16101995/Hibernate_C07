package com.example.demo_orm.service.impl;

import com.example.demo_orm.model.Customer;
import com.example.demo_orm.repository.CustomerHibernate;
import com.example.demo_orm.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICRUDService {
    @Autowired
    private CustomerHibernate customerHibernate;

    @Override
    public List<Customer> findAll() {
        return customerHibernate.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerHibernate.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerHibernate.create(customer);
    }
}

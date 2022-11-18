package com.example.demo_orm.service;

import com.example.demo_orm.model.Customer;

import java.util.List;

public interface ICRUDService {
    List<Customer> findAll();
}

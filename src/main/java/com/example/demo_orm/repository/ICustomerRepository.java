package com.example.demo_orm.repository;

import com.example.demo_orm.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    //tìm hiểu về các phương thức có thể tạo trong JPA
    List<Customer> findAllByNameContaining(String name);
    //tìm hiểu về khái niệm sử dụng Native Query trong JPA
}

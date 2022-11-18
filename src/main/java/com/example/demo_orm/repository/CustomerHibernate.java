package com.example.demo_orm.repository;

import com.example.demo_orm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//annotation Service: quy định đây là bean Service, dùng để tiêm phụ thuộc
//@Service
public class CustomerHibernate {
    //annotation đại diện cho tiêm phụ thuộc: Autoriwed
    @Autowired
    private EntityManager entityManager;

    public List<Customer> findAll() {
        String hql = "select c from Customer c";
        TypedQuery<Customer> typedQuery = entityManager.createQuery(hql, Customer.class);
        return typedQuery.getResultList();
    }
}

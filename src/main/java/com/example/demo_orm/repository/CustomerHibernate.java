package com.example.demo_orm.repository;

import com.example.demo_orm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//annotation Service: quy định đây là bean Service, dùng để tiêm phụ thuộc
//@Service
@Transactional
public class CustomerHibernate {
    //annotation đại diện cho tiêm phụ thuộc: Autoriwed
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAll() {
        String hql = "select c from Customer c";
        TypedQuery<Customer> typedQuery = entityManager.createQuery(hql, Customer.class);
        return typedQuery.getResultList();
    }

//    public void save(Customer customer) {
//        String hql = "insert into Customer c (name, age, address) value (:name, :age, :address)";
//        TypedQuery<Customer> typedQuery = entityManager.createQuery(hql, Customer.class);
//    }

    public Customer findById(int id) {
        String hql = "select c from Customer c where  c.id = :id";
        TypedQuery<Customer> typedQuery = entityManager.createQuery(hql, Customer.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    public void create(Customer customer) {
        if (customer.getId() != 0) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }
}

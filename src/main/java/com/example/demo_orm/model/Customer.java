package com.example.demo_orm.model;

import javax.persistence.*;

//annotation Entity: dùng để đánh dấu thực thể trong dự án spring
//hỗ trợ tạo bảng DB bằng ORM
@Entity
//annotation hỗ trợ đặt tên bảng trong DB
@Table(name = "customers")
public class Customer {
    //annotation Id: tạo khóa chính
    @Id
    //id tự động chạy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String address;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

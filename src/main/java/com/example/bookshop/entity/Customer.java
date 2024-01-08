package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String address;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private List<Order>orders =
            new ArrayList<>();

    public void add(Order order){
        order.setCustomer(this);
        orders.add(order);
    }

    public Customer(String customerName, String address, String email, String phoneNumber) {
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

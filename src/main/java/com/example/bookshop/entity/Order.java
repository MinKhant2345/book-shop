package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate orderDate;
    private String billingAddress;
    private String shippingAddress;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private double totalAmount;
    @OneToMany(mappedBy = "order")
    private List<OrderItem>orderItems=
            new ArrayList<>();
    @ManyToOne
    private Customer customer;

    public void add(OrderItem orderItem){
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }

    public Order(String name, LocalDate orderDate, String billingAddress, String shippingAddress, PaymentMethod paymentMethod, double totalAmount) {
        this.name = name;
        this.orderDate = orderDate;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }
}

package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;
    private boolean paymentOnDelivery;
    private String address;
    private String phoneNumber;
    private String City;
    private String PostalCode;

    @Enumerated(EnumType.STRING)
    private Progress progress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "order_product_inventory",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_inventory_id"))
    private Set<ProductInventory> products;
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "confirmer_id")
    private User confirmer;

}

package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private boolean paymentOnDelivery;

    @Enumerated(EnumType.STRING)
    private Progress status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
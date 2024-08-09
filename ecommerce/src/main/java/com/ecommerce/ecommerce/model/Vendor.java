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
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String profilePicture;
    private String phoneNumber;
    private String storeName;


    @OneToMany(mappedBy = "vendor")
    private Set<Product> products;

}

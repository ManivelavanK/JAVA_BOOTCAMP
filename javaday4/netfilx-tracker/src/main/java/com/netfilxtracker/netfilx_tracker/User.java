package com.netflixtracker.netflix_tracker;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String subscriptionType;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date joinDate = new java.util.Date();
}
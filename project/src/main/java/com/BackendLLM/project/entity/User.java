package com.BackendLLM.project.entity;

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
    private Long id;
    
    private String name;
    private String email;
    private String password;
    
    @Column(unique = true, nullable = false)
    private String referralCode; //  Unique referral code for each user
    
    private String referredBy; //  Stores referral code, NOT a User object

    private boolean profileCompleted = false; //  Track profile completion
}

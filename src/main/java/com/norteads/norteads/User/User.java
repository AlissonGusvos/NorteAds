package com.norteads.norteads.User;

import com.norteads.norteads.Auth.Client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private Long id;

    private String username;
    private String email;

    @Column(name = "pass_hash")
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserTypes userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;
}
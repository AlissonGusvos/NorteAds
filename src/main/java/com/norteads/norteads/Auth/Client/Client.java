package com.norteads.norteads.Auth.Client;

import com.norteads.norteads.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "comp_name")
    private String compName;

    private String email;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private User gestorId;
}

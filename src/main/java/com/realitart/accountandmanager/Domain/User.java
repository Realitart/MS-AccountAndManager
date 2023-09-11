package com.realitart.accountandmanager.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_USER_TYPE")
    UserType idUserType;
//    private String password;
    private String username;
    private String name;
    private String email;
    private Boolean activeNotifications;
    private Long imageId;
}

package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="USERS")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Column(name="FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name="MIDDLE_NAME")
    private String middleName;

    @Basic
    @Column(name="LAST_NAME")
    private String lastName;

    @Basic
    @Column(name="USERNAME")
    private String username;

    @Basic
    @Column(name="EMAIL")
    private String email;

    @Basic
    @Column(name="PASSWORD")
    private String password;

    @Basic
    @Column(name="LAST_LOGIN")
    private LocalDateTime lastLogin;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS")
    private UserStatus status;
}

package com.deciphex.deciphex.assignment.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name="role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private UserRole userRole;


}
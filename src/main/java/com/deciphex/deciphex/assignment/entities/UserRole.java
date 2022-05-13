package com.deciphex.deciphex.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = User.class, mappedBy = "userRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> user = new ArrayList<>();

    @Column(name = "role_id")
    private long roleId;

}
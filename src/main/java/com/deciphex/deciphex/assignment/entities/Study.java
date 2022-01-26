package com.deciphex.deciphex.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "STUDY")
public class Study implements Serializable {

    //TODO Run manual tests to get the entity persisting working!
    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "study")
    private Set<Slide> slide;

    @Column(name = "lifecycleStatus")
    private String lifecycleStatus;

}
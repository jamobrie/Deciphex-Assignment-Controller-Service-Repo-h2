package com.deciphex.deciphex.assignment.entities;

import com.deciphex.deciphex.assignment.enums.LifecycleStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SLIDE")
public class Slide implements Serializable {

    @ManyToOne
    @JoinColumn(name = "study_id", nullable = false)
    private Study study;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "organ")
    private String organ;

    @Column(name = "section")
    private String section;

    @Column(name = "block")
    private String block;

    @Enumerated(EnumType.STRING)
    private LifecycleStatus lifecycleStatus;

    public Slide() {
    }

}

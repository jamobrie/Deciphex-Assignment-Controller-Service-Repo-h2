package com.deciphex.deciphex.assignment.entities;

import com.deciphex.deciphex.assignment.enums.LifecycleStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SLIDE")
public class Slide implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "slideName")
    private String slideName;

    @Column(name = "organ")
    private String organ;

    @Column(name = "section")
    private String section;

    @Column(name = "block")
    private String block;

    @Enumerated(EnumType.STRING)
    private LifecycleStatus lifecycleStatus;

    @ManyToOne()
    @JoinColumn(name="role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private UserRole userRole;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id", nullable = false)
    private Study study;

    public Slide() {
    }

}

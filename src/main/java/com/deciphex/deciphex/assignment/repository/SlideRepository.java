package com.deciphex.deciphex.assignment.repository;


import com.deciphex.deciphex.assignment.entities.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlideRepository extends JpaRepository<com.deciphex.deciphex.assignment.entities.Slide, Integer> {

    Optional<Slide> findByName(String slideName);

}

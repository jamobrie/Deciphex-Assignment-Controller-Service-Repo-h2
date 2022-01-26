package com.deciphex.deciphex.assignment.repository;

import com.deciphex.deciphex.assignment.entities.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Integer> {



}

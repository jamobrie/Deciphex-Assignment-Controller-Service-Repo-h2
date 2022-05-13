package com.deciphex.deciphex.assignment.repository;

import com.deciphex.deciphex.assignment.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserRole, Long> {

}
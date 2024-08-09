package com.restfulapi.first_spring_boot.repository;

import com.restfulapi.first_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositoy: interact with DBMS (CSDL)
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

package com.userservice.pagination.springbootpaginationdemo.repository;

import com.userservice.pagination.springbootpaginationdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(:first_name) OR LOWER(u.lastName) = LOWER(:last_name) OR LOWER(u.email) = LOWER(:email)")
    List<User> search(@Param("first_name") String firstName, @Param("last_name") String lastName, @Param("email") String email, Pageable pageable);
}


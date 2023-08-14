package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagerRepository extends JpaRepository<UserAccount, Long> {
}
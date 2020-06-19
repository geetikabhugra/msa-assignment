package com.nagarro.msa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.msa.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

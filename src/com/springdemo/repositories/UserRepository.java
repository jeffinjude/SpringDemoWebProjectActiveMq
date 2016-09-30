package com.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.models.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{

}

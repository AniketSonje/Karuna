package com.karuna.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff,Long> {

	Staff findByEmail(String email);

	Optional<Staff> findByEmailAndPassword(String email, String password);

}

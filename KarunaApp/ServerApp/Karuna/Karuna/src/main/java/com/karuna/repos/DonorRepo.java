package com.karuna.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.dto.RegisterDonorDto;
import com.karuna.entity.Donor;

public interface DonorRepo extends JpaRepository<Donor, Long> {

	Donor save(RegisterDonorDto donor);

	Optional<Donor> findByEmailAndPassword(String email, String password);

}

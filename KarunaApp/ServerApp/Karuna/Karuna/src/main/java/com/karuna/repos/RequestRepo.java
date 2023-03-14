package com.karuna.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.dto.RequestDto;
import com.karuna.entity.Request;

public interface RequestRepo extends JpaRepository<Request, Long>{

	List<Request> findAllByStatus(Boolean status);

	Request save(RequestDto request);
	
	

}

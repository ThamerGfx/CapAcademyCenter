package com.example.CapAcademy.Repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.CapAcademy.models.Agent;





@CrossOrigin(origins ="*")
public interface AgentRepository extends JpaRepository<Agent, Long> {

	@Query("SELECT u FROM Agent u WHERE u.email = ?1 and u.cin = ?2 ")
	List<Agent> findAgent(String email ,String cin );  
	
	
}

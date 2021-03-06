package com.example.CapAcademy.Repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CapAcademy.models.Formation;
import com.example.CapAcademy.models.User;
import com.example.CapAcademy.models.contenu;


public interface FormationRepository extends JpaRepository<Formation , Long>  {

	


	@Query("SELECT u FROM Formation u WHERE u.id = ?1")
	Formation findFormationByid(Long id );  
		
	List<Formation> findByFormateur(String email) ; 
	
	


	
	
}

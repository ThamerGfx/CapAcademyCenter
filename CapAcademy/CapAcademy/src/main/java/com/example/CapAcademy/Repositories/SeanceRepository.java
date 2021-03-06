package com.example.CapAcademy.Repositories;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CapAcademy.models.Seance;
import com.example.CapAcademy.models.contenu;

public interface SeanceRepository extends JpaRepository<Seance, Long>{

	List<Seance> findBynameFormateur(String formateur) ; 

	
}

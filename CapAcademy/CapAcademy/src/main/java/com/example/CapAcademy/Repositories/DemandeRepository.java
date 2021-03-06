package com.example.CapAcademy.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapAcademy.models.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Long>
{

List<Demande> findByEmail(String email) ;  

Boolean existsByFormation(String Formation) ;  


	
}

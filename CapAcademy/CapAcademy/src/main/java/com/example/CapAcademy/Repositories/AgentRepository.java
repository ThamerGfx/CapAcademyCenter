package com.example.CapAcademy.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.CapAcademy.models.Agent;




@CrossOrigin(origins ="*")
public interface AgentRepository extends JpaRepository<Agent, Long> {


}
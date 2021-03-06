package com.example.CapAcademy.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapAcademy.CapAcademyApplication;
import com.example.CapAcademy.Repositories.AgentRepository;
import com.example.CapAcademy.models.Agent;
import com.example.CapAcademy.models.User;

@RestController
@CrossOrigin(origins ="*")
public class AgentController {

	@Autowired
	private AgentRepository ag ; 
	
	
	
	
	
	

	 @GetMapping(value = "/LoginAg/{email}/{cin}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Agent LoginUser( @PathVariable String email ,@PathVariable  String cin) {
			Agent agent = new Agent() ; 
		 int size = ag.findAgent(email, cin).size() ; 
		 if (size == 0)
		 {
			 
			 
			 
			 return agent;}
		 else 
		 {
			 
			 CapAcademyApplication.email =  ag.findAgent(email, cin).get(0).getEmail() ; 
			 CapAcademyApplication.idUser =  ag.findAgent(email, cin).get(0).getId().intValue() ; 
			 CapAcademyApplication.NumTel =  ag.findAgent(email, cin).get(0).getNumTel() ; 
			 	 
			 
			 System.out.println(CapAcademyApplication.email );
			 System.out.println(CapAcademyApplication.idUser);
			 System.out.println(CapAcademyApplication.NumTel);
			 
			 return  ag.findAgent(email, cin).get(0);
			 
		 
		 
		 
		 
		 
		 }
		 
	 
	 
	 }
	
	
	
	
	
	
	
	
	
	
	
	 @GetMapping(value = "/AffAgents", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Agent> getAgents() {
			
			return ag.findAll() ;
		}
	 
	 
		@RequestMapping(value="/Agent" , method=RequestMethod.POST)
		public Agent Save(@RequestBody Agent c ) {
			
			return ag.save(c) ;
		}
		
		@RequestMapping(value="/Agent/{id}" , method=RequestMethod.DELETE)
		public Boolean deleteContact(@PathVariable Long id ) {
			
			 ag.deleteById(id) ;
			 return true ; 
		}
	 
	 
		@RequestMapping(value="/Agent/{id}" , method=RequestMethod.PUT)
		public Agent Save(@RequestBody Agent c , @PathVariable   long id ) {
			c.setId(id); ; 	
			return ag.save(c) ;
		}
}

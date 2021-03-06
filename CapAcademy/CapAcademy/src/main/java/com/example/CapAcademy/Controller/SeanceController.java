package com.example.CapAcademy.Controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.example.CapAcademy.Repositories.FormationRepository;
import com.example.CapAcademy.Repositories.SeanceRepository;
import com.example.CapAcademy.Services.FormationService;
import com.example.CapAcademy.models.Agent;
import com.example.CapAcademy.models.Formateur;
import com.example.CapAcademy.models.Formation;
import com.example.CapAcademy.models.Seance;

@RestController
@CrossOrigin(origins ="*")
public class SeanceController {

	
	@Autowired
	private	FormationRepository FR ;
	
	
	@Autowired 
	SeanceRepository seance ; 
	
	
	
	public String getFormationsById( @PathVariable Long id  ) {
		
		
		return FR.findFormationByid(id).getName();
		
				
				
			
				
		}
	
	
	
	
	@RequestMapping(value="/Seance/{id}/{formateur}" , method=RequestMethod.POST)
	public Seance Save(@RequestBody Seance c  , @PathVariable Long id , @PathVariable String formateur ) {
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		c.setUrlSeance(c.getUrlSeance()+dtf.format(now).toString().replace(" ","" ).replace("/", "").replace(":", ""));
		 c.setNameFormateur(formateur);
		c.setIdformation(id.intValue());

		c.setNameFormation(getFormationsById(id)); 
		
		c.setIdformateur(44) ; 
		 
		
		return seance.save(c) ;
	}
	
	
	
	
	 @GetMapping(value = "/Seances", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Seance> getAllSeances() {
			
			return seance.findAll();
		}
	 
	 
	 @RequestMapping(value="/Seances/{id}" , method=RequestMethod.DELETE)
		public Boolean deleteSeance(@PathVariable Long id ) {
			 
			seance.deleteById(id) ;
			 
			 return true ; 
		}
	 

	 @GetMapping(value = "/SeanceByFormateur", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Seance> getSeanceByFormation()  {
			
			return seance.findBynameFormateur(CapAcademyApplication.email);
		}
	 
	 
	 
}

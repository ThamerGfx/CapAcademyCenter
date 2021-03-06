package com.example.CapAcademy.Controller;

import java.util.ArrayList;
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
import com.example.CapAcademy.Repositories.DemandeRepository;
import com.example.CapAcademy.Repositories.FormationRepository;
import com.example.CapAcademy.Repositories.SeanceRepository;
import com.example.CapAcademy.models.Demande;
import com.example.CapAcademy.models.Formation;
import com.example.CapAcademy.models.Seance;



@RestController
@CrossOrigin(origins ="*")
public class DemandeController {

	@Autowired
	DemandeRepository DR ; 
	
	@Autowired
	private	FormationRepository FR ;
	

	@Autowired
	private	SeanceRepository SE ;
	
	
	@RequestMapping(value="/AddDemande/{idFormation}/{FormationName}" , method=RequestMethod.POST)
	public Long Save(Demande c , @PathVariable  long idFormation , @PathVariable  String FormationName  ) 
	{
		
		if (DR.existsByFormation(FormationName)) {
			
			 return null ; 
		}
		
		 System.out.println(CapAcademyApplication.email );
		 System.out.println(CapAcademyApplication.idUser);
		 System.out.println(CapAcademyApplication.NumTel);
			
		 c.setEmail(CapAcademyApplication.email);
			c.setId( (long) CapAcademyApplication.idUser);
			c.setNumTel(CapAcademyApplication.NumTel);
			c.setIdFormation(idFormation);
			c.setFormation(FormationName);
			c.setEtat("non valided");
			
			DR.save(c) ; 
	    return c.getId() ;   
	}
	
	
	@GetMapping(value = "/DemandebyEmail", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Demande> getDemandes() {
		
		return DR.findByEmail(CapAcademyApplication.email);
	}
	
	@GetMapping(value = "/Demande", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Demande> getAllDemandes() {
		
		return DR.findAll();
	}
	
	

	 
	@RequestMapping(value="/Demande/{id}" , method=RequestMethod.PUT)
	public Demande Save(@RequestBody Demande c , @PathVariable   long id ) {
		c.setId(id); 
		c.setEtat("valided");
		return DR.save(c) ;
	}
	
	
	
	@GetMapping(value = "/FD", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Seance> getAllSeanceClient() {
		
		List<Seance> listResult = new ArrayList<Seance>() ;
		List<Demande> list2 = DR.findByEmail(CapAcademyApplication.email)  ;

		List<Seance> list4 = SE.findAll() ; 
		
		
		for (int i = 0; i < list2.size() ; i++) {
			
		
				
				for (int j = 0; j < list4.size(); j++) {
					
					if (list2.get(i).getIdFormation() == list4.get(j).getIdformation() & list2.get(i).getEtat().equals( "valided")   )
					
					{
						
					
								
								listResult.add(list4.get(j)) ; 
								
								
							}
							
							
						
					
						
					}
					
					
					
				
				
			}
		return listResult ; 
		
		}
		
		
		
	
	
	
	
	
	
	
	@GetMapping(value = "/SC", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formation> getAllSeance() {
		
		List<Formation> listResult = new ArrayList<Formation>() ;
		List<Demande> list2 = DR.findByEmail(CapAcademyApplication.email)  ;
		List<Formation> list3  = FR.findAll() ; 

		
		
		for (int i = 0; i < list2.size() ; i++) {
			
		
				
				for (int j = 0; j < list3.size(); j++) {
					
					if (list2.get(i).getIdFormation() == list3.get(j).getId() ) {
						
						listResult.add(list3.get(j)) ; 
					
						
					}
					
					
					
				
				
			}
		}
		
		return listResult ; 
		
		
	}
	
	
	
}

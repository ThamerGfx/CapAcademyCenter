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

import com.example.CapAcademy.Repositories.UserRepository;
import com.example.CapAcademy.models.Agent;
import com.example.CapAcademy.models.Formateur;
import com.example.CapAcademy.models.User;

@RestController
@CrossOrigin(origins ="*")
public class UserController {
	
	@Autowired
	UserRepository Us ;
	
	@RequestMapping(value="/Login/{email}/{password}" , method=RequestMethod.POST)
		public User LoginUser( @PathVariable String email ,@PathVariable  String password) {
		 User user = new User() ; 
		 int size = Us.findUser(email, password).size() ; 
		 if (size == 0)
		 {return user;}
		 else 
		 {return Us.findUser(email, password).get(0);}
		 
	 
	 
	 }
	 
	 
	 
	 

	 @GetMapping(value = "/Users", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<User> getAllUsers() {
			
			return Us.findAll();
		}
	 

		@RequestMapping(value="/AddUser" , method=RequestMethod.POST)
		public User Save(@RequestBody User c ) {
			c.setEtat("not valided");
		
		return Us.save(c) ;
		}

}

/**
 * 
 */
package getContacts.getContactsController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import getContacts.contactEntity;
import getContacts.getContactsrepo.GetContactsRepo;
import getContacts.service.ContactService;
import getContacts.service.contactDTO;

/**
 * @author User
 *
 */
@RestController
public class Controller {
	
	@Autowired
	GetContactsRepo getContactsRepo;
	@Autowired
	ContactService cs;
	
	/*
	 * @GetMapping("/{firstname}") public contactEntity
	 * getContactByFn(@PathVariable("fn") String fn) {
	 * 
	 * return getContactsRepo.findByFirstName(fn);
	 * 
	 * }
	 */
	
	@GetMapping("/contact")
	  public List<contactEntity> gethello() {
		
		
		  return getContactsRepo.findAll();
	    
	  }
	  
	 @PostMapping(path="/contact/create")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<contactEntity> createContact(@RequestBody contactDTO contactCreateDTO){
	        return new ResponseEntity<>(cs.createContact(contactCreateDTO), HttpStatus.CREATED);
	    }
}
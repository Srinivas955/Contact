package in.srinivas.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.srinivas.Entity.ContactEntity;
import in.srinivas.constants.AppContants;
import in.srinivas.props.AppProperties;
import in.srinivas.service.ContactService;

@RestController
@CrossOrigin
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@Autowired
	private AppProperties appProps;
		
	@PostMapping("/contact")
	public String saveContact(@RequestBody ContactEntity contact) {
		boolean contactsaved = service.saveContact(contact);
		Map<String, String> messages = appProps.getMessages();	
		if(contactsaved) {
			return messages.get(AppContants.CONTACT_SAVE_SUCC);
		}else
			return messages.get(AppContants.CONTACT_SAVE_FAILE);
		}
	
	@GetMapping("/contacts")
	public List<ContactEntity> getAllContacts(){
		return service.getAllContacts();
	}
	@GetMapping("/contact/{cid}")
	public ContactEntity editContact(@PathVariable ("cid") Integer contactId) {
		return service.getContactById(contactId);
	}
	
	@DeleteMapping("/contact/{cid}")
	public String deleteContac(@PathVariable ("cid") Integer contactId) {
		boolean deleteContactById = service.deleteContactById(contactId);
		 Map<String, String> messages = appProps.getMessages();
		
		if(deleteContactById) {
			return messages.get(AppContants.CONTACT_DELL_SUCC);
		}else
			return messages.get(AppContants.CONTACT_DELL_FAILE);
	}
	

}

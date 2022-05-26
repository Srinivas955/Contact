package in.srinivas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srinivas.Entity.ContactEntity;
import in.srinivas.Repository.ContactRepository;

@Service
public class ContactSeviceImpl implements ContactService {
	Boolean status;
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(ContactEntity contact) {
		contact.setActiveSw("Y");
		ContactEntity save = contactRepo.save(contact);
			
		if (save.getContactId()!= null) {
			return true;
		}else
			return false;
	}


	@Override
	
	  public List<ContactEntity> getAllContacts() {
	    	List<ContactEntity> findByActiveSw = contactRepo.findByActiveSw("Y");
	  
	  
	  return findByActiveSw;
	  
	  }
	 
	
	

	@Override
	public ContactEntity getContactById(Integer contactId) {
		Optional<ContactEntity> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
			return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
	     
		Optional<ContactEntity> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
			contactEntity.setActiveSw("N");
		    contactRepo.save(contactEntity);
		    ContactEntity byId = contactRepo.getById(contactId);
		    String activeSw = byId.getActiveSw();
		    if(activeSw == "N") {
		    	status = true;
		    }
		    else
		    {
	    	status =  false;
	    }	
				
		}
			return status;
	}
			



	@Override
	public List<ContactEntity> getAllContacts(ContactEntity contact) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

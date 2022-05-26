package in.srinivas.service;

import java.util.List;

import in.srinivas.Entity.ContactEntity;



public interface ContactService {
	
	public boolean saveContact (ContactEntity contact);
	public List<ContactEntity> getAllContacts (ContactEntity contact);
	public ContactEntity getContactById (Integer contactId);
	public boolean deleteContactById (Integer contactId);
	List<ContactEntity> getAllContacts();

	

}

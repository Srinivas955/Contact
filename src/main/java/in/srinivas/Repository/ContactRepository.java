package in.srinivas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srinivas.Entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{
	
	
	public List<ContactEntity>  findByActiveSw(String activeSw);
}

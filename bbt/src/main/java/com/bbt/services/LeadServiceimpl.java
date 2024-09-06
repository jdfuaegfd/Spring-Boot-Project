package com.bbt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbt.entity.Lead;
import com.bbt.repository.LeadRepository;
@Service
public class LeadServiceimpl implements LeadServices {

	//provides dependency injection 
	@Autowired
	//interface of Leadrepository to connect to  repository page 
	//created with  interface repository object(leadrepo) to direct to repository page  
	
	
	private LeadRepository leadrepo;
	@Override
	public void saveLeaddata(Lead lead) {
		//calling the interface object and adding to save method to save the data
		//save is inbuilt method from hybernate.
		leadrepo.save(lead);

	}
	@Override
	public List<Lead> listAllData(Lead lead) {
	//List<Lead> forms list from Lead class and stores the data in leads.
		List<Lead> leads = leadrepo.findAll();
		//findAll()method mean select* from table (so it selects all the data from database and calling from leadrepo
		//it takes all the data from database by findAll()method
		return leads;
	}
	@Override
	public void deleteOnelead(long id) {
		//it is method to delete the id
    leadrepo.deleteById(id);		
	}
	@Override
	public Lead updateonelead(long id) {
		//optional is used to get the particular id from database for updating purpose.
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead=findById.get();
		return lead;
	}
	@Override
	public void saveLeaddata1(Lead lead) {
		leadrepo.save(lead);
		
	}
	
	
		
	

}

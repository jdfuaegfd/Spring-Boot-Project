package com.bbt.services;

import java.util.List;

import com.bbt.entity.Lead;



public interface LeadServices {
	public void saveLeaddata(Lead lead);
	//we are using interface with list type to display the data from database as list form in frontend 
	//of the browser
	//collection concept in my projet.
	public List<Lead> listAllData(Lead lead);
	public void deleteOnelead(long id);
	//for updating the record
	public Lead updateonelead(long id);
	//public void saveupdate(Lead lead);
	public void saveLeaddata1(Lead lead);

}

package com.bbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbt.entity.Lead;
import com.bbt.services.LeadServices;
import com.bbt.util.bbtEmail;

@Controller
public class LeadController {

	//provides dependency injection 
	@Autowired 
	//creates object automtically by autowired 
	//that is A a1=new A()(creates like this )
	//interface of leadservice to connect to service page
	private LeadServices leadserv;
	
	//autowired of email layer
	@Autowired
	private bbtEmail bbtmail;
	
	
	//http://localhost:8080/view-when this link is given
	//in browser from view layer that is jsp file it directs to controller layer
	//of mvc architecture
	@RequestMapping("/view")
	public String view() {
		return "view";
	}	 
	
	//savelead 
	// form action of view page redirected to the controller page
	@RequestMapping("/savelead") 
	
	//this method savelead with (Lead-class entity and calling by object lead
	//saves the data and converts into java data for further execution)
	
	public String savelead(Lead lead) {
		 
		//calling the service page method using the object created in interface
		//for redirecting to service page as per the mvc architecture.
		//lead inside the method this saves the data from jsp file 
		
		leadserv.saveLeaddata(lead);
		//calling method for sending mail using interface object
		bbtmail.bbtEmailSend(lead.getEmail(), "welcome to our site", "hello this is vishaka happy to connect with you");
		return "view";
		
	}
	
	
	//http://localhost:8080/list_leads(given in the browser)
	
	//this method is used to display all the data from database in frontend of the server
	
	@RequestMapping("/list_leads")
	//Model represents the data that is passed between the controller and the view.(saves the data from class Lead).
	//model is just like requestdispatcher.
	//first take the data from the service layer
	public String listAllLeads(Lead lead,Model model) {
	List<Lead> leads  =	leadserv.listAllData(lead);
	//calling the object of Model (model) to save the data created in table leads.
	model.addAttribute("leads",leads);
	//now from service it comes to control layer and from control layer it goes to view layer
	//by the above mentioned jsp file.
		return "list_all_data";
		//list_all_data it is the jsp file .
		
	}
	
	//deletelead method requested from list_all_data jsp file to delete the record and retuen to the file itself
	@RequestMapping("/deletelead")
	//request parameter is used for a single record
	public String deletelead(@RequestParam("id") long id,Model model ,Lead lead) {
		leadserv.deleteOnelead(id);
		
		List<Lead> leads=leadserv.listAllData(lead);
		model.addAttribute("leads",leads);
		return "list_all_data";
		
	}
	
	
	@RequestMapping("/updatelead")
	public String updatelead(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadserv.updateonelead(id);
		model.addAttribute("lead", lead);
		return "updatelead";
	}
	
	  @PostMapping("/updateonelead")
	    public String saveUpdatedLead(Lead lead, ModelMap model) {
	         leadserv.saveLeaddata1(lead);
	        
	         List<Lead> leads=leadserv.listAllData(lead);
	 		model.addAttribute("leads",leads);
	 		return "list_all_data";
	}
	
	
	
	
	
}

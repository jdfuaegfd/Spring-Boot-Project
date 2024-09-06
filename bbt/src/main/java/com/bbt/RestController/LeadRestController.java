package com.bbt.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.entity.Lead;
import com.bbt.repository.LeadRepository;

@RestController
//with the help of restful controller that is restful webservice the data is converted in the form of json file
//json=javascript object notation
public class LeadRestController {
	
	//gor dependency to connect from one layer to another layer
	@Autowired
	private LeadRepository leadrepo;
	//http://localhost:8080/list_all_api
	@GetMapping("/list_all_api")//to get the list 
	public List<Lead> listAllApi(Lead lead){
		List<Lead> leads = leadrepo.findAll();
		return leads;
		}
	//http://localhost:8080/save_api
	//Use @PostMapping is for saving or creating new record in database through json format
	@PostMapping("/save_api")
	//creating a method to insert this json file in database by converting into java
	//to read  the json content we have a spl annotation that is @requestbody .
	//we are gonna insert inside this method
	public void saveapi(@RequestBody Lead lead) {
		leadrepo.save(lead);
		
	}
	//http://localhost:8080/update_api
	
	//this method is used for the updation or any changes in the records of database.
	////to read the json content we have @request body notation with the entity class and object 
	//to convert into java 
	//@putmapping is used to update the data in the database through json file. 
	@PutMapping("/update_api")
	public void updateApi(@RequestBody Lead lead) {
		
		leadrepo.save(lead);
	}
	
	//to read only one content in json we are using @pathvariable to read all the content in json we are using
	//@requestbody
	
	
	//to  delete the record from the database
	//http://localhost:8080/delete_api/any id value
	//what is pathparameter -pathparameter is where we insert id value inside the open and close curlybraces
	//as from the below mentioned @deletemapping ("/delete_api/{id}-api and path parameter to delete the 
	//particular id from the database.
	@DeleteMapping("/delete_api/{id}")
	//to read the id value we are providing a @pathvariable with id and its datatype.
	public void deleteapi(@PathVariable("id")long id) {
		//deleteById it is inbuilt method in hybernate to delete the particular data from the table by id.
		leadrepo.deleteById(id);
	}
	
	

}

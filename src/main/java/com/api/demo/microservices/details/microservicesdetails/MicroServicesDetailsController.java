package com.api.demo.microservices.details.microservicesdetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.microservices.details.microservicesdetails.models.MicroServiceNotFoundException;
import com.api.demo.microservices.details.microservicesdetails.models.MicroServicesDetails;
import com.api.demo.microservices.details.microservicesdetails.repositories.MicroServiceRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/microservice/details")
public class MicroServicesDetailsController {

	@Autowired
	private MicroServiceRepository repository;


	@GetMapping("/all")
	public List<MicroServicesDetails> getAllMicroservicesDetails(){

		return repository.findAll();
	}

	@GetMapping("/list/names")
	public List<String> getAllMicroservicesNames(){

		List<String> msNames = new ArrayList<String>();
		Iterator itr = repository.findAll().iterator(); 
		while(itr.hasNext()){

			MicroServicesDetails m = (MicroServicesDetails) itr.next();
			msNames.add(m.getName());

		}

		return msNames;
	}


	@GetMapping("/name")
	public MicroServicesDetails getMicroServiceByName(@RequestParam(value="msname") String name) {
		//return repository.findByName(name);

		MicroServicesDetails m = repository.findByNameQuery(name);
		if(m == null)
			throw new MicroServiceNotFoundException("404 NOT FOUND - No entry for this MS in MongoDB, API to get MS list - localhost:8080/microservice/details/list/names ");
		else
			return m;
	}

	@PostMapping("/save")
	public MicroServicesDetails saveMicroserviceDetails(@Valid @RequestBody MicroServicesDetails MicroServiceDetail) {

		MicroServiceDetail.set_id(ObjectId.get());
		repository.save(MicroServiceDetail);
		return MicroServiceDetail;
	}

	@PostMapping("/multiple/save")
	public void saveMultipleMicroserviceDetails(@Valid @RequestBody MicroServicesDetails[] MicroServiceDetail) {

		for(MicroServicesDetails m :MicroServiceDetail ) {

			m.set_id(ObjectId.get());
			repository.save(m);
		}


	}
}

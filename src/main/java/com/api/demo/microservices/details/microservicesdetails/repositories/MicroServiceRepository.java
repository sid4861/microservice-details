package com.api.demo.microservices.details.microservicesdetails.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.api.demo.microservices.details.microservicesdetails.models.MicroServicesDetails;

public interface MicroServiceRepository extends MongoRepository<MicroServicesDetails, String> {

	@Query("{name : ?0}")
	 public MicroServicesDetails findByNameQuery(String name);
}

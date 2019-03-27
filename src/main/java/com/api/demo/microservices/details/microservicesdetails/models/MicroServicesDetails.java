package com.api.demo.microservices.details.microservicesdetails.models;

import java.util.ArrayList;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Micro-service details - name,list, paths,tuxedo calls, type, description, methods")
public class MicroServicesDetails {

	@Id
	private ObjectId _id;
	
	private String name;
	private String type;
	private String description;
	private ArrayList<String> tuxedoCalls;
	private ArrayList<String> paths;
	private ArrayList<String> methods;


	public MicroServicesDetails() {
		
		
	}
	
	public MicroServicesDetails(String name, String type, String description, ArrayList<String> tuxedoCalls,
			ArrayList<String> paths, ArrayList<String> methods) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.tuxedoCalls = tuxedoCalls;
		this.paths = paths;
		this.methods = methods;
	}
	
	
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getTuxedoCalls() {
		return tuxedoCalls;
	}
	public void setTuxedoCalls(ArrayList<String> tuxedoCalls) {
		this.tuxedoCalls = tuxedoCalls;
	}
	public ArrayList<String> getPaths() {
		return paths;
	}
	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}
	public ArrayList<String> getMethods() {
		return methods;
	}
	public void setMethods(ArrayList<String> methods) {
		this.methods = methods;
	}
	@Override
	public String toString() {
		return "MicroServicesDetails [name=" + name + ", type=" + type + ", description=" + description
				+ ", tuxedoCalls=" + tuxedoCalls + ", paths=" + paths + ", methods=" + methods + "]";
	}



}

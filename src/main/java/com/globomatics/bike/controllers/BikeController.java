package com.globomatics.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController 
{
	@Autowired
	private BikeRepository bikeRepository;//inject bike repository into the table
	
	@GetMapping //when a get request is issued to base path("/api/v1/bikes") , it will forward
	public List<Bike> list()//it to list method if it is using HTTP GET
	{
		/*List<Bike> bikes = new ArrayList<>();
		return bikes;*/
		
		//now add new persistence code
		return bikeRepository.findAll();//free method by jpa
	}
	
	@PostMapping //gives response to post to base url
	@ResponseStatus(HttpStatus.OK) //response code 200
	public void create(@RequestBody Bike bike)//to process the bike submission data sent by user
	{
		bikeRepository.save(bike);//free method
	}
	
	@GetMapping("/{id}") //the id passes on in url will be passes to @PathVariable("id")
	public Bike get(@PathVariable("id") long id)//get a id and return that particular bike
	{
		/*return new Bike();*/
		
		return bikeRepository.getOne(id);//free method
	}
}

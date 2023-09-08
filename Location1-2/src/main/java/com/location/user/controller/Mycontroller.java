package com.location.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.user.entities.UserLocation;
import com.location.user.services.LocationService;

@RestController
public class Mycontroller {
	@Autowired
	private LocationService locationservice;
	//get the details 
	@GetMapping("/Locations")
	public List<UserLocation> getUserLocations(){
		System.out.println("data fetch  successfully");
		
		return this.locationservice.getUserLocstions();
		
		
	}
	//get single details 
	@GetMapping("/Locations/{locationid}")

	public UserLocation getnearestlocation(@PathVariable String locationid) {
		return this.locationservice.getnearestlocation(Long.parseLong(locationid));
	}
	//add locations and details 
	@PostMapping("Locations")
	public UserLocation adduser(@RequestBody UserLocation locations  ) {
		System.out.println("data added successfully");
		
		return this.locationservice.addlocation(locations);
		
		
	}
	
	//update data
	@PutMapping("Locations")
	public  UserLocation Update(@RequestBody UserLocation update) {
		System.out.println("data updated successfully");
		return this.locationservice.Update(update);
		
	}
	
	//delete location
	@DeleteMapping("/Locations/{locationid}")
	public ResponseEntity<HttpStatus> deletelocation(@PathVariable String locationid){
		System.out.println("data Deleted successfully");
		try {
			this.locationservice.deletelocation(Long.parseLong(locationid));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//update single values 
	@PatchMapping("Locations")
	public UserLocation updateline(@PathVariable UserLocation updateline) {
		return this.locationservice.updateline(updateline);
		
	}
	
	

	
}

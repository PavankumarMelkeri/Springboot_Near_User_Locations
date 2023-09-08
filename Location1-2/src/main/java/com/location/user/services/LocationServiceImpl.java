package com.location.user.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.location.user.entities.UserLocation;


@Service
public class LocationServiceImpl implements LocationService {

	
	List<UserLocation> list;
	public LocationServiceImpl() {
		list = new ArrayList<>();
		list.add(new UserLocation(101, "Hum", 45.11, 80.11));
		list.add(new UserLocation(102, "Bidar", 50.11, 85.11));
		list.add(new UserLocation(103, "Bhalki", 56.11, 89.11));
		list.add(new UserLocation(104, "Basavakalyan", 59.11, 90.11));
		list.add(new UserLocation(105, "Jalsangi", 85.11, 55.11));
		list.add(new UserLocation(102, "Dadwanti", 58.11, 88.11));
		
		
	}
	//to display all data
	public List<UserLocation> getUserLocstions() {
		
		return list;
	}
    //To get the single Data
	@Override
	public UserLocation getnearestlocation(long locationid) {
		UserLocation c=null;
		for(UserLocation user:list) {
			if(user.getId()==locationid) {
				c=user;
				break;
					
			}
			
			
		}
		return c;
	}
     //To add the Data
	@Override
	public UserLocation addlocation(UserLocation locations) {
		
		list.add(locations);
		return locations;
		
	}
     //To Update the Data
	@Override
	public UserLocation Update(UserLocation update) {
	
		list.forEach(e-> {
			if(e.getId()==update.getId()) {
				e.setName(update.getName());
				e.setLatitude(update.getLatitude());
				e.setLongitude(update.getLongitude());
			}
		
		});
	
		return update;
	}
	
     //To delete The Data Frm Database 
	@Override
	public void deletelocation(long delete) {
	list=this.list.stream().filter(e->e.getId()!=delete).collect(Collectors.toList());
		
	}
	//update single line
	@Override
	public UserLocation updateline(UserLocation updateline) {
		list.forEach(e-> {
			if(e.getId()==updateline.getId()) {
				e.setName(updateline.getName());
				e.setLatitude(updateline.getLatitude());
				e.setLongitude(updateline.getLongitude());
			}
		
		});
	
		return updateline;
		
	}





	

}

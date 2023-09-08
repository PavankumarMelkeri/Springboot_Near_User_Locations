package com.location.user.services;

import java.util.List;

import com.location.user.entities.UserLocation;

public interface LocationService {
	

	public List<UserLocation> getUserLocstions();

	public UserLocation getnearestlocation(long locationid);

	public UserLocation addlocation(UserLocation locations);

	public UserLocation Update(UserLocation update);

	public void deletelocation(long delete);

	public UserLocation updateline(UserLocation updateline);
	

}

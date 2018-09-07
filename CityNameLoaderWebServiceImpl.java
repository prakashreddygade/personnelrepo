/**
 * $Id gadep002 $
 * 
 * Copyright (c) 2016, Disney Enterprises, Inc.
 */
package com.wdpr.nge.agc.webservice.impl;

import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wdpr.nge.agc.service.CityNameLoaderService;
import com.wdpr.nge.agc.webservice.CityNameLoaderWebService;

/**
 * City Name Loader WebService Implementation
 * @author gadep002
 *
 */
@Component("cityNameLoaderWebService")
public class CityNameLoaderWebServiceImpl implements CityNameLoaderWebService {
	
	@Autowired
	private CityNameLoaderService cityNameLoaderSrvc;

	/**
	 * Deletes the entry from either guest approved city name
	 * or rejected city name list based on status.
	 * @param cityName the cityName to set
	 * @param moderatedType the moderatedType to set
	 * @return Response
	 */
	@Override
	public Response deleteCityName(final String cityName,
			               final String moderatedType) { 
		
		final JSONObject response = cityNameLoaderSrvc.
		                   deleteCityName(cityName,moderatedType);
		
		return Response.ok(response.toString()).build();
	}

	/**
	 * Creates entry in either Guest Approved City Name
	 * or Guest Rejected City Name list based on status.
	 * @param payLoad the payLoad to set 
	 * @return Response
	 */
	@Override
	public Response insertCityName(final String payLoad) {
		
		final JSONObject response = cityNameLoaderSrvc.
		         loadCityName(JSONObject.fromObject(payLoad));
		
		return Response.ok(response.toString()).build();
	}
    
	/**
	 * Updates guest city name.
	 * @param guestId the guestId to set 
	 * @param payload the payload to set 
	 * @return Response
	 */
	@Override
	public Response updateGuestCityNameInMetadata(final String guestId,
			final String payload) {

		final JSONObject response = cityNameLoaderSrvc.updateGuestCityNameInMetadata(guestId,
									JSONObject.fromObject(payload));

		return Response.ok(response.toString()).build();
	}

	

	/**
	 * @param cityNameLoaderService
	 *            the cityNameLoaderService to set
	 */
	public void setCityNameLoaderService(final CityNameLoaderService cityNameLoaderService) {
		this.cityNameLoaderSrvc = cityNameLoaderService;
	}
	
}

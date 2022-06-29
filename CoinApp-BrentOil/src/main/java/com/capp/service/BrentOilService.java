package com.capp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capp.model.BrentOil;
import com.capp.utils.Util;

@Service
public class BrentOilService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${brentoil.config.uri_commodities-api}")
	private String URL_BRENTOIL;

	@SuppressWarnings("unchecked")
	public BrentOil getPetroleoDoDia(){
				 
        ResponseEntity<?> response = restTemplate.getForEntity( URL_BRENTOIL , Object.class);
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody();   
				
		return Util.getBrentOil(map);
 
	}

}

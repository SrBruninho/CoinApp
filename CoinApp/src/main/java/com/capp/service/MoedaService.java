package com.capp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capp.model.Moeda;
import com.capp.utils.Util;

@Service
public class MoedaService {

	static String URI_API_EXTERNA = "https://economia.awesomeapi.com.br/xml/all";

	@Autowired
	private RestTemplate restTemplate;
	
	public List<Moeda> getMoedas(){
				 
        ResponseEntity<?> response = restTemplate.getForEntity(URI_API_EXTERNA, Object.class);
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody();        
		
		return Util.converterEntradaAPI(map);
 
	}
}

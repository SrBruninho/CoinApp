package com.capp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capp.model.Moeda;
import com.capp.utils.Constants;
import com.capp.utils.Util;

@Service
public class MoedaService {

	@Autowired
	private RestTemplate restTemplate;
	
	public List<Moeda> getMoedas(){
				 
        ResponseEntity<?> response = restTemplate.getForEntity(Constants.URI_API_RETORNA_TUDO, Object.class);
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody();   
				
		return Util.converterEntradaAPIToList(map); 
 
	}
	
	public Moeda converterMoeda(String from, String to) {
        ResponseEntity<?> response = 
        		restTemplate.getForEntity(Constants.URI_API_CONVERTE+from+"-"+to , Object.class);
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody();   


		return Util.converterEntradaAPIToMoeda(map);
	}
}

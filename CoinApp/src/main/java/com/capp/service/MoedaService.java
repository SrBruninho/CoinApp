package com.capp.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capp.exception.MoedaNotFoundException;
import com.capp.model.Moeda;
import com.capp.utils.Constants;
import com.capp.utils.Util;

@Service
public class MoedaService {

	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Moeda> getMoedas(){
				 
        ResponseEntity<?> response = restTemplate.getForEntity(Constants.URI_API_RETORNA_TUDO, Object.class);
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody();   
				
		return Util.converterEntradaAPIToList(map); 
 
	}
	
	@SuppressWarnings("unchecked")
	public Moeda converterMoeda(String from, String to, int qtd) {
		ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		try {
				response = restTemplate.getForEntity(
					Constants.URI_API_CONVERTE+from+"-"+to,
					Object.class);
		}
		catch (Exception e) {
			throw new MoedaNotFoundException("Moedas não encontradas: " + from + " | " + to);
		}
        
		HashMap<Object, Object> map = (HashMap<Object, Object>) response.getBody(); 

		return Util.converterEntradaAPIToMoeda(map,qtd);
	}
	
	public HashMap<String,String> getMoedasDisponiveis(){
		ResponseEntity<?> response = restTemplate.getForEntity(Constants.URI_API_RETORNA_MOEDAS_DISPONIVEIS, Object.class);
		HashMap<String, String> map = (HashMap<String, String>) response.getBody();   
		
		return Util.ordenarHashMap(map);
	}

}

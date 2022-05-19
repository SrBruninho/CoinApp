package com.capp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capp.model.Moeda;
import com.capp.service.MoedaService;

@RestController
public class MoedaController {

	@Autowired
	private MoedaService moedaService;
	
	@GetMapping(value = "/listarMoedas")
	public List<Moeda> getMoedas() {
		
		return moedaService.getMoedas();
	}
}

package com.capp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capp.model.BrentOil;
import com.capp.service.BrentOilService;

@RestController
@CrossOrigin
public class BrentOilController {
	
	@Autowired
	private BrentOilService brentOilService;

	@GetMapping(value = "/petroleoDia")
	public BrentOil getPetroleoDoDia() {		
		return brentOilService.getPetroleoDoDia();
	}	
}
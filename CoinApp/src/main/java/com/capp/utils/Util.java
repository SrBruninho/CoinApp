package com.capp.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.capp.model.Moeda;

public class Util {
	
	public static List<Moeda> converterEntradaAPIToList(HashMap<Object, Object> p_hashMap)   {
		
		List<Moeda> listaDeMoedas = new ArrayList<Moeda>();
		
		p_hashMap.entrySet().forEach(entry ->{
			Moeda moeda = new Moeda();
			HashMap<String, String> mapaValor = (HashMap<String, String>) entry.getValue();
			mapaValor.entrySet().forEach(valor->{
				System.out.println(valor.getKey()+":"+valor.getValue());
				
				if(valor.getKey().equals("code")) 
					moeda.setCode( valor.getValue());
				//else if(valor.getKey().equals("codein")) 
				//	moeda.setCodein( valor.getValue());
				else if(valor.getKey().equals("name")) 
					moeda.setName( valor.getValue());
				/*else if(valor.getKey().equals("high")) 
					moeda.setHigh( new BigDecimal( valor.getValue() ));
				else if(valor.getKey().equals("low")) 
					moeda.setLow( new BigDecimal( valor.getValue() ));
				else if(valor.getKey().equals("varBid")) 
					moeda.setVarBid( new BigDecimal( valor.getValue() ));
				else if(valor.getKey().equals("pctChange")) 
					moeda.setPctChange( new BigDecimal( valor.getValue() ));*/
				else if(valor.getKey().equals("bid")) 
					moeda.setBid( new BigDecimal( valor.getValue() ));
				else if(valor.getKey().equals("create_date")) 
					moeda.setCreateDate(LocalDateTime.parse( valor.getValue(),
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			});
			listaDeMoedas.add(moeda);
		});
		
		return listaDeMoedas;
	}
	
	public static List<String> converterMoedasDisponiveisAPIToList(HashMap<String, String> p_hashMap)   {
		
		List<String> listaDeMoedas = new ArrayList<String>();
		
		p_hashMap.entrySet().forEach(entry ->{
			listaDeMoedas.add(entry.getValue());
			});
		
		return listaDeMoedas.stream().sorted().toList();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Moeda converterEntradaAPIToMoeda(HashMap<Object, Object> p_hashMap, int qtd)   {
		Moeda moeda = new Moeda();
		
		p_hashMap.entrySet().forEach(entry->{
			LinkedHashMap<String, String> mapaValor = (LinkedHashMap<String, String>) entry.getValue();
			mapaValor.entrySet().forEach(valor->{
			if(valor.getKey().equals("code")) 
				moeda.setCode( valor.getValue());
			else if(valor.getKey().equals("name")) 
				moeda.setName( valor.getValue());
			else if(valor.getKey().equals("bid")) 
				moeda.setBid( new BigDecimal( valor.getValue() ) );
			else if(valor.getKey().equals("create_date")) 
				moeda.setCreateDate(LocalDateTime.parse( valor.getValue(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));	
			});	
			moeda.setTotal(  moeda.getBid().multiply(BigDecimal.valueOf(qtd)));
		});
		
		return moeda;
	}

}

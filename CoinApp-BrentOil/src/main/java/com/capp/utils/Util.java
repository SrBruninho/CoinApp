package com.capp.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.capp.model.BrentOil;

public class Util {
	
	public static BrentOil getBrentOil(HashMap<Object, Object> p_hashMap)   {
		
		BrentOil brentOil = new BrentOil();
		
		p_hashMap.entrySet().forEach(entry ->{
 			HashMap<String, String> mapaValor = (HashMap<String, String>) entry.getValue();
			mapaValor.entrySet().forEach(valor->{				
				if( valor.getKey().equals( "base" ) ) 
					brentOil.setMonetaryBase( valor.getValue() );
				else if(valor.getKey().equals( "unit" ) ) 
					brentOil.setUnit( valor.getValue() );
				else if(valor.getKey().equals( "date" ) ) 
					brentOil.setCurrentDate( LocalDate.parse( valor.getValue() ) );
				else if(valor.getKey().equals( "rates" ) ) {					
					LinkedHashMap<String, String> mapRates;
					Object mapObject =  valor.getValue();
					mapRates = (LinkedHashMap<String, String>) mapObject;
					
					Object rateOilValue = mapRates.values().stream().findFirst().get();

					brentOil.setBrentRate( 1 / (Double) rateOilValue  );
					}				
			});
		});
		
		return brentOil;
	}
	
}
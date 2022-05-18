package com.capp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capp.model.Moeda;
import com.capp.utils.Util;
import com.google.gson.Gson;

@Service
public class MoedaService {

	static String URI_API_EXTERNA = "https://economia.awesomeapi.com.br/json/all";

	@Autowired
	private RestTemplate restTemplate;
	
	public Moeda getMoedas() throws Exception{
		
        try {
            URL url = new URL(URI_API_EXTERNA);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != HttpStatus.OK.value())
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.ConverterJsonParaString(resposta);

            Gson gson = new Gson();
            Moeda moeda = gson.fromJson(jsonEmString, Moeda.class);

            return moeda;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
	}
}

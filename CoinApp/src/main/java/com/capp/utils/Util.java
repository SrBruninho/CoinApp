package com.capp.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
	public static String ConverterJsonParaString(BufferedReader buffereReader) throws IOException  {
		String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
	}

}

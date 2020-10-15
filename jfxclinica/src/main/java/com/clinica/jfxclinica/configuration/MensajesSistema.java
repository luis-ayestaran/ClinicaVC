package com.clinica.jfxclinica.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MensajesSistema {
	//private static InputStream is;
	private static Properties properties;
		
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("config.properties");
		properties = new Properties();
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
	}
	
	public static String getMessage(String key) throws FileNotFoundException {
		String message = null;
		message = properties.getProperty(key);
		if(message == null)
			throw new FileNotFoundException("The property <"+ key +"> was not foud");
		return properties.getProperty(key);
	}
	
}

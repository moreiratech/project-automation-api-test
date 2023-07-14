package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static String getProperty(String prop) {

		Properties prop1 = new Properties();
		
		try {
		    prop1.load(PropertyReader.class.getClassLoader().getResourceAsStream("config.properties"));
		
		    return prop1.getProperty(prop);
		
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
}

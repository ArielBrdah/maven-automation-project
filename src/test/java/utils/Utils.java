package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static String readProperties(String key) { 
		String value = "";
		
		try (InputStream input = new FileInputStream("./src/test/resources/data/configuration.properties")) {
			
			Properties prop = new Properties();
			
			prop.load(input);
			value = prop.getProperty(key);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}
}

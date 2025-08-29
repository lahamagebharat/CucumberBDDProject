package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	public Properties properties;

	String path = "C:\\Users\\HP\\JavaFullStck\\CucumberFramework\\Config.properties";

	// constructor
	public ReadConfig() {
		try {
			properties = new Properties();

			// to open config .properties file in input mode and load the file
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBrowser() {
		System.out.println("Reading browser name from config file");
		String value = properties.getProperty("browser");
		System.out.println("Browser name is: " + value);

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

}

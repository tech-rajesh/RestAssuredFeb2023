package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Properties;

public class ReadDatFromConfigFile {

	Properties prop;
	public ReadDatFromConfigFile() throws Exception {
		FileInputStream fis = new FileInputStream(".\\data\\config.properties");
		
		
		prop = new Properties();
				
		prop.load(fis);
		
		
	}

	
	
	public String getBaseURL_QA() {
		
	
		return prop.getProperty("baseURL_QA");
	}
	
	public String getBaseURL_DEV() {
		
		
		return prop.getProperty("baseURL_DEV");
	}
	
}

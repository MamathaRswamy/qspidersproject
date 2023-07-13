package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Mamatha
 *
 */
public class PropertiesUtility implements IAutoConstants {
	/**
	 * This method is used to fetch the value from property file and it is returning String value
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readingdataFromPropertyFile(String key)  {
	FileInputStream fis=null;
	try {
		fis = new FileInputStream(PROPERYFILE);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Properties ppt=new Properties();
	try {
		ppt.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return ppt.getProperty(key);
}

}

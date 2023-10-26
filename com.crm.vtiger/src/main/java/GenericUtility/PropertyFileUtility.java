package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class consist of generic method  to fetch data from property file
 * @author radhi
 *
 */

public class PropertyFileUtility {
	/**
	 * This method help us to fetch data from property file
	 * @param string 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant.propertyfilepath);
		Properties p = new Properties();
		p.load(fis);
		String Value = p.getProperty(key);
		return Value;
	}

}

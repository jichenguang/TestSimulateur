package Webq.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 属性文件的路径设置
 * @author 700sfriend
 *
 */
public class ConfigUtilsJi {
	public static Log log = new Log(ConfigUtilsJi.class);
	
	public  static Properties getProperties(String config) throws FileNotFoundException{
		
		
		Properties myproperties = new Properties();
		log.info("Get the config file: " + config);
		
		File myfile = new File(config);
		FileInputStream myinstream = new FileInputStream(myfile);
		
		try{
			myproperties.load(myinstream);
		}catch(Exception e) {
			log.error("can't find the config file ");
			log.error(e.getMessage());
		}
		return myproperties;
	}
}

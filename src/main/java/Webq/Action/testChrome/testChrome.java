package Webq.Action.testChrome;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Webq.utils.ConfigUtilsJi;

/**
 * 联系使用chromedriver
 * @author 700sfriend
 *
 */
public class testChrome {
	private static String chromedriver;
	private static String fireBug;
	private static Properties p = null;
	
	
	public static String config = System.getProperty("user.dir")+"/config.properties";
	
	public testChrome(){
		
	}

	public static WebDriver getChrome() throws FileNotFoundException{
		
		p = ConfigUtilsJi.getProperties(config);
		chromedriver = p.getProperty("chromedriver");	
		System.setProperty("webdriver.chrome.driver", chromedriver);
		
		
//		System.setProperty("webdriver.chrome.driver", "/Users/700sfriend/git/iQA-Webq/iQaWebq/chromedriver-2");
		WebDriver driver = new ChromeDriver();		
        driver.get("http://www.baidu.com/");	
		return driver;
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		testChrome testC = new testChrome();
		testC.getChrome();
	}
	

}

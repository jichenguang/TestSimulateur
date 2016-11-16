package Webq.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Case:
 * 获取Session
 * @author 700sfriend
 *
 */
public class CommonGetSession {
	

	/**
	 * 给Driver增加一个session
	 * @param driver
	 * @return
	 */
	public static WebDriver addCookie(WebDriver driver){
		Cookie homePageCookie;	
		homePageCookie = CommonGetSession.getCookie(driver);		
		System.out.println("浏览器默认加上Session");
		driver.manage().addCookie(homePageCookie);
		return  driver;
		
	}

	
	/**
	 * 从当前driver获取一个session
	 * @param Driver
	 * @return
	 */	
	public static  Cookie getCookie(WebDriver Driver) {		
		 Cookie Session;		 
		 Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Session = Driver.manage().getCookieNamed("Qi_SessionId");	 
		 System.out.println("获取的用户为:" + Session.getValue());		 
		 return Session;
	}

}

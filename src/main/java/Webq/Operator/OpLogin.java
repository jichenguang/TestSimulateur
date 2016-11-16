package Webq.Operator;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import Webq.Common.CommonGetSession;
import Webq.Common.CommonPageHome;
import Webq.Page.PageAd;
import Webq.Page.PageCart;
import Webq.Page.PageOrder;
import Webq.Page.PageOrderDetails;
import Webq.Page.PageOrderLists;
import Webq.Page.PageOrderPay;
import Webq.Page.PageProduct;
import Webq.Page.PageTransitional;
import Webq.utils.TestNGListener;
import Webq.utils.UITest;

@Listeners({ TestNGListener.class })
public class OpLogin  {
	
	WebDriver driver = null;

	public  OpLogin(WebDriver driver) {
		this.driver = driver;
	}
	@Test
	/*
	 * Webq登陆
	 */
	public void actionLogin() throws Exception {
		/*登陆*/
		CommonPageHome.viewMainPage();	
		/*登陆后，获取Cookie.*/
		CommonGetSession.addCookie(driver);
		/*然后执行业务操作*/
		
		/*发邮件*/
//		MailTest.ssSendMail();
	}
	
	@Test
	/*
	 * WAP登陆
	 */
	public void actionLoginWap() throws Exception {
		/*登陆*/
		CommonPageHome.viewMainPageWap();	
		/*登陆后，获取Cookie.*/
		CommonGetSession.addCookie(driver);
		/*然后执行业务操作*/
		/*发邮件*/
//		MailTest.ssSendMail();
	}
	
	



}

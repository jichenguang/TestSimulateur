/**
 * 
 */
package Webq.Common;

import org.openqa.selenium.WebDriver;
import Webq.Page.PageHome;

/**
 * 业务类：登陆业务
 * 这是一个工厂类，粗略的告诉你要干什么，但是具体的事情还是封装到了下一层
 * @author Young
 *
 */
public class CommonPageHome {

	private static WebDriver driver;
	private static PageHome pageHome;
	private static String pageHomeTitle;

	
	
	/**
	 * 这个方法没用上
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	

	/**
	 * @author 700sfriend
	 * Webq
	 * 1、从首页切换到登录
	 * 2、登录
	 * 3、切换到我的主页
	 * ！使用了两个xml文件。一个是LoginPage.xml,使用loginpage类调用；另一个是HomePage.xml,使用HomePage类调用
	 * @throws Exception
	 */
	public static PageHome viewMainPage() throws Exception {

		CommonLogin.setDriver(driver);
		
//		正常的登录，返回一个页面
		pageHome = CommonLogin.login();
		
//		登录后切换到“主页”
		System.out.println("！！跳转到首页");
		pageHome.clickOnMainPage();
		
//		返回一个主页的“页对象”
		return pageHome;
	}
	
	
	
	/**
	 * @author 700sfriend
	 * WAP
	 * 1、切换到登录
	 * 2、登录
	 * 3、切换到我的主页
	 * ！使用了两个xml文件。一个是LoginPage.xml,使用loginpage类调用；另一个是HomePage.xml,使用HomePage类调用
	 * @throws Exception
	 */
	public static PageHome viewMainPageWap() throws Exception {

		CommonLogin.setDriver(driver);
		
//		正常的登录，返回一个页面
		pageHome = CommonLogin.loginWap();
				
//		登录后切换到“我的主页”
		System.out.println("#WAP登陆成功#");
		return pageHome;
	}
	
	

	/**
	 * @author 700sfriend
	 * 传一个参数，作为指定的浏览器启动
	 * @param driver
	 */
	public static void setDriver(WebDriver driver) {
		CommonPageHome.driver = driver;
	}

}

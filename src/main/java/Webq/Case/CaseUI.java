package Webq.Case;


import org.testng.annotations.Test;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import Webq.Common.CommonPageHome;
import Webq.Operator.OpLogin;
import Webq.Page.PageHome;
import Webq.Page.PageLogin;
import Webq.Page.WebqPageHome;
import Webq.utils.DriverFactory;
import Webq.utils.TestNGListener;
import Webq.utils.UITest;


/**
 * 管理类：管理测试用例的调用、初始化driver
 * @author 700sfriend
 *
 */
@Listeners({ TestNGListener.class })
public class CaseUI extends UITest {

//	注释掉，使用默认浏览器。
//	WebDriver driver = DriverFactory.getChromeDriver();
	WebDriver driver = new FirefoxDriver();


//	@BeforeMethod(alwaysRun = true)
	@BeforeSuite(alwaysRun = true)
	public void init() {		
		super.init(driver);
		CommonPageHome.setDriver(driver);
	}
	
	/*具体用例*/	
	/*登陆，然后跳转到首页*/
	@Test
	public void TestWebqPageHomeLoginCheckPresentUrl()  throws Exception {
		 System.out.println("登陆,检查登陆后的链接");
		 OpLogin tsLogin = new OpLogin(driver);
		 tsLogin.actionLogin();				 
	} 
	

	
	/*直接使用首页*/
	@Test
//	public void TestUIPageProduct() throws Exception {
	public void TestWebqPageHomeCheckHeadTitle() throws Exception {
		System.err.println("检查首页的Title");
		WebqPageHome tsPageHome = new WebqPageHome(driver);
		tsPageHome.getHeadPageHome();
	}
	
	


	@Test
//	public void TestUIPageProduct() throws Exception {
	public void TestWebqPageHomeCheckLogoSize() throws Exception {
		System.err.println("检查首页的LOGO大小");
		WebqPageHome tsPageHome = new WebqPageHome(driver);
		tsPageHome.getLogoSize();
	}
	
	@Test
	public void TestWebqPageHomeCheckPerUrl() throws Exception {
		System.err.println("检查首页—周边的Url");
		WebqPageHome tsPageHome = new WebqPageHome(driver);
		tsPageHome.getPerTitle();
		tsPageHome.isPerBtnUrl();
	}
	
	

	@Test
	public void TestWebqLoginOut() throws Exception {
		System.err.println("测试结束");
	}

	@Override
//	@AfterMethod(alwaysRun = true)
	@AfterSuite(alwaysRun = true)
	public void stop() {
		super.stop();
	}

}

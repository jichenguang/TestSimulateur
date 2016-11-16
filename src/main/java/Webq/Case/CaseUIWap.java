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
import Webq.Page.PageLoginWap;
import Webq.Page.WapPageHome;
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
public class CaseUIWap extends UITest {

//	注释掉，使用默认浏览器。
//	WebDriver driver = DriverFactory.getChromeDriver();
	WebDriver driver = new FirefoxDriver();


//	@BeforeMethod(alwaysRun = true)
	@BeforeSuite(alwaysRun = true)
	public void init() {		
		super.init(driver);
		CommonPageHome.setDriver(driver);
		 /*浏览器最大化*/
		driver.manage().window().maximize();
	}
	
	/*具体用例*/	
	/*登陆，然后跳转到首页*/
	@Test
	public void TestWebqPageHomeLoginCheckPresentUrlWap() throws Exception {
		 System.out.println("登陆");
		 OpLogin tsLoginWap = new OpLogin(driver);
		 tsLoginWap.actionLoginWap();	
	} 
	

	
	/*直接使用首页*/
	@Test
	public void TestWebqPageHomeCheckHeadTitleWap() throws Exception {
		System.err.println("检查首页的Title");
		WapPageHome tsPageHomeWap = new WapPageHome(driver);
		tsPageHomeWap.getHeadPageHomeWap();
	}


	@Test
	public void TestWebqPageHomeCheckLogoSizeWap() throws Exception {
		System.err.println("检查首页的LOGO大小");
		WapPageHome tsWapPageHome = new WapPageHome(driver);
		tsWapPageHome.getLogoSizeWap();
	}
	
	@Test
	public void TestWebqPageHomeCheckPerUrlWap() throws Exception {
		System.err.println("检查首页—MenuBar-的Url");
		WapPageHome tsWapPageHome = new WapPageHome(driver);
		tsWapPageHome.getMenuBar();
		tsWapPageHome.checkSubDivMenuBar();		
	}
	

	@Test
	public void TestWebqLoginOutWap() throws Exception {
		System.err.println("测试结束");
	}

	@Override
//	@AfterMethod(alwaysRun = true)
	@AfterSuite(alwaysRun = true)
	public void stop() {
		super.stop();
	}

}

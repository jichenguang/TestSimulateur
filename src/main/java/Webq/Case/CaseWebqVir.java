package Webq.Case;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import Webq.Common.CommonPageHome;
import Webq.Operator.OpExWebq;
import Webq.Operator.OpLogin;
import Webq.Operator.OpStoreAll;
import Webq.Page.PageAd;
import Webq.Page.PageCart;
import Webq.Page.PageOrder;
import Webq.Page.PageOrderDetails;
import Webq.Page.PageOrderLists;
import Webq.Page.PageOrderPay;
import Webq.Page.PageProduct;
import Webq.Page.PageTransitional;
import Webq.utils.DriverFactory;
import Webq.utils.TestNGListener;
import Webq.utils.UITest;


/**
 * 管理类：管理测试用例的调用、初始化driver
 * @author 700sfriend
 *
 */
@Listeners({ TestNGListener.class })
public class CaseWebqVir extends UITest {

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
	
	/*登陆*/
	@Test
	public void TestWebq1() throws Exception {
		 System.err.println("1");
		 OpLogin opLogin = new OpLogin(driver);
		 opLogin.actionLogin();		 
		 PageCart.ClearCart(driver);
		 
	}
	
	
	
	/*商品详情页用例：通用流程*/
	@Test
	public void TestWebq2() throws Exception {
		System.err.println("2");
		OpExWebq opExWebq = new OpExWebq(driver);
		opExWebq.actionExProPages();
	}
	
	/*商品详情页用例：检查商品的预定状态*/
	@Test
	public void TestWebq3() throws Exception {
		System.err.println("3");
		OpExWebq opExWebq = new OpExWebq(driver);
		opExWebq.actionExProInfoState();
	}
	

	/*商品详情页用例：检查商品是否自动显示为有货的SKU颜色，且按钮状态正确*/
	@Test
	public void TestWebq4() throws Exception {
		System.err.println("4");
		OpExWebq opExWebq = new OpExWebq(driver);
		opExWebq.actionExProInfoAutoChangeSKU();	
	}
	
	/*商品详情页用例：检查商品的+和-*/
	@Test
	public void TestWebq5() throws Exception {
		System.err.println("5");
		OpExWebq opExWebq = new OpExWebq(driver);
		opExWebq.actionExProInfoChangeNum();	
	}
	
	/*商品详情页用例：检查商品的最大数量和最小数量*/
	@Test
	public void TestWebq6() throws Exception {
		System.err.println("6");
		OpExWebq opExWebq = new OpExWebq(driver);
		opExWebq.actionExProInfoTopNum();	
	}
	
	/*测试的用例*/
	@Test
	public void TestWebqEnd() throws Exception {
		System.err.println("End");
	}

	@Override
//	@AfterMethod(alwaysRun = true)
	@AfterSuite(alwaysRun = true)
	public void stop() {
		super.stop();
	}

}

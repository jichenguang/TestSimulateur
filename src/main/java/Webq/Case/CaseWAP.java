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
public class CaseWAP extends UITest {

//	注释掉，使用默认浏览器。
//	WebDriver driver = DriverFactory.getChromeDriver();
	WebDriver driverWap = new FirefoxDriver();
	
	

//	@BeforeMethod(alwaysRun = true)
	@BeforeSuite(alwaysRun = true)
	public void init() {		
		super.init(driverWap);
		CommonPageHome.setDriver(driverWap);
		 /*浏览器最大化*/
		driverWap.manage().window().maximize();
	}
	
	/*具体用例*/
	
	/*登陆*/
	@Test
	public void TestWap1() throws Exception {
		 System.err.println("1");
		 OpLogin opLogin = new OpLogin(driverWap);
		 opLogin.actionLoginWap();
	}
	
	/*
	/*商品详情页*/
	@Test
	public void TestWap2() throws Exception {
		System.err.println("2");
		OpExWebq opExWebq = new OpExWebq(driverWap);
		opExWebq.actionExProPagesWap();
	}
		
	/*订单全流程*/
	@Test
	public void TestWap3() throws Exception {
		System.err.println("3");
		OpStoreAll opStoreAll = new OpStoreAll(driverWap);
		opStoreAll.actionCartSubCancleOrderWap();
	}

	/*测试的用例*/
	@Test
	public void TestWap4() throws Exception {
		System.err.println("4");
	}

	@Override
//	@AfterMethod(alwaysRun = true)
	@AfterSuite(alwaysRun = true)
	public void stop() {
		super.stop();
	}

}

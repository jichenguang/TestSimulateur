package Webq.Page;

import java.io.IOException;
import java.lang.annotation.Native;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Webq.utils.BasePage;
import Webq.utils.Locator;
import Webq.utils.PageFactory;

/**
 * 足管登陆的页面
 * 具体的一个页面类，可以使用BasePage的方法。
 * 被Action 类调用
 * @author 700sfriend
 *
 */
public class PageLoginWap extends BasePage {

	WebDriver driver;

	@Override
	public WebDriver getDriver() {
		return driver;
	}
/**
 * @author 700sfriend
 * 1、封装了driver.get的方法，打开知乎的登陆页
 * 2、封装了4个locator对象
 * @param driver
 * @throws Exception
 */
	public PageLoginWap(WebDriver driver) throws Exception {
		super(driver);
//		电商首页进入登陆
		driver.get("http://webq.700paper.cn/wap/login");
	}

	Locator txtEmailInputBox = new Locator("txtEmailInputBox",30);
	Locator txtPasswordInputBox = new Locator("txtPasswordInputBox");
	Locator loginButton = new Locator("loginButton");
	Locator profileWap = new Locator("profileWap");
/**
 * @author 700sfriend
 * 输入用户名、密码、点击注册按钮
 * @param email
 * @throws Exception
 */
	public void typeEmailInputBox(String name) throws Exception {	
		open("http://webq.700paper.cn/wap/login");
		System.out.println("打开WAP浏览器。");
//		点击“登录”切换按钮，到登录页面
//		switchToLogin();
//		输入值
		/*
		 * Param:locatorname:loginEmailInputBox
		 */
		type(txtEmailInputBox, name);
	}
	/**
	 * @author 700sfriend
	 * 输入用户名、密码、点击注册按钮
	 * @param email
	 * @throws Exception
	 */
	public void typePasswordInputBox(String password) throws Exception {
		type(txtPasswordInputBox, password);
	}
	/**
	 * @author 700sfriend
	 * 输入用户名、密码、点击注册按钮
	 * @param email
	 * @throws Exception
	 */
	public void clickOnLoginButton() throws Exception {
		clickwap(loginButton);
	}

	public boolean isPrestentProfileWap() throws IOException { 
		return isElementPresent(profileWap, 60);
	}
	
	
	

		


	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(2, TimeUnit.SECONDS);
	}
	


	/**
	 * 
	 *  跳转到登陆页
	 * @throws Exception
	 */
	public void switchToLogin() throws Exception
	{	
//		 返回一个Locator 对象, 该对象具有3个属性。
		Locator clickToLoginButton=new Locator("clickToLoginButton");
		click(clickToLoginButton);
	}
	public PageHome isPresentUrl() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Assert.assertEquals(driver.getCurrentUrl(),"http://webq.700paper.cn/Wap/index","首页登陆后，跳转链接错误");
		return (PageHome) PageFactory.getPage(PageHome.class, getDriver());
	}	
}

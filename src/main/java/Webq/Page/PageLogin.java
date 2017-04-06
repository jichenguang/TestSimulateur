package Webq.Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Webq.utils.BasePage;
import Webq.utils.Locator;

/**
 * 足管登陆的页面
 * 具体的一个页面类，可以使用BasePage的方法。
 * 被Action 类调用
 * @author 700sfriend
 *
 */
public class PageLogin extends BasePage {

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
	public PageLogin(WebDriver driver) throws Exception {
		super(driver);
//		电商首页进入登陆
		driver.get("http://webq.700paper.cn/login");
		Thread.sleep(3000);
//		BBS首页进入登陆
//		driver.get("http://test.bbs.700bike.com/");
	}

	Locator loginEmailInputBox = new Locator("loginEmailInputBox",60);
	Locator loginPasswordInputBox = new Locator("loginPasswordInputBox");
	Locator loginButton = new Locator("loginButton");
	Locator profile = new Locator("profile");
//	Locator wgjTitle = new Locator("wgjTitle");
/**
 * @author 700sfriend
 * 输入用户名、密码、点击注册按钮
 * @param email
 * @throws Exception
 */
	public void typeEmailInputBox(String name) throws Exception {
		open("http://webq.700paper.cn/login");		
//		open("http://test.bbs.700bike.com/");
		log.error("检查环境配置的地址有没有变化");
//		点击“登录”切换按钮，到登录页面
//		switchToLogin();
//		输入值
		/*
		 * Param:locatorname:loginEmailInputBox
		 */
		type(loginEmailInputBox, name);
	}
	/**
	 * @author 700sfriend
	 * 输入用户名、密码、点击注册按钮
	 * @param email
	 * @throws Exception
	 */
	public void typePasswordInputBox(String password) throws Exception {
		type(loginPasswordInputBox, password);
	}
	/**
	 * @author 700sfriend
	 * 输入用户名、密码、点击注册按钮
	 * @param email
	 * @throws Exception
	 */
	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	public boolean isPrestentProfile() throws IOException {
		return isElementPresent(profile, 20);
	}

	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(2, TimeUnit.SECONDS);
	}
	
//	public boolean isWanGuoJiePage() throws IOException{
//		return isElementPresent(wgjTitle,20);
//	}

	/**
	 * @author 700sfriend
	 *  跳转到登陆页
	 * @throws Exception
	 */
	public void switchToLogin() throws Exception
	{	
//		 返回一个Locator 对象, 该对象具有3个属性。
		Locator clickToLoginButton=new Locator("clickToLoginButton");
		click(clickToLoginButton);
	}
	
	/*判断当前页面链接*/
	public void isPresentUrl(){
		Assert.assertEquals(driver.getCurrentUrl(),"http://webq.700paper.cn/index","首页登陆后，跳转链接错误");
	}
	
}

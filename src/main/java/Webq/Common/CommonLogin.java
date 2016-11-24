package Webq.Common;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Webq.Page.PageHome;
import Webq.Page.PageLogin;
import Webq.Page.PageLoginWap;
import Webq.utils.BasePage;
import Webq.utils.PageFactory;


/**
 * 这是个什么类？
 * 在测试步骤中，对具体业务操作的描述。
 * 这里的业务操作使用了页面类和元素类运行。
 * @author 700sfriend
 *
 */
public class CommonLogin {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	static String StoreUrl = "http://webq.700paper.cn/login?__EVENTVALIDATION=zPEvEHHuVuia3o7cWOL0Wv%2FHP5RquU5AefjitZP5MEs31W0eV27hq6Au%2B1P7qaHjvP%2FSmNEcYy0qFCCkUhC7KVREmeNZK%2BIBDXPK%2BKT0clS%2BPgGOlz1UnJMFTaE3i2WOZaUxkoLArK1ZcsABAgQiA0t0tVs%3D&__VIEWSTATE=qugkCLu3cvauq28Z9UJMQqKr8SGIAd%2FouTF%2FrLDr8tEH242Om6RrqRj7oZzlzFFyj%2FCWgFFpE5UEAl9xLP5IU6%2Bb1SE%3D&__VIEWSTATEGENERATOR=C2EE9ABB&btnSubmit=&txtEmail=13157741542&txtPassword=ji123456";
	static PageLogin loginPage;
	static PageLoginWap loginPageWap;

	/**
	 * @author 700sfriend
	 * 这是一个有参数的方法
	 * 正常的登录操作
	 * 这个方法，封装的是：详细处理了登陆的操作！
	 * 
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	
	public static PageHome login(String name, String password)
			throws Exception {
		loginPage = new PageLogin(driver);
		loginPage.waitForPageLoad();
		loginPage.typeEmailInputBox(name);
		loginPage.typePasswordInputBox(password);
		loginPage.clickOnLoginButton();
		
		try{
			System.out.println("切换到首页");
			driver.get(StoreUrl);
			loginPage.isPrestentProfile();
			loginPage.isPresentUrl();
		}catch(Exception e){
			Thread.sleep(2000);
			try{
//				driver.get("http://webq.700paper.cn/index?");
				driver.get(StoreUrl);
				Thread.sleep(2000);
				loginPage.isPrestentProfile();
			}catch(Exception e1){
				System.out.println("重试：切换到首页");							
				driver.get(StoreUrl);
			}finally{
				Thread.sleep(3000);
//				driver.navigate().refresh();
				loginPage.isPrestentProfile();
			}

		}
		return myProfile();
	}
	
	
	/*
	 * Wap:Wap登陆
	 */
	public static PageHome loginWap(String name, String password)
			throws Exception {
		loginPageWap = new PageLoginWap(driver);
		loginPageWap.waitForPageLoad();
		loginPageWap.typeEmailInputBox(name);
		loginPageWap.typePasswordInputBox(password);
		loginPageWap.clickOnLoginButton();
		
		
		/*检查Wap首页的登陆标志、当前链接*/
		loginPageWap.isPrestentProfileWap();
		loginPageWap.isPresentUrl();
		
		/*
		 * 
		 *WAP测试，省去联合登陆流程
		 */
		System.out.println("已经登陆到WAP");				
		return myProfileWap();
	}
	/**
	 * 	判断当前页面是否为true;如何判断登陆成功？Yong用了一个元素是否出现做判断。1、成功：能看到用户头像；2、失败：看不到头像
	 * @throws IOException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public static PageHome myProfile() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{

		Assert.assertTrue(loginPage.isPrestentProfile(), "login failed");
		return (PageHome) PageFactory.getPage(PageHome.class, getDriver());
	}
	
	
	public static PageHome myProfileWap() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Assert.assertTrue(loginPageWap.isPrestentProfileWap(), "login failed");
		return (PageHome) PageFactory.getPage(PageHome.class, getDriver());
	}
	
/**
 * @author 700sfriend
 * 这里是个无参的方法
 * 返回一个HomePage类型
 * @return
 * @throws Exception
 */
	public static PageHome login() throws Exception {
//		在本类调用本类方法，可以专注于接收参数
		return CommonLogin.login("13157741542", "ji123456");
	}
	
	public static PageHome loginWap() throws Exception {
//		在本类调用本类方法，可以专注于接收参数
		return CommonLogin.loginWap("13157741542", "ji123456");
	}
/**
 * @author 700sfriend
 *  传递driver
 * @param driver
 */
	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}

}

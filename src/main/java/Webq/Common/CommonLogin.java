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
	static String StoreUrl = "http://www.700store.com/login?__EVENTVALIDATION=jyKQXzZaJ5FJoml5GvqUdDR6kbkTpalvyuUhjCGPqGz%2FXJhsxErPhgEdRvtRaN9VemcbXJvYig634WI1wjuYR6eKmmrCFu1nmsVfP79TRJW10vbv8Sh%2FAEOrEr8%2Fu6Yjljgvx9jGT%2FB04vtWt%2FgTU31Syjg%3D&__VIEWSTATE=5n94eY3KAZ1CMx1QOo75FiANPzozx1AsmAwfZkTeM720msnCS%2F5DoNBY9ekbD5KLT9eyCnjUa89RgcPZ7T13KSf0JfI%3D&__VIEWSTATEGENERATOR=C2EE9ABB&btnSubmit=&txtEmail=18611360619&txtPassword=mljicj00";
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
//		loginPageWap.isPrestentProfileWap();		
//		System.out.println(loginPageWap.isPresentUrl());
		
		/*
		 * 
		 *WAP测试，省去联合登陆流程
		 */
		System.out.println("已经登陆到WAP");				
//		return myProfileWap();// 2017-02-28 这个ICON找不到，才用了下面的链接做验证。
//		return loginPageWap.isPresentUrl();
		return (PageHome) PageFactory.getPage(PageHome.class, getDriver());
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
		return CommonLogin.login("18611360619", "mljicj00");
	}
	
	public static PageHome loginWap() throws Exception {
//		在本类调用本类方法，可以专注于接收参数
		return CommonLogin.loginWap("18611360619", "mljicj00");
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

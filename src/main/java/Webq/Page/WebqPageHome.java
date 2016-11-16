 package Webq.Page;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Webq.Base.WebqBasePage;
import Webq.Element.ElementPageHome;
import Webq.Locator.WebqLocator;
import Webq.utils.BasePage;
import Webq.utils.Locator;
import org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * 首页
 * 
 * 描述：这个子类继承了Base类；
 * 使用了两种方法来定位元素，
 * 一个是调用父类的方法，
 * 另一个是直接调用locator对象；
 * 
 * 另外，该类还封装了自己的操作方法，
 * 因为有的元素需要很多其他元素的配合，
 * 所以在这里封装，这时候就用到了父类的方法。
 * 
 * 描述了主页的操作业务
 * HomePage到底是个啥东西？
 * ？是否是包含了页面的元素的一个类
 * 具体的一个页面类，可以使用BasePage的方法。
 * 被Action 类调用
 * @author 700sfriend
 * 
 */
public class WebqPageHome extends WebqBasePage {
	

	
	/**
	 * 实例化一个常量类，方便以后去调用常量类的常量。
	 * @param driver
	 * @throws Exception
	 */
	ElementPageHome elementPageHome = null; 
	
	/**
	 * 首页
	 * 构造函数
	 * @param driver
	 * @throws Exception
	 */
	public WebqPageHome(WebDriver driver) throws Exception {
		super(driver);
		elementPageHome = new ElementPageHome();

	}
	
	/**
	 * @author 700sfriend
	 * 元素：我的头像
	 * @throws Exception
	 */
	public void clickOnMyProfile() throws Exception
	{
		click(elementPageHome.profile);
	}
	
	/**
	 * @author 700sfriend
	 * 鼠标悬停在头像图片上，既不点击并且不释放
	 * @throws Exception
	 */
	
	public void clickAndHoldProfile() throws IOException
	{
		clickAndHold(elementPageHome.profile);
	}
	
	
	
	
	/**
	 * TitleStore
	 * 由于不能再case层写参数和常量，所以，在Page层将base层的方法，再封装一次带参数的操作方法。
	 */
	public void getHeadPageHome(){
		getPageHead(elementPageHome.TitleStore);
	}
	
	public void getHeadPageHomeWap(){
		getPageHead(elementPageHome.TitleStore);
	}
	
	
	/**
	 * LogoStore
	 * 由于不能再case层写参数和常量，
	 * 所以，在Page层将base层的方法，再封装一次(或者重写一次)带参数的操作方法。
	 */
	public void getLogoSize(){
		getLogoSize(elementPageHome.LogoStore);
	}
	
	
	/**
	 * DIV:per，这是个基础方法，为找到子节点提供帮助
	 * 包括图片，按钮，文案。
	 * 查看周边，或者“大牌尖货”
	 * 
	 */
	public WebElement getDivPer(){		
		WebElement DivPer;
		DivPer = getDivPer(elementPageHome.DivPer);
		return DivPer;
	}
	
//	直接用xpath获取子节点，没有涉及元素路径管理。
	public void getPerTitle(){
		getPerTitle(elementPageHome.PerTitle);
	}
	
	public void  getPerbtnUrl(){
		getPerbtnUrl(elementPageHome.PerBtn);
	}
	
	public void isPerBtnUrl(){	
		 /*JUnit的assert*/
		 assertEquals("链接不正确","http://webq.700paper.cn/list/category/peripheral-all", getPerbtnUrl(elementPageHome.PerBtn));	
		 /*testNG的assert*/
		 Assert.assertEquals(getPerbtnUrl(elementPageHome.PerBtn),"http://webq.700paper.cn/list/category/peripheral-all","链接不一致");
	}
	
	
	/*判断当前页面链接*/
	public void isPresentUrl(){
		Assert.assertEquals(driver.getCurrentUrl(),"http://webq.700paper.cn/index","首页登陆后，跳转链接错误");
	}

	/**
	 * @author 700sfriend
	 * 登陆后的操作
	 * 内含两个方法
	 * 鼠标操作
	 * http://www.ibm.com/developerworks/cn/java/j-lo-keyboard/
	 * @throws Exception
	 */
	public void clickOnMainPage() throws Exception
	{	
		System.out.println("悬浮在弹出层");
		clickAndHoldProfile();
		
		System.out.println("￥￥￥￥￥打开主页");
		driver.navigate().refresh();
		click(elementPageHome.MainPage);
		log.info("跳转到主页");
	}
}

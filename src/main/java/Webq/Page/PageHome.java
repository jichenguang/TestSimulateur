package Webq.Page;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.utils.BasePage;
import Webq.utils.Locator;

/**
 * 描述：这个子类继承了Base类；使用了两种方法来定位元素，一个是调用父类的方法，一个是直接调用locator对象；
 * 		另外，该类还封装了自己的操作方法，因为有的元素需要很多其他元素的配合，所以在这里封装，这时候就用到了父类的方法。
 * 
 * 描述了主页的操作业务
 * HomePage到底是个啥东西？
 * ？是否是包含了页面的元素的一个类
 * 具体的一个页面类，可以使用BasePage的方法。
 * 被Action 类调用
 * @author 700sfriend
 * 
 */
public class PageHome extends BasePage {
	private Locator profile=new Locator("html/body/div[1]/div/div/div[3]");
	private Locator MainPage= new Locator("MainPage");
	private Locator TitleStore = new Locator("TitleStore");
	
	
	
	public PageHome(WebDriver driver) throws Exception {
		super(driver);
	}
	
	/**
	 * @author 700sfriend
	 * 定位元素
	 * @throws Exception
	 */
	public void clickOnMyProfile() throws Exception
	{
		click(profile);
	}
	
	/**
	 * @author 700sfriend
	 * 鼠标悬停在头像图片上，既不点击并且不释放
	 * @throws Exception
	 */
	
	public void clickAndHoldProfile() throws IOException
	{
		clickAndHold(profile);
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
		click(MainPage);
		log.info("跳转到主页");
	}
}

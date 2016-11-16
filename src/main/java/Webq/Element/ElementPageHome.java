package Webq.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Locator.ResolveLocator;
import Webq.Locator.WebqLocator;


/**
 * 常量类：只存放常量(Location,也可以存放成字符串类型)，调用WebqLocator定位元素，并且向调用者提供元素。
 * @see WebqLocator:提供定位元素的方法
 * @serial 元素类要继承一个解析类，这样可以调用解析类的方法，同时又能承担独立分离页面数据的作业。很重要
 * @author 700sfriend
 * 
 * 
 */
public class ElementPageHome {
	
	public ElementPageHome(){
		
	}
	
	/*首页的元素*/
//	public String LogoStore = "";
	public WebqLocator LogoStore = new WebqLocator("LogoStore");
	public WebqLocator LogoStoreWap = new WebqLocator("LogoStoreWap");
	/*首页的Title*/
	public WebqLocator TitleStore = new WebqLocator("TitleStore");
	public WebqLocator TitleStoreWap = new WebqLocator("TitleStoreWap");
	/*首页的profile*/
	public WebqLocator profile = new WebqLocator("profile");
	/*首页的MainPage*/
	public WebqLocator MainPage = new WebqLocator("MainPage");
	/*首页的周边节点,子节点*/
	public WebqLocator DivPer = new WebqLocator("Per");
	public WebqLocator PerTitle = new WebqLocator("PerTitle");
	public WebqLocator PerTitleWap = new WebqLocator("PerTitleWap");
	public WebqLocator PerBtn = new WebqLocator("PerBtn");
	public WebqLocator PerBtnWap = new WebqLocator("PerBtnWap");
	public WebqLocator PerPro = new WebqLocator("per-pro");
	public WebqLocator PathDivMenuBar = new WebqLocator("PathDivMenuBar");
	public WebqLocator PathSubDivMenuBar = new WebqLocator("PathSubDivMenuBar");
	
		
	
}

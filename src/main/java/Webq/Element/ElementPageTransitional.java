package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.PageCart;
import Webq.Page.forLoggerPage;


/**
 * 常量类：过渡页面的元素。
 * @author 700sfriend
 *
 */
public class ElementPageTransitional {
	
	protected static forLoggerPage log = new forLoggerPage(ElementPageCart.class);
	static String message = null;
	
	/**
	 * 购物车所有元素
	 */
	public static WebElement SellOnceButton = null;
	private static WebElement checkText = null;
	private static WebElement ButtonToCart = null;
	private static WebElement FooderPageCart;
	private static WebElement HeaderPageCart;
	/**
	 * 获取购物车成功页的文本
	 * @param cartDriver 
	 * @return
	 */
	public static WebElement getCheckText(WebDriver cartDriver) {
		// TODO Auto-generated method stub		
		checkText = cartDriver.findElement(By.xpath("html/body/div[2]/div[1]/div/p[2]"));
		message = "元素名称是："+checkText.getText()+"  "+"获取的元素路径是："+"html/body/div[2]/div[1]/div/p[2]";
		printLog(message);
		return checkText;
	}
	
	
	/**
	 * 获取去购物车的元素
	 * @param cartDriver
	 * @return
	 */
	
	public static WebElement getButtonToCart(WebDriver cartDriver) {
		// TODO Auto-generated method stub
		ButtonToCart = cartDriver.findElement(By.xpath(".//*[@id='toCheckOut']"));
		message = "元素名称是："+ButtonToCart.getText()+"  "+"获取的元素路径是："+".//*[@id='toCheckOut']";
		printLog(message);
		return ButtonToCart;
	}


	
	/**
	 * 获取过渡页的页脚
	 */
	public static WebElement getHeaderPageCart(WebDriver cartDriver) {
		// TODO Auto-generated method stub
		HeaderPageCart = cartDriver.findElement(By.xpath(".//*[@id='toCheckOut']"));
		message = "元素名称是："+ButtonToCart.getText()+"  "+"获取的元素路径是："+".//*[@id='toCheckOut']";
		printLog(message);
		return ButtonToCart;
	}


	
	
	/**
	 * 获取过渡页的图标
	 */
	public static WebElement getFooderPageCart(WebDriver cartDriver) {
		// TODO Auto-generated method stub
		FooderPageCart = cartDriver.findElement(By.xpath(".//*[@id='toCheckOut']"));
		message = "元素名称是："+ButtonToCart.getText()+"  "+"获取的元素路径是："+".//*[@id='toCheckOut']";
		printLog(message);
		return ButtonToCart;
	}
	
	/**
	 * 负责打印日志的方法。
	 * @author 700sfriend
	 * @param message
	 */
	public static void printLog(String message){
		log.info("########");
		log.info(message);
		log.info("########");
	}

	

}

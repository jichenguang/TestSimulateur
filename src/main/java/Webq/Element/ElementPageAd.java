package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.forLoggerPage;


/**
 * 常量类：广告活动页面的元素。
 * @author 700sfriend
 *
 */

public class ElementPageAd {
	
	protected static forLoggerPage log = new forLoggerPage(ElementPageCart.class);
	static String message = null;
	
	/**
	 * 购物车所有元素
	 */
	public static WebElement SellOnceButton = null;
	/**
	 * 获取“立即购买”按钮
	 * @param cartDriver
	 * @return
	 */
	public  static WebElement getSellOnceButton(WebDriver cartDriver){
		SellOnceButton = cartDriver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/a"));
		message = "元素名称是："+SellOnceButton.getText()+"  "+"获取的元素路径是："+"html/body/div[2]/div/div/div[2]/a";
		printLog(message);
		return SellOnceButton ;	
	}

	public  static WebElement getSellOnceButtonWap(WebDriver cartDriver,String btn){
		SellOnceButton = cartDriver.findElement(By.xpath(btn));
		message = "元素名称是："+SellOnceButton.getText()+"  "+"获取的元素路径是："+btn;
		printLog(message);
		return SellOnceButton ;	
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

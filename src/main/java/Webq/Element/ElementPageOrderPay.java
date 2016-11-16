package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.PageOrder;
import Webq.Page.forLoggerPage;


/**
 * 常量类：支付页面的所有元素
 * @author 700sfriend
 *
 */

public class ElementPageOrderPay {

	protected static forLoggerPage log = new forLoggerPage(ElementPageOrderPay.class);
	static String message = null;

	
	
	/**
	 * 支付页面所有元素
	 */
	private static WebElement PageTextPay = null;
	private static By OrderPayDriver;

	
	
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
	
	
	/**
	 * 获取支付页面的元素
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getPageTextPay(WebDriver orderPayDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='ContentPlaceHolder1_btnPay']";
		PageTextPay = orderPayDriver.findElement(By.xpath(str));
		message = "元素名称是："+PageTextPay.getText()+"  "+str;
		printLog(message);
		return PageTextPay;
	}
	
	

}


package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.forLoggerPage;

/**
 * 常量类：结算页的元素
 * @author 700sfriend
 *
 */
public class ElementPageOrder {
	
	protected static forLoggerPage log = new forLoggerPage(ElementPageOrder.class);
	static String message = null;
	
	/**
	 * 订单页面的元素
	 */
	private static WebElement ButtonSubOrder = null;
	private static WebElement TextYouHui = null;
	private static WebElement LinkFromPic;

	
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
	 * 获取订单提交按钮
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getButtonSubOrder(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='submitsection']";
		ButtonSubOrder = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonSubOrder.getText()+"  "+"获取的元素路径是："+str;
		printLog(message);
		return ButtonSubOrder;
	}
	
	public static WebElement getButtonSubOrderWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='divSubmitOrder']";
		ButtonSubOrder = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonSubOrder.getText()+"  "+"获取的元素路径是："+str;
		printLog(message);
		return ButtonSubOrder;
	}

	public static WebElement getTextYouHui(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@class='order_list_title']";
		TextYouHui = orderDriver.findElement(By.xpath(str));
		message =  "元素名称是："+TextYouHui.getText()+"  "+"获取的元素路径是："+str;	
		return TextYouHui;
	}

	public static WebElement getLinkFromPic(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='order']/table/tbody/tr/td[1]/a";
		LinkFromPic = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+LinkFromPic.getTagName()+"  "+"获取的元素路径是："+str;	
		return LinkFromPic;
	}
	
	

	
}

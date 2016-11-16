package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.PageOrder;
import Webq.Page.forLoggerPage;

/**
 * 常量类：订单详情页面的所有元素
 * @author 700sfriend
 *
 */
public class ElementPageOrderDetails {
	
	
	protected static forLoggerPage log = new forLoggerPage(ElementPageOrderDetails.class);
	static String message = null;
	
	/**
	 * 订单详情的所有元素
	 */
	private static WebElement OrderNum = null;
	private static WebElement ButtonCancleOrder = null;
	private static WebElement ButtonAccept = null;
	private static WebElement OrderStatus = null;
	
	/**
	 * 订单详情的页面Tittle
	 */
	public static String strOrderDetails = "订单详情 - 700Store";
	
	
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
	 * 在订单详情中获取订单号
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getOrderNum(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='orderNumber']";
		OrderNum = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+OrderNum.getText()+"  "+str;
		printLog(message);
		return OrderNum;
	}
	
	public static WebElement  getOrderNumWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub	
		String str = ".//*[@id='spanOrderNumber']";
		OrderNum = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+OrderNum.getText()+"  "+str;
		printLog(message);
		return OrderNum;
	}

	

	/**
	 * 获取取消订单按钮
	 * @param orderDriver
	 * @return
	 */
	
	public static WebElement getButtonCancleOrder(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='btnCancelOrder']";
		ButtonCancleOrder = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonCancleOrder.getText()+"  "+str;
		printLog(message);
		return ButtonCancleOrder;
	}
	
	public static WebElement getButtonCancleOrderWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@class='btn cancel_order_btn']";
		ButtonCancleOrder = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonCancleOrder.getText()+"  "+str;
		printLog(message);
		return ButtonCancleOrder;
	}
	
	
	/**
	 * 获取接受按钮
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getButtonAccept(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='btnDialogBySHFConfirm']";
		ButtonAccept = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonAccept.getText()+"  "+str;
		printLog(message);
		return ButtonAccept;
	}
	
	
	public static WebElement getButtonAcceptWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='btnDialogBySHFConfirm']";
		ButtonAccept = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonAccept.getText()+"  "+str;
		printLog(message);
		return ButtonAccept;
	}
	
	/**
	 * 获取订单状态的元素
	 * @param orderDriver
	 * @return
	 */
	
	 public static WebElement getOrderStatus(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='orderStatus']";
		OrderStatus = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+OrderStatus.getText()+"  "+str;
		printLog(message);
		return OrderStatus;
	}
	 
	 
	 public static WebElement getOrderStatusWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='spanStatus']";
		OrderStatus = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+OrderStatus.getText()+"  "+str;
		printLog(message);
		return OrderStatus;
	}
	
	
	
}

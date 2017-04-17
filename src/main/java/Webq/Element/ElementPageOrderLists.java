package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.PageOrder;
import Webq.Page.forLoggerPage;


/**
 * 常量类：订单列表页面的所有元素
 * @author 700sfriend
 *
 */
public class ElementPageOrderLists {
	
	
	protected static forLoggerPage log = new forLoggerPage(ElementPageOrderLists.class);
	static String message = null;
	
	/**
	 * 订单列表页面的所有元素
	 */
	private static WebElement PageTextPay = null;
	private static WebElement ButtonOrderDetails = null;
	
	
	/**
	 * 订单列表页面的Url
	 */
	public static String strUrl = "http://user.700store.com/orderlist";
	
	public static String strUrlWap = "http://user.700store.com/wap/orderlist";
	

	/**
	 * 订单列表的页面Tittle
	 */
	public static String strOrderLists = "订单列表 - 700Store";
	private static WebElement OrderNum;
	private static WebElement ButtonCancleOrder;
	private static WebElement ButtonAccept;
	private static WebElement OrderStatus;
	
	
	
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
	public static WebElement getPageTextPay(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='ContentPlaceHolder1_btnPay']";
		PageTextPay = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+PageTextPay.getText()+"  "+str;
		printLog(message);
		return PageTextPay;
	}
	
	/**
	 * 获取页面详情按钮
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getButtonOrderDetails(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='orderList']/div[1]/div[4]/div[3]/a";
		ButtonOrderDetails = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonOrderDetails.getText()+"  "+str;
		printLog(message);
		return ButtonOrderDetails;
	}
	
	public static WebElement getButtonOrderDetailsWap(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='orderList']/div[1]/div[1]/a";
		ButtonOrderDetails = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+ButtonOrderDetails.getText()+"  "+str;
		printLog(message);
		return ButtonOrderDetails;
	}



	public static WebElement getOrderNum(WebDriver orderDriver) {
		// TODO Auto-generated method stub	
		String str = ".//*[@id='orderNumber']";
		OrderNum = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+OrderNum.getText()+"  "+str;
		printLog(message);
		return OrderNum;
	}
	

	

	

}

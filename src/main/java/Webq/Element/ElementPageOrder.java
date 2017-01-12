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
	private static WebElement Address;
	private static WebElement AddressDef;
	private static WebElement TotalExpense;
	private static WebElement Shipping;
	private static WebElement couponCashBack;
	private static WebElement totalAmountPayable;

	
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
		String str = ".//*[@id='couponInfoSection']/div[1]";
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

	public static WebElement getAddress(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='address_box']/div[2]";
		Address = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+Address.getTagName()+"  "+"获取的元素路径是："+str;
		return Address;
	}

	public static WebElement getAddressDef(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='address_box']/div[2]/span[8]";
		AddressDef = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+AddressDef.getTagName()+"  "+"获取的元素路径是："+str;
		return AddressDef;
	}
	
	/**
	 * 总价
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getTotalExpense(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='totalExpense']";
		TotalExpense = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+TotalExpense.getTagName()+"  "+"获取的元素路径是："+str;
		return TotalExpense;
	}
	
	/**
	 * 运费
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getShipping(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='shipping']";
		Shipping = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+Shipping.getTagName()+"  "+"获取的元素路径是："+str;
		return Shipping;
	}

	/**
	 * 优惠及返现
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getCouponCashBack(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='couponCashBack']";
		couponCashBack = orderDriver.findElement(By.xpath(str));
		message = "元素名称是："+couponCashBack.getTagName()+"  "+"获取的元素路径是："+str;
		return couponCashBack;
	}

	/**
	 * 应付金额
	 * @param orderDriver
	 * @return
	 */
	public static WebElement getAmountPayable(WebDriver orderDriver) {
		// TODO Auto-generated method stub
		String str = ".//*[@id='totalAmountPayable']";
		totalAmountPayable = orderDriver.findElement(By.xpath(str));
		message = "元素名称是：" + totalAmountPayable.getTagName()+"  "+"获取的元素路径是："+str;
		return totalAmountPayable;
	}
	
	

	
}

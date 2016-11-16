package Webq.Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageOrderPay;

public class PageOrderPay {

	static WebDriver OrderPayDriver;
	static JavascriptExecutor jse; 	
	
	
	/**
	 * 支付页的Action
	 * @param driver
	 * @throws InterruptedException 
	 */
	public static void PlOrderPay(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderPayDriver = driver;
		jse= (JavascriptExecutor)driver; 
		
//		点击结算页“提交”按钮；
//		PageOrder.subOrder();
//		获取支付页面文案；
		getTextPayPage();
//		检查是否提交成功；
		checkOrder();
		Thread.sleep(3000);
	}
	
	
	public static void PlOrderPayWap(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderPayDriver = driver;
		jse= (JavascriptExecutor)driver; 
		

//		获取支付页面文案；
		getTextPayPageWap();
//		检查是否提交成功；
		checkOrder();
		Thread.sleep(3000);
	}
	
	
	
	/**
	 * action:进入支付页面，获取支付页面的提示文案
	 * @param driver
	 * @return
	 */	 
	public static WebElement getTextPayPage() {
		// TODO Auto-generated method stub
		System.out.println("进入支付页面");
		WebElement PageTextPay = ElementPageOrderPay.getPageTextPay(OrderPayDriver);		
//		PageTextPay.click();
		jse.executeScript("arguments[0].click();",PageTextPay); 
		return PageTextPay;
	}
	
	public static WebElement getTextPayPageWap() {
		// TODO Auto-generated method stub
		System.out.println("进入WAP支付页面");
		WebElement PageTextPay = ElementPageOrderPay.getPageTextPay(OrderPayDriver);		
//		PageTextPay.click();
		jse.executeScript("arguments[0].click();",PageTextPay); 
		return PageTextPay;
	}
	
	

   /**
	 * action:通过支付页面的文案，判断是否提交成功。
	 * @param driver
	 */		
	public static void checkOrder() {
		// TODO Auto-generated method stub
		if(getTextPayPage()!=null){
			System.out.println("订单提交成功！");
		}else{
			System.out.println("订单提交失败！");
		}
	}
	

}

package Webq.Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Webq.Element.ElementPageOrder;

public class PageOrder {
	
	
	static WebDriver OrderDriver;
	static JavascriptExecutor jse; 
	
	
	/**
	 * 保留这里的Action,方便以后调用。
	 * 结算页里的Action
	 * @param driver
	 * @throws InterruptedException 
	 */
	public static void PlOrder(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderDriver = driver;
		jse= (JavascriptExecutor)driver; 
		
		/*优惠信息，检查是否支持优惠信息选项*/
		checkYouHui();
		/*商品清单，检查商品图片信息*/
		checkLinkFromPic();
//		点击结算页“提交”按钮；
		subOrder();
//		获取支付页面文案；
//		PageOrderPay.TextPayPage();
//		检查是否提交成功；
//		PageOrderPay.checkOrder();		
	}


	public static void PlOrderWap(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderDriver = driver;
		jse= (JavascriptExecutor)driver; 
		
//		点击结算页“提交”按钮；
		subOrderWap();	
	}

	
	private static void checkYouHui() {
		// TODO Auto-generated method stub
		System.out.println("检查优惠信息是否生效");
		WebElement TextYouHui =  ElementPageOrder.getTextYouHui(OrderDriver);
		String Checkor = TextYouHui.getText();
		Assert.assertEquals(Checkor, "优惠信息");
	}


	private static void checkLinkFromPic() {
		// TODO Auto-generated method stub
		System.out.println("检查商品清单的链接");
		WebElement LinkFromPic  =   ElementPageOrder.getLinkFromPic(OrderDriver);
		String TextLink = LinkFromPic.getAttribute("href").toString();
		String ExcepedStr = "http://webq.700paper.cn/booking/15641.html";
		Assert.assertEquals(TextLink, ExcepedStr,"img商品链接不一致");
	}
	
	
	
	/**
	 * action:提交订单
	 * @param driver
	 * @throws InterruptedException 
	 */
	public static void subOrder() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("已经进入结算页面");
		Thread.sleep(3000);
		WebElement ButtonSubOrder = ElementPageOrder.getButtonSubOrder(OrderDriver);
//		ButtonSubOrder.click();
		jse.executeScript("arguments[0].click();", ButtonSubOrder); 
	}
	
	public static void subOrderWap() {
		// TODO Auto-generated method stub
		System.out.println("已经进入WAP结算页面");
		WebElement ButtonSubOrder = ElementPageOrder.getButtonSubOrderWap(OrderDriver);
//		ButtonSubOrder.click();
		jse.executeScript("arguments[0].click();", ButtonSubOrder); 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

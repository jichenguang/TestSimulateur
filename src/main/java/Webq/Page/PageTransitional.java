package Webq.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageTransitional;


public class PageTransitional {

		static WebDriver cartDriver; 
		static JavascriptExecutor jse; 
		/**
		 * @author 700sfriend
		 * 这个log必须是静态的，那么我只能用PageCart.class来取代ew Log(this.getClass())的写法。
		 * 效果是一样的。
		 */	
		protected static forLoggerPage log = new forLoggerPage(PageTransitional.class);
		
		
		
		/**
		 * 过度页面的所有操作
		 * @param driver
		 * @throws InterruptedException
		 */		
		public static void PlTransitional(WebDriver driver) throws InterruptedException {
			// TODO Auto-generated method stub	
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			cartDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			CartSuccess();
			IsOverCart();
			ToCart();
		}


		/**
		 * action:过渡页：加入购物车成功页
		 * @param cartDriver
		 */
		public static WebElement CartSuccess() {
		// TODO Auto-generated method stub
			cartDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			WebElement checkText = ElementPageTransitional.getCheckText(cartDriver);			
			return checkText;		   
		}
		


		/**
		 *  action:过渡页，判断是否加入成功
		 * 
		 */
		public static void IsOverCart() {
		// TODO Auto-generated method stub
			String Textsuc = "商品已经成功加入购物车！";
			if(CartSuccess().toString().equals(Textsuc)){
				System.out.println("加入购物车成功");
			}
		}
		
		
		
		/**
		 * action:过渡页，进入购物车
		 * @param driver
		 */
		public static void ToCart() {
		// TODO Auto-generated method stub			
			WebElement ButtonToCart = ElementPageTransitional.getButtonToCart(cartDriver);			
			if(ButtonToCart!=null){
			System.out.println("点击去购物车:"+ButtonToCart.getText());
			jse.executeScript("arguments[0].click();", ButtonToCart); 
			}else{
				System.out.println("没去成购物车");
			}
		}
		
		
	
}

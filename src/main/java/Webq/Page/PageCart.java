package Webq.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageAd;
import Webq.Element.ElementPageCart;
import Webq.Element.ElementPageProduct;
import Webq.Element.ElementPageTransitional;


public class PageCart {
		
	
		static PageLogin loginPage;
		static WebDriver cartDriver; 
		static JavascriptExecutor jse; 
		/**
		 * @author 700sfriend
		 * 这个log必须是静态的，那么我只能用PageCart.class来取代ew Log(this.getClass())的写法。
		 * 效果是一样的。
		 */	
		protected static forLoggerPage log = new forLoggerPage(PageCart.class);
		
		
		
		/**
		 * 购物车页面的所有操作
		 * @param driver
		 * @throws InterruptedException
		 */		
		public static  void PlCart(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			
			/*购物车流程*/	
			CartCrease();
			CartToOrder();	
			//CartDelAll();
		}
	
		public  static void CartDelAll() {
			// TODO Auto-generated method stub
			cartDriver.findElement(By.xpath(".//*[@id='cart-del']")).click();
			cartDriver.findElement(By.xpath(".//*[@id='btnDialogBySHFConfirm']")).click();
		}

		public static  void PlCartWap(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			

			/*购物车流程*/		
			CartCreaseWap();
			CartToOrder();		
		}
		
		
		
		/**
		 * 购物车:控制数量加减的方法
		 * 			decrease -
		 * 			increase +
		 */
		private static void CartCrease() {
			// TODO Auto-generated method stub
			/*ElementPageCart.getBasePathElementCartList(cartDriver);*/
			ElementPageCart elemPageCart = new ElementPageCart(cartDriver);
			WebElement ButtonIncrease = elemPageCart.getButtonIncrease();
			WebElement ButtonDecrease = elemPageCart.getButtoDecrease();
			if(ButtonDecrease.getText()!=null&ButtonIncrease.getText()!=null){
				log.info("增加商品的数量为1");
				try{
					Thread.sleep(1000);
					jse.executeScript("arguments[0].click();", ButtonIncrease);
				}catch(Exception e){
					log.error("增加商品失败！");
				}
				log.info("减少商品的数量为1");	
				try{
					Thread.sleep(1000);
					jse.executeScript("arguments[0].click();", ButtonDecrease);	
				}catch(Exception e){
					log.error("减少商品失败！");
				}
			}		
		}
		
		
		
		private static void CartCreaseWap() {
			// TODO Auto-generated method stub
			/*ElementPageCart.getBasePathElementCartList(cartDriver);*/
			ElementPageCart elemPageCart = new ElementPageCart(cartDriver);
			WebElement ButtonIncrease = elemPageCart.getButtonIncrease();
			WebElement ButtonDecrease = elemPageCart.getButtoDecrease();
			if(ButtonDecrease.getText()!=null&ButtonIncrease.getText()!=null){
				log.info("增加商品的数量为1");
				try{
					Thread.sleep(1000);
					jse.executeScript("arguments[0].click();", ButtonIncrease);
				}catch(Exception e){
					log.error("增加商品失败！");
				}
				log.info("减少商品的数量为1");	
				try{
					Thread.sleep(1000);
					jse.executeScript("arguments[0].click();", ButtonDecrease);	
				}catch(Exception e){
					log.error("减少商品失败！");
				}
			}		
		}

		
		/**
		 * action:从购物车去结算页
		 * @param driver
		 * @throws InterruptedException 
		 */

		public static void CartToOrder() throws InterruptedException {
		// TODO Auto-generated method stub
			System.out.println("点击“去结算”");
			WebElement ButtonCartToOrder = ElementPageCart.getButtonCartToOrder(cartDriver);
//			ButtonCartToOrder.click();
//			cartDriver.manage().wait(3000);
			jse.executeScript("arguments[0].click();", ButtonCartToOrder); 
		}
}

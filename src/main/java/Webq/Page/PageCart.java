package Webq.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import Webq.Element.ElementPageAd;
import Webq.Element.ElementPageCart;
import Webq.Element.ElementPageProduct;
import Webq.Element.ElementPageTransitional;



public class PageCart {
		
		/*页面类三大基本元素*/
		static PageLogin loginPage;
		static WebDriver cartDriver; 
		static JavascriptExecutor jse; 
		/**
		 * @author 700sfriend
		 * 这个log必须是静态的，那么我只能用PageCart.class来取代new Log(this.getClass())的写法。
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
			/*方法集：购物车流程*/	
			CartCrease();
			CartToOrder();	
		}
		
		public static  void PlCartWap(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			/*购物车流程*/		
			CartCreaseWap();
			CartToOrderWap();		
		}
		
		/**
		 * 清除购物车，防止商品库存超量
		 * 先判断是否为空
		 * 再判断是否需要清空
		 * @param driver
		 * @throws InterruptedException 
		 */
		public static void ClearCart(WebDriver driver) throws InterruptedException{			
			cartDriver = driver;			
			cartDriver.get("http://webq.700paper.cn/cart");
			
			if(CartNotFull(cartDriver)==true){
				log.info("购物车为空，不需要清空");
			}else{
				CartDelAll(cartDriver);
				Assert.assertTrue(CartNotFull(cartDriver), "已清空");
				log.info("预置条件：购物车已清空");
			}
			cartDriver.get("http://webq.700paper.cn/index");
		}

		/**
		 * 通过判断页面的内容信息是否出现，来判断购物车是否为空。
		 * true:如果该元素出现，那么购物车为空
		 * false:如果该元素没出现，那么购物车不为空
		 * @param driver
		 * @return isEmpty
		 * @throws InterruptedException 
		 */
		public static Boolean CartNotFull(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			/*购物车为空的节点是否出现呢*/
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			Boolean isEmpty = cartDriver.findElement(By.xpath(".//*[@id='cartIsEmpty']")).isDisplayed();
			return isEmpty;	
		}

		/**
		 * 删除购物车的所有商品
		 * @param driver
		 */
		public  static void CartDelAll(WebDriver driver) {
			// TODO Auto-generated method stub
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			driver.manage().timeouts();
			log.info("清除购物车");
			WebElement ButtonDelAll = cartDriver.findElement(By.xpath(".//*[@id='cart-del']"));
			log.info("选择的按钮是:"+ButtonDelAll.getText());
			jse.executeScript("arguments[0].click();", ButtonDelAll);
			WebElement ButtonConfirm = cartDriver.findElement(By.xpath(".//*[@id='DialogBySHF']")).findElement(By.xpath(".//*[@id='btnDialogBySHFConfirm']"));
			jse.executeScript("arguments[0].click();", ButtonConfirm);

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
			WebElement ButtonIncrease = elemPageCart.getButtonIncreaseWap();
			WebElement ButtonDecrease = elemPageCart.getButtoDecreaseWap();
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
			Thread.sleep(3000);
			WebElement ButtonCartToOrder = ElementPageCart.getButtonCartToOrder(cartDriver);
//			ButtonCartToOrder.click();
//			cartDriver.manage().wait(3000);
			jse.executeScript("arguments[0].click();", ButtonCartToOrder); 
		}
		
		public static void CartToOrderWap() throws InterruptedException {
		// TODO Auto-generated method stub
			System.out.println("点击“去结算”");
			WebElement ButtonCartToOrder = ElementPageCart.getButtonCartToOrderWap(cartDriver);
			ButtonCartToOrder.click();
//			cartDriver.manage().wait(3000);
//			jse.executeScript("arguments[0].click();", ButtonCartToOrder); 
		}
}

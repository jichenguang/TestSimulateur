package Webq.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageAd;
import Webq.Element.ElementPageCart;
import Webq.Element.ElementPageProduct;
import Webq.Element.ElementPageTransitional;


public class PageAd {
		
	
		static WebDriver cartDriver; 
		static JavascriptExecutor jse; 
		/**
		 * @author 700sfriend
		 * 这个log必须是静态的，那么我只能用PageCart.class来取代ew Log(this.getClass())的写法。
		 * 效果是一样的。
		 */	
		protected static forLoggerPage log = new forLoggerPage(PageAd.class);
		
		
		
		/**
		 * 购物车页面的所有操作
		 * @param driver
		 * @throws InterruptedException
		 */		
		public static void PlCartAd(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			/*购物车流程*/
			/**
			 * @author 700sfriend
			 * 这一句等待的代码，是我尝试写在这里的。之前没有这句代码的的时候，代码走到这里总是报超时错误。
			 * @time  2016-11-30
			 */
			cartDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openProductAd();
			checkSellOnce();			
		}
		
		public static void PlCartAdWap(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			/*商品广告页流程*/
			/**
			 * @author 700sfriend
			 * 这一句等待的代码，是我尝试写在这里的。之前没有这句代码的的时候，代码走到这里总是报超时错误。
			 * @time  2016-11-30
			 */
			cartDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openProductAdWap();
			checkSellOnceWap();			
		}

		/**
		 * action:打开商品页
		 * @param driver
		 */
		public static  void openProductAd() {
			// TODO Auto-generated method stub
	//		进入后街页面		
			String houjie = "http://www.700store.com/houjie";
			cartDriver.get(houjie);
			log.info("#############################################");
			log.info(houjie);
			log.info("#############################################");
		}
		
		public static  void openProductAdWap() throws InterruptedException {
			// TODO Auto-generated method stub
	//		进入美术馆页面		
			String 	houjie = "http://www.700store.com/wap/houjie";
			cartDriver.get(houjie);
			log.info("#############################################");
			log.info(houjie);
			log.info("#############################################");
		}
	
		
		/**
		 * PageAd:立即购买
		 * @throws InterruptedException 
		 */		
		public static void checkSellOnce() throws InterruptedException {
			// TODO Auto-generated method stub
//			立即购买按钮
			WebElement SellOnceButton = ElementPageAd.getSellOnceButton(cartDriver);	
			if(SellOnceButton.getText()!=null){
				System.out.println("点击："+SellOnceButton.getText());
				jse.executeScript("arguments[0].click();", SellOnceButton);
			}			
		}
		
		public static void checkSellOnceWap() throws InterruptedException {
			// TODO Auto-generated method stub
			String lolbtn = "html/body/div[1]/div/div[2]/a";
//			立即购买按钮
			WebElement SellOnceButton = ElementPageAd.getSellOnceButtonWap(cartDriver,lolbtn);	
			if(SellOnceButton.getText()!=null){
				System.out.println("点击："+SellOnceButton.getText());
				SellOnceButton.click();
//				jse.executeScript("arguments[0].click();", SellOnceButton);

			}			
		}
		
}

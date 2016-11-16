package Webq.Page;

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
			openProductAd();
			checkSellOnce();			
		}
		
		public static void PlCartAdWap(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			/*商品广告页流程*/
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
//			String houjieUrl = "http://webq.700paper.cn/houjie";
			String meishuguan = "http://webq.700paper.cn/meishuguan";
			cartDriver.get(meishuguan);
			log.info("#############################################");
			log.info(meishuguan);
			log.info("#############################################");
		}
		
		public static  void openProductAdWap() throws InterruptedException {
			// TODO Auto-generated method stub
	//		进入美术馆页面		
			String meishuguan = "http://webq.700paper.cn/wap/meishuguan";
			Thread.sleep(1000);
			cartDriver.get(meishuguan);
			log.info("#############################################");
			log.info(meishuguan);
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
			String lolbtn = ".//div[@class = 'buy-btn']";
//			立即购买按钮
			WebElement SellOnceButton = ElementPageAd.getSellOnceButtonWap(cartDriver,lolbtn);	
			if(SellOnceButton.getText()!=null){
				System.out.println("点击："+SellOnceButton.getText());
				SellOnceButton.click();
//				jse.executeScript("arguments[0].click();", SellOnceButton);

			}			
		}
		
}

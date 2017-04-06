package Webq.Page;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageProduct;
import Webq.MatterDo.DoCrumb;

public class PageProduct {

		static WebDriver cartDriver; 
		static JavascriptExecutor jse = null; 
		/**
		 * @author 700sfriend
		 * 这个log必须是静态的，那么我只能用PageCart.class来取代ew Log(this.getClass())的写法。
		 * 效果是一样的。
		 */	
		protected static forLoggerPage log = new forLoggerPage(PageProduct.class);
		
		
		
		/**
		 * 检查产品详情页的面包屑
		 * @param driver
		 * @throws InterruptedException
		 */		
		public static  void PlCartProduct(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			try{
				DoCheckCrumb();
				}catch(Exception e){
				log.error("获取面包屑失败");
				}
			
			DoCheckStatesStock();
			DoButtonAddCart();				
		}
		
		/**
		 * 检查产品详情页的面包屑
		 * @param driver
		 * @throws InterruptedException
		 */		
		public static  void PlCartProductWap(WebDriver driver) throws InterruptedException{
			cartDriver = driver;
			jse = (JavascriptExecutor)driver; 
			
			try{
				DoCheckCrumb();
				}catch(Exception e){
				log.error("获取面包屑失败");
				}
			
//			System.out.println("拍错代码拍错代码拍错代码拍错代码拍错代码");
			DoCheckStatesStock();
			DoButtonAddCartWap();
			
			/*
			 * WAP版本，需要人为跳转WAP购物车
			 */
			String cartWapUrl = "http://webq.700paper.cn/wap/cart";
			cartDriver.get(cartWapUrl);
			log.debug("跳转到购物车页");
	
		}
	


		
		/*
		 * 业务操作：面包屑
		 */
		private static void DoCheckCrumb() throws InterruptedException {
			// TODO Auto-generated method stub

			DoCrumb doCrumb = new DoCrumb(cartDriver);	
			doCrumb.actMatterCrumb();
			PageAd.checkSellOnce();
		}





		/**
		 * PageProduct:商品详情页，加入购物车
		 * @param driver
		 * @throws InterruptedException 
		 */
		public static void DoButtonAddCart() throws InterruptedException{
			WebElement addcartButton = ElementPageProduct.getAddcartButton(cartDriver);
			if(addcartButton.getText()!=null){
			System.out.println("点击:"+addcartButton.getText());	
			jse.executeScript("arguments[0].click();", addcartButton); 
			log.info("已经点击加入购物车按钮");
			}
		}

		public static void DoButtonAddCartWap() throws InterruptedException{
			WebElement addcartButtonWap = ElementPageProduct.getAddcartButtonWap(cartDriver);
			if(addcartButtonWap.getText()!=null){
			System.out.println("点击:"+addcartButtonWap.getText());	
			jse.executeScript("arguments[0].click();", addcartButtonWap); 
			log.info("已经点击加入购物车按钮");
			}
		}
		
		
		/**
		 * PageProduct:商品详情页,判断库存不足
		 * @return 
		 * @throws InterruptedException 
		 */
		public static Boolean IsButtonNoEnunghPr() throws InterruptedException{				
			
			ElementPageProduct elemPagePro = new ElementPageProduct(cartDriver);
			WebElement buttonNoEnunghpr = elemPagePro.getButtonNoEnunghPr();
			WebElement buttonSorryText = elemPagePro.getTextSorryCart();
			
			
			if(buttonNoEnunghpr.getAttribute("style").toString()!="display: none;"){
				Thread.sleep(1000);
				log.info(buttonSorryText.getText());
				return true;
				}else{
					log.info("库存信息正常。");
					return false;
					}			
		};
		
		/**
		 * PageProduct:操作库存不足的对话框
		 */
		private static void clickYes() {
			// TODO Auto-generated method stub
			ElementPageProduct elemPagePro = new ElementPageProduct(cartDriver);
			WebElement buttonConfirm = elemPagePro.getButtonConfirm();
			jse.executeScript("arguments[0].click();", buttonConfirm);
		}
		
		
		/**
		 * PageProduct:处理库存不足信息
		 * @throws InterruptedException
		 */
		private static boolean StockPr() throws InterruptedException {
			// TODO Auto-generated method stub
			if(IsButtonNoEnunghPr()){
				clickYes();
				log.info("库存不足，正在重新选择商品！");
				return false;
			}else{
				log.info("库存充足！");
				return true;
			}			
		}

		
		
		/**
		 * PageProduct检查库存状态：当点击加入购物车以后，要检查库存状态。
		 * @throws InterruptedException
		 */
		private static void DoCheckStatesStock() throws InterruptedException {
			// TODO Auto-generated method stub
			/*如果没有出现库存对话框，那么直接去判断这个对话框对象，就会找不到对象的路径，所以加try*/
			try{
				if(StockPr()!=true){
					DocheckColer();
					//DoButtonAddCart();
				}else{
					log.info("商品库存状态正常。");
				}
			}catch(Exception e){
				log.error("商品库存状态无异常。");
			}			
		}
		
		
		/**
		 * 选择商品的颜色
		 * @throws InterruptedException 
		 */
		private static boolean DocheckColer() throws InterruptedException {
			// TODO Auto-generated method stub
			ElementPageProduct.getProductInfo(cartDriver);
			ElementPageProduct.getButtonColour(cartDriver);
			ElementPageProduct.getUlChooseColour(cartDriver);
			IsOpenListChooseColour();
			CheckOpenListColour(2);
			return true;
		}
		
		
		/**
		 * 判断颜色菜单是否已打开
		 */		
		public static boolean IsOpenListChooseColour(){
			if(ElementPageProduct.getUlChooseColour(cartDriver).getAttribute("style").contains("display: block")){									
				log.info("菜单已打开,请选择颜色");
				return true;
			}else{	
				log.info("菜单未打开");
				return false;
			}
		}
		
		
		
		/**
		 * 
		 * 点击菜单并选择颜色
		 * @return 
		 * @throws InterruptedException 
		 */		
		public static WebElement CheckOpenListColour(int m) throws InterruptedException{
			WebElement ColourChoosed;
			if (IsOpenListChooseColour()!=true){
				log.info("点击打开菜单");
				jse.executeScript("arguments[0].click();", ElementPageProduct.getButtonColour(cartDriver));
//				System.out.println(ElementPageProduct.getAllChooseColour(cartDriver).size());
				ArrayList<WebElement> Colours = ElementPageProduct.getAllChooseColour(cartDriver);
				System.err.println("###############");
				ColourChoosed = Colours.get(m);
				log.info("选择的颜色是： "+ColourChoosed.getAttribute("data-color"));
				System.err.println("###############");
				jse.executeScript("arguments[0].click();", ColourChoosed);
			}else{
				ColourChoosed = ElementPageProduct.getAllChooseColour(cartDriver).get(m);
				log.info("选择的颜色是： "+ColourChoosed.getAttribute("data-color"));
				jse.executeScript("arguments[0].click();", ColourChoosed);				
			}
			/**
			 * 选中颜色之后，再判断当前选中的是否与预期一致
			 */
			if(getCurrentColour(m,ColourChoosed)!= null){
				m = 0;
				return ColourChoosed;
			}else{
				m = 0;
				return null;
			}			
		}
		
		 /**
		  * 判断当前选中的颜色
		 * @param colourChoosed 
		  * 
		  */
		public static String getCurrentColour(int m, WebElement colourChoosed){
			String ColourCurrentString = null;			
			WebElement ColourCurrent;
			
			ColourCurrent = ElementPageProduct.getButtonColour(cartDriver);
			ColourCurrentString = ColourCurrent.getText();
			log.info("当前的颜色是：" + ColourCurrentString);
			if(ColourCurrentString.equals(colourChoosed.getText())|IsOpenListChooseColour()!=true){
				log.info("当前的颜色与选择的" + ColourCurrentString + "色一致！");
				return ColourCurrentString;
			}else{
				String failmessage = "选择的颜色与显示的颜色，不一致！";
				log.error(failmessage);
				return null;
			}			
		}
		
		/**
		 * 检查商品的预约预定状态是否是预定
		 * @param driver
		 * @throws InterruptedException 
		 */
		public static void PlCheckSubScribeState(WebDriver driver) throws InterruptedException {
			// TODO Auto-generated method stub
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			String ProUrl = "http://webq.700paper.cn/booking/18663.html";
			/*先打开商品链接*/
			try{
				cartDriver.get(ProUrl);
				log.info("商品链接正确！");
			}catch(Exception e){
				log.error("商品链接错误！"+ProUrl);
			}
			
			/*打开颜色表，选择颜色*/
			if (cartDriver.findElement(By.xpath(".//*[@id='buyMod']/div[5]/ul")).getAttribute("style").contains("display: block")!=true){
				log.info("点击'打开'菜单");
				Thread.sleep(1000);
				WebElement TedColor = cartDriver
						.findElement(By.xpath(".//*[@id='selecTedColor']"))
						.findElement(By.xpath("./span"));				
				jse.executeScript("arguments[0].click();",TedColor);
				Thread.sleep(5000);

				WebElement  DivBuyMod = cartDriver.findElement(By.xpath(".//div[@id='buyMod']"));
				List<WebElement> DivColors = DivBuyMod
						.findElement(By.xpath(".//div[5]"))
						.findElement(By.tagName("ul"))
						.findElements(By.tagName("li"));
				log.info("要选择什么颜色的代码？"+DivColors.get(1).getAttribute("data-color"));
				log.info("要选择什么颜色的汉字？"+DivColors.get(1).findElement(By.xpath("./span")).getAttribute("data-color"));
				jse.executeScript("arguments[0].click();", DivColors.get(1));
				Thread.sleep(5000);
				
				/*当前的颜色*/
				WebElement NowTedColor = cartDriver
						.findElement(By.xpath(".//*[@id='selecTedColor']"))
						.findElement(By.xpath("./span"));	
				log.info("做出选择后的当前颜色："+NowTedColor.getAttribute("data-color"));
			}else{		
				log.error("业务错误：颜色菜单未打开！");
			}
			
			/*检查库存状态*/
			/*当前库存元素*/
			WebElement BookOrder = cartDriver.findElement(By.xpath(".//*[@id = 'add_book_order']"));
			if(BookOrder.getAttribute("style").contains("display: block;")){
				String CheckText = BookOrder.getText();
				Assert.assertEquals("商品状态错误","预订", CheckText);
				log.info("测试通过,用例方法为:"+Thread.currentThread().getStackTrace()[1].getMethodName());
			}else{
				log.error("断言错误!用例方法为:"+Thread.currentThread().getStackTrace()[1].getMethodName());
			}		
		}
		
		/**
		 * 检查：当一个SKU某个颜色无货时，是否自动切换到另一个有货的颜色
		 * @param driver
		 * @param string 
		 * @param string2 
		 */
		public static void PlCheckAutoChangeSKU(WebDriver driver, String string, String string2) {
			// TODO Auto-generated method stub
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			String ProUrl = "http://webq.700paper.cn/booking/15723.html";
			/*先打开商品链接*/
			try{
				cartDriver.get(ProUrl);
				log.info("商品链接正确！");
			}catch(Exception e){
				log.error("商品链接错误！"+ProUrl);
			}
			
			/*当前的颜色*/
			WebElement NowTedColor = cartDriver
					.findElement(By.xpath(".//*[@id='selecTedColor']"))
					.findElement(By.xpath("./span"));	
			String StrNowTedColor = NowTedColor.getAttribute("data-color");
			log.info("当前有货SKU的颜色为："+StrNowTedColor);
			
			/*当前的add_cart按钮状态*/
			WebElement NowBtnCartAdd = cartDriver
					.findElement(By.xpath(".//*[@id='add_cart']"));
			String StrNowBtnCartAdd = NowBtnCartAdd.getText();
			log.info("当前add_cart的状态为:"+StrNowBtnCartAdd);
			
			/*使用外部参数进行结果判断，是否为预期*/
			Assert.assertEquals("默认显示颜色失败！", string, StrNowTedColor);	
			Assert.assertEquals("购物车按钮状态错误！", string2, StrNowBtnCartAdd);
		}

		/**
		 * 检查增加和减小数量是否正确
		 * @param driver
		 */
		public static void PlCheckChangeNum(WebDriver driver) {
			// TODO Auto-generated method stub
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			String ProUrl = "http://webq.700paper.cn/booking/15723.html";
			/*先打开商品链接*/
			try{
				cartDriver.get(ProUrl);
				log.info("商品链接正确！");
			}catch(Exception e){
				log.error("商品链接错误！"+ProUrl);
			}
			
			WebElement DivBuyInfo7 =  cartDriver
					.findElement(By.xpath(".//*[@id='buyMod']/div[7]"));
			WebElement DivInfoAdd = DivBuyInfo7
					.findElement(By.xpath(".//*[@class = 'buy-info-add']"));
			WebElement DivInfoLes = DivBuyInfo7
					.findElement(By.xpath(".//*[@class = 'buy-info-less']"));
			WebElement DivInfoInput = DivBuyInfo7
					.findElement(By.xpath(".//*[@id='currentProductNum']"));
			
			/*验证思路：使用改变后的数字-改变前的数字=1 这个公式*/
			int intBeforeClike = Integer.parseInt(DivInfoInput.getAttribute("value")) ;
			if(intBeforeClike >=1&intBeforeClike <5){
				DivInfoAdd.click();
				int intAfterClike = Integer.parseInt(DivInfoInput.getAttribute("value"));
				int intResult = intAfterClike - intBeforeClike;
				System.out.println(intAfterClike);
				System.out.println(intResult);
				Assert.assertTrue("计算结果不正确！", intResult == 0);
			}else if(intBeforeClike == 5){
				DivInfoLes.click();
				int intAfterClike = Integer.parseInt(DivInfoInput.getAttribute("value"));
				int intResult = intAfterClike - intBeforeClike;
				Assert.assertTrue("计算结果不正确！", intResult + 1 == 0);
			}
		}
		
		/**
		 * 检查商品详情页的数量和最小数量
		 * @param driver
		 */
		public static void PlCheckTopNum(WebDriver driver) {
			// TODO Auto-generated method stub
			cartDriver = driver;
			jse = (JavascriptExecutor)driver;
			
			String ProUrl = "http://webq.700paper.cn/booking/15723.html";
			/*先打开商品链接*/
			try{
				cartDriver.get(ProUrl);
				log.info("商品链接正确！");
			}catch(Exception e){
				log.error("商品链接错误！"+ProUrl);
			}
			
			WebElement DivBuyInfo7 =  cartDriver
					.findElement(By.xpath(".//*[@id='buyMod']/div[7]"));
			WebElement DivInfoAdd = DivBuyInfo7
					.findElement(By.xpath(".//*[@class = 'buy-info-add']"));
			WebElement DivInfoLes = DivBuyInfo7
					.findElement(By.xpath(".//*[@class = 'buy-info-less']"));
			WebElement DivInfoInput = DivBuyInfo7
					.findElement(By.xpath(".//*[@id='currentProductNum']"));
			/*验证思路：点击+号，如果大于5，则提示最大数量为5；点击减号，若为1，则提示最小数辆*/
			
		}


}

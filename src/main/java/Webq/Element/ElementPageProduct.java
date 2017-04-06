package Webq.Element;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Locator.WebqLocator;
import Webq.Matter.MatterMiddle;
import Webq.Page.forLoggerPage;


		/**
		 * 常量类：产品页面的元素。
		 * @author 700sfriend
		 *
		 */
		public class ElementPageProduct  {
		
			protected static forLoggerPage log = new forLoggerPage(ElementPageProduct.class);
			static String message = null;
			
			/**
			 * 商品页面的所有元素
			 * @author 700sfriend
			 */
			
			/**
			 * 加入购物车按钮
			 */
			private static WebElement addCartButton = null;

			
			/**
			 * 库存不足对话框的BaseXpath;
			 */
			private static String BaseXpathButtonNoEnunghPrPath = null;
			
			/**
			 * 库存不足对话框；
			 */
			public static WebElement ButtonNoEnunghPr = null;
			
			/**
			 * 对话框文本
			 */
			private static WebElement TextSorryCart = null;
			
			/**
			 * 确认按钮
			 */
			private static WebElement ButtonConfirm = null;
			
			/**
			 * 商品信息的BaseXpath;
			 */
			private static String BaseXpathProductInfoPath = null;
			
			/**
			 * 商品信息的Base元素
			 */
			private static WebElement ProductInfo;
			
			/**
			 * 商品信息-颜色的Base路径
			 */
			private static String BaseXpathButtonColour;
			
			/**
			 * 商品信息-颜色的Base路径
			 */			
			private static WebElement ButtonColourInfo;
			
			
			private static String PathUlChooseColour;
			private static WebElement UlChooseColour;
			private static ArrayList<WebElement> ColourChoosed = new ArrayList<WebElement>();;
			private static String PathColourChoosed;
			
			
			private static WebDriver pDriver = null;
			
		

			/**
			 * 构造函数
			 * @param cartDriver
			 */			
			public ElementPageProduct(WebDriver cartDriver) {
				// TODO Auto-generated constructor stub
				this.pDriver = cartDriver;
				
				ButtonNoEnunghPr = this.getButtonNoEnunghPr();
				TextSorryCart = this.getTextSorryCart();
				ButtonConfirm = this.getButtonConfirm();
			}
			
	
			
			
			
			/*
			 * 获取中间Div元素
			 * 元素的方法
			 * 
			 */
			public   WebElement getMiddleDiv(WebDriver cartDriver){
				WebElement middleDiv = cartDriver.findElement(By.xpath((new MatterMiddle(cartDriver)).getPathMiddleDiv()));	
				return middleDiv;
			}
			
			
			
			

			/**
			 * 获取“加入购物车”按钮
			 * @param cartDriver
			 * @return
			 */
			public static WebElement getAddcartButton(WebDriver cartDriver) {
				addCartButton  = cartDriver.findElement(By.xpath(".//*[@id='add_cart']"));
				message = "元素名称是："+addCartButton.getText()+"  "+"获取的元素路径是："+".//*[@id='add_cart']";
				printLog(message);
				return addCartButton ;	
			}
			
			public static WebElement getAddcartButtonWap(WebDriver cartDriver) {
				addCartButton  = cartDriver.findElement(By.xpath(".//*[@id='bottom-buy-cart']"));
				message = "元素名称是："+addCartButton.getText()+"  "+"获取的元素路径是："+".//*[@id='bottom-buy-cart']";
				printLog(message);
				return addCartButton ;	
			}
			
			
		
			/**
			 * 库存不足的对话框		
			 * @param cartDriver
			 * @return
			 */
			public WebElement getButtonNoEnunghPr() {
				// TODO Auto-generated method stub	
				BaseXpathButtonNoEnunghPrPath = ".//div[@class='popwin']";
				ButtonNoEnunghPr = pDriver.findElement(By.xpath(BaseXpathButtonNoEnunghPrPath));				
				message = "元素名称是："+ButtonNoEnunghPr.getAttribute("class")+" "+"获取的元素路径是："+ BaseXpathButtonNoEnunghPrPath;
				printLog(message);
				return ButtonNoEnunghPr;		
			}
			
			/**
			 * 库存不足对话框的内容
			 * @param cartDriver
			 * @return
			 */
			public WebElement getTextSorryCart(){
//				rowXpath+//span[@class="cart-oper"]
				String TextSorryCartPath = BaseXpathButtonNoEnunghPrPath + "//div[@class ='popwin-content']";
				TextSorryCart = pDriver.findElement(By.xpath(TextSorryCartPath));
				message = "元素名称是："+TextSorryCart.getText()+"  "+"获取的元素路径是："+ TextSorryCartPath;
				printLog(message);
				return TextSorryCart;		
			}  
			
			
			/**
			 * 库存不足对话框的确认按钮
			 * @param cartDriver
			 * @return
			 */
			public WebElement getButtonConfirm(){
//				ButtonConfirm = ButtonNoEnunghPr.findElement(By.className("popwin-btn"));
				String ButtonConfirmPath = BaseXpathButtonNoEnunghPrPath + "//div[@class = 'popwin-btn']";
				ButtonConfirm = pDriver.findElement(By.xpath(ButtonConfirmPath));
				message = "元素名称是："+ButtonConfirm.getText()+"  "+"获取的元素路径是："+ ButtonConfirmPath;
				printLog(message);
				return ButtonConfirm;		
			} 
		
			
			 /**
			  * 商品信息BaseXpath:BaseXpathProductInfo
			  * @param cartDriver
			  * @return
			  */
			public static WebElement getProductInfo(WebDriver cartDriver){
				BaseXpathProductInfoPath = ".//*[@id='buyMod']";
				ProductInfo = cartDriver.findElement(By.xpath(BaseXpathProductInfoPath));
				message = "元素名称是："+ProductInfo.getTagName() +"  "+"获取的元素路径是："+ BaseXpathProductInfoPath;
				printLog(message);
				return ProductInfo;					
			}
			
			/**
			 * 商品信息-颜色的BaseXpath
			 * @param cartDriver
			 * @return
			 */
			public static WebElement getButtonColour(WebDriver cartDriver){
				BaseXpathProductInfoPath = ".//*[@id='buyMod']";
				BaseXpathButtonColour = BaseXpathProductInfoPath + "//div[@id='selecTedColor']";
//				BaseXpathButtonColour = BaseXpathProductInfoPath + "//div[@class='buy-info']"+"//div[@id='selecTedColor']";
				ButtonColourInfo = cartDriver.findElement(By.xpath(BaseXpathButtonColour ));
				message = "元素名称是："+ButtonColourInfo.getText() +"  "+"获取的元素路径是："+ BaseXpathButtonColour;
				printLog(message);
				return ButtonColourInfo;																				
			}
			
			/**
			 * 商品信息-选颜色的菜单 
			 */
			public  static WebElement getUlChooseColour(WebDriver cartDriver){
				BaseXpathProductInfoPath = ".//*[@id='buyMod']";
				PathUlChooseColour = BaseXpathProductInfoPath + "//ul[@class='buy-info-list  buy-info-color-wrap buy-info-list-color']";				
				UlChooseColour = cartDriver.findElement(By.xpath(PathUlChooseColour));
				return UlChooseColour;				
			}
	        
	        
			
			/**
			 * 商品信息-颜色-所有的颜色
			 */
			public static ArrayList<WebElement> getAllChooseColour(WebDriver cartDriver){				
				/**
				 * 遍历一遍颜色
				 */
				/*获取颜色列表Ul的li的个数*/
				int numberColours = UlChooseColour.findElements(By.tagName("li")).size();
				printLog("numberColours:"+numberColours);
				
				
				for(int t=1;t<=numberColours;t++){
					PathColourChoosed = PathUlChooseColour+"//li["+t+"]//span";
					message = PathColourChoosed;
					printLog(message);
					WebElement ColourChooses = cartDriver.findElement(By.xpath(PathColourChoosed));	
					printLog("备选的颜色："+ColourChooses.getAttribute("data-color"));
					
					/* 添加元素 */ 
					ColourChoosed.add(ColourChooses);
				}
				return ColourChoosed;						
			}

			
			
			
			
			
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

	

}

package Webq.Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageOrderDetails;
import Webq.Element.ElementPageOrderLists;


public class PageOrderDetails {
	
	static WebDriver OrderDriver;
	static JavascriptExecutor jse; 
	
	
	/**
	 * @author 700sfriend
	 * 这个log必须是静态的，那么我只能用PageCart.class来取代ew Log(this.getClass())的写法。
	 * 效果是一样的。
	 */	
	protected static forLoggerPage log = new forLoggerPage(PageAd.class);
	
	/**
	 * 结算页里的Action
	 * @param driver
	 * @throws InterruptedException 
	 */
	public static void PlOrderDetail(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderDriver = driver;
		jse= (JavascriptExecutor)driver; 
		

//		获取订单号；
		getOrderNum();
//		取消订单
		CancleOrder();
		
	}
	
	public static void PlOrderDetailsWap(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderDriver = driver;
		jse= (JavascriptExecutor)driver; 		

//		获取订单号；
		getOrderNumWap();
//		取消订单
		CancleOrderWap();
		
	}
	
	
		/**
		 * 获取订单号
		 * @param driver
		 */	
		public static String getOrderNum() {
			// TODO Auto-generated method stub
			WebElement OrderNum = ElementPageOrderDetails.getOrderNum(OrderDriver);				
			String[] StringOrdernum = OrderNum.getText().split(":");
			String Ordernum = StringOrdernum[1];
			log.info("订单号："+Ordernum);
			return Ordernum;			
		}
		
		/**
		 * 获取订单号
		 * @param driver
		 */	
		public static String getOrderNumWap() {
			// TODO Auto-generated method stub
			WebElement OrderNum = ElementPageOrderDetails.getOrderNumWap(OrderDriver);				
			String Ordernum = OrderNum.getText();
			log.info("订单号："+Ordernum);
			return Ordernum;			
		}
		


		
		/**
		 * 在订单详情中取消订单。
		 * @throws InterruptedException 
		 */
		private static void CancleOrder() throws InterruptedException {
			// TODO Auto-generated method stub
			log.info("开始取消订单。");
//			先找到取消订单的按钮；
//			然后在判断是否取消成功；
			if(getOrderNum()!=null){
				/*由于Alert对话框，在这里使用的是一个DIV，不是原生的Alert,所以这里使用了JS操作。*/
				/*点击取消按钮*/
				WebElement ButtonCancleOrder = ElementPageOrderDetails.getButtonCancleOrder(OrderDriver);				
				if(iShasButtonCancleOrder(ButtonCancleOrder)){					
				jse.executeScript("arguments[0].click();",ButtonCancleOrder);
				Thread.sleep(3000);
				WebElement ButtonAccept = ElementPageOrderDetails.getButtonAccept(OrderDriver);				
				jse.executeScript("arguments[0].click();",ButtonAccept);
				}else{
					log.error("没找到取消按钮！");
				}				
				
//				Alert conform = OrderDriver.switchTo().alert();					
//				System.out.println(conform.getText());
//				Thread.sleep(3000);
//				conform.accept();
				Thread.sleep(3000);
				
				if(IsCancleSuccesful()){
//					System.out.println("订单取消成功！");
					log.info("订单取消成功！");
				}else{
//					System.out.println("订单取消失败！");
					log.error("订单取消失败！");
				}
				
			}
//			return false;
		}





		/**
		 * 判断是否找到取消按钮
		 * @param ButtonCancleOrder
		 * @return 
		 * @throws InterruptedException
		 */
		private static boolean iShasButtonCancleOrder(WebElement ButtonCancleOrder) throws InterruptedException {
			// TODO Auto-generated method stub
			if(ButtonCancleOrder!=null){
				String TextButtonCancleOrder = ButtonCancleOrder.getText();
				System.out.println(TextButtonCancleOrder);
				Thread.sleep(3000);	
				return true;
			}else{
				return false;
			}
		}

		/**
		 * 判断订单是否取消成功。
		 * @return 
		 */
		private static boolean IsCancleSuccesful() {
			// TODO Auto-generated method stub
			WebElement orderStatus = ElementPageOrderDetails.getOrderStatus(OrderDriver);			
			String myStatus = orderStatus.getText();
			System.out.println(myStatus);
			if(myStatus.equals("已取消")){
				return true;
			}else{
				return false;
			}	
		}
		
		private static boolean IsCancleSuccesfulWap() {
			// TODO Auto-generated method stub
			WebElement orderStatus = ElementPageOrderDetails.getOrderStatusWap(OrderDriver);			
			String myStatus = orderStatus.getText();
			System.out.println(myStatus);
			if(myStatus.equals("订单已取消")){
				return true;
			}else{
				return false;
			}	
		}
		
		
		/**
		 * 在订单详情中取消订单。
		 * @throws InterruptedException 
		 */
		private static void CancleOrderWap() throws InterruptedException {
			// TODO Auto-generated method stub
			log.info("开始取消订单。");
//			先找到取消订单的按钮；
//			然后在判断是否取消成功；
			if(getOrderNumWap()!=null){
				/*由于Alert对话框，在这里使用的是一个DIV，不是原生的Alert,所以这里使用了JS操作。*/
				/*点击取消按钮*/
				WebElement ButtonCancleOrder = ElementPageOrderDetails.getButtonCancleOrderWap(OrderDriver);				
				if(iShasButtonCancleOrderWap(ButtonCancleOrder)){					
				jse.executeScript("arguments[0].click();",ButtonCancleOrder);
//				ButtonCancleOrder.click();
				Thread.sleep(3000);
				
//				WebElement ButtonAccept = ElementPageOrderDetails.getButtonAcceptWap(OrderDriver);				
//				jse.executeScript("arguments[0].click();",ButtonAccept);
				
				/*
				 * WAP中使用的是原始的js弹出对话框。
				 */
				Alert alert = OrderDriver.switchTo().alert();
				alert.getText();
				alert.accept();			
				}else{
					log.error("没找到取消按钮！");
				}				
				
//				Alert conform = OrderDriver.switchTo().alert();					
//				System.out.println(conform.getText());
//				Thread.sleep(3000);
//				conform.accept();
				System.out.println("测试代码测试代码测试代码测试代码测试代码测试代码测试代码测试代码测试代码");
				Thread.sleep(3000);
				if(IsCancleSuccesfulWap()){
//					System.out.println("订单取消成功！");
					log.info("订单取消成功！");
				}else{
//					System.out.println("订单取消失败！");
					log.error("订单取消失败！");
				}
				
			}
//			return false;
		}


		/**
		 * 判断是否找到取消按钮
		 * @param ButtonCancleOrder
		 * @return 
		 * @throws InterruptedException
		 */
		private static boolean iShasButtonCancleOrderWap(WebElement ButtonCancleOrder) throws InterruptedException {
			// TODO Auto-generated method stub
			if(ButtonCancleOrder!=null){
				String TextButtonCancleOrder = ButtonCancleOrder.getText();
				System.out.println(TextButtonCancleOrder);
				Thread.sleep(3000);	
				return true;
			}else{
				return false;
			}
		}




}

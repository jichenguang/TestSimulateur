package Webq.Page;

import java.util.ArrayList;

import org.apache.maven.doxia.logging.Log;
import org.openqa.selenium.By;
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
		
		/*添加收货地址*/
		//AddAddress();
		/*收货地址*/
		checkAddress();
		/*商品清单，检查商品图片信息*/
		checkLinkFromPic();	
		/*优惠信息，检查是否支持优惠信息选项*/
		checkYouHui();
		/*价格信息，检查价格计算是否正确*/
		checkPrice();
		/*运费检查，根据收货地址：普通、8省、西藏，验证不同的订单运费*/
		checkOrderCarriage();		
//		点击结算页“提交”按钮；
		subOrder();
//		获取支付页面文案；
//		PageOrderPay.TextPayPage();
//		检查是否提交成功；
//		PageOrderPay.checkOrder();		
	}

	/*新用户添加新的收货地址*/
	private static void AddAddress() {
		// TODO Auto-generated method stub
		System.out.println("新用户需要先添加收货地址");
		
	}

	/**
	 * WAP方法
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void PlOrderWap(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		OrderDriver = driver;
		jse= (JavascriptExecutor)driver; 
		
		checkOrderCarriageWap();
//		点击结算页“提交”按钮；
		subOrderWap();	
	}

	/*增加一个步骤，针对自行车商品，根据收货地址：普通、8省、西藏，验证不同的订单运费*/
	private static void  checkOrderCarriage() {
		// TODO Auto-generated method stub	
		System.out.println("检查9省自行车商品的运费");
		/*选中的地址元素*/
		WebElement CurrentAdd = ElementPageOrder.getAddress(OrderDriver);		
		/*省份元素；*/
		WebElement proVince  =  ElementPageOrder.getAddressProVince(OrderDriver);
		/*运费元素；*/
		WebElement FeeCarriage = ElementPageOrder.getFeeCarriage(OrderDriver);
		
		/*思路：先遍历并选择地址，然后判断地址是否选中，然后判断这个地址的省份*/		
		checkChooseAddress();
		
		if(CurrentAdd.getAttribute("class").contains("current")){
			if(proVince.getText().contains("新疆")){		
				Assert.assertTrue(FeeCarriage.getText().equals("299.00"), "8省运费错误");
			}else if(proVince.getText().contains("西藏")){
				Assert.assertTrue(FeeCarriage.getText().equals("699.00"), "西藏运费错误");		
			}else if(proVince.getText().contains("北京")){
				Assert.assertTrue(FeeCarriage.getText().equals("99.00"), "普通运费错误");
			}
		}else{
			System.out.println("未选择收货地址！");
		}		
	}
	
	
	/*增加一个步骤，根据收货地址：普通、8省、西藏，验证不同的订单运费*/
	private static void  checkOrderCarriageWap() {
		// TODO Auto-generated method stub		
	}
	
	/**
	 * 遍历并选择收货地址
	 */
	public static void checkChooseAddress(){
		/*省份集合*/
		ArrayList<WebElement>  ProVinses = ElementPageOrder.getAllAddress(OrderDriver);
		for(int i=1; i<ProVinses.size();i++){
			WebElement testAdd = ProVinses.get(i);
			String testAddStr = testAdd.getText();
			if(testAddStr.equals("北京")||testAddStr.equals("新疆")||testAddStr.equals("西藏")){
				testAdd.click();				
			}else{
				System.out.println("无有效收货地址！");
			}
		}	
	}
	

	/**
	 * 检查收货地址是否显示
	 */
	private static void checkAddress() {
		// TODO Auto-generated method stub
		System.out.println("检查收货地址是否加载，并展示出来");
		WebElement Address = ElementPageOrder.getAddress(OrderDriver);
		if(Address.isDisplayed()){
			WebElement AddressDef = ElementPageOrder.getAddressDef(OrderDriver); 
			Assert.assertEquals(AddressDef.getText(), "默认", "错误！默认地址出错！");
		}else{
			System.err.println("错误！收货地址没有加载成功！");
		}
	}
	
	/**
	 * 检查价格信息是否计算正确
	 */
	private static void checkPrice() {
		// TODO Auto-generated method stub
		System.out.println("检查价格信息是否有效");
		double showTotalExpense = Double.parseDouble(ElementPageOrder.getTotalExpense(OrderDriver).getText());
		double showShipping = Double.parseDouble(ElementPageOrder.getShipping(OrderDriver).getText());
		double showCouponCashBack = Double.parseDouble(ElementPageOrder.getCouponCashBack(OrderDriver).getText());
		double showTotalAmountPayable = Double.parseDouble(ElementPageOrder.getAmountPayable(OrderDriver).getText());
		double Price = showTotalExpense + showShipping - showCouponCashBack;
		Assert.assertEquals(showTotalAmountPayable,Price,"错误！订单价格计算错误。");
	}
	
	
	/**
	 * 检查优惠信息
	 */
	private static void checkYouHui() {
		// TODO Auto-generated method stub
		System.out.println("检查优惠信息是否生效");
		WebElement TextYouHui =  ElementPageOrder.getTextYouHui(OrderDriver);
		String Checkor = TextYouHui.getText();
		Assert.assertEquals(Checkor, "优惠信息");
	}

	/**
	 * 检查商品img的链接
	 */
	private static void checkLinkFromPic() {
		// TODO Auto-generated method stub
		System.out.println("检查商品清单的链接");
		WebElement LinkFromPic  =   ElementPageOrder.getLinkFromPic(OrderDriver);
		String TextLink = LinkFromPic.getAttribute("href").toString();
		String ExcepedStr = "http://www.700store.com/booking/107001.html";
		Assert.assertEquals(TextLink, ExcepedStr,"Img商品链接不一致");
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

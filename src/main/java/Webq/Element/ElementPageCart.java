package Webq.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Page.forLoggerPage;


/**
 * 常量类：购物车页面的元素。
 * @author 700sfriend
 *
 */
public class ElementPageCart {
	
	/**
	 *  日志类
	 */
	protected static forLoggerPage log = new forLoggerPage(ElementPageCart.class);
	static String message = null;
	
	
	/**
	 * 购物车所有元素
	 */
	public static WebElement SellOnceButton = null;
	private static WebElement ButtonCartToOrder = null;
	private static WebElement ButtonDecrease;
	private static WebElement ButtonIncrease;
	public  static WebElement ElementCartList;
	private static String BasePathElementCartList;
	private static String PathCartProTable;
	private static WebElement ElementCartProTable;
	private static String PathCartProTabletr;
	private static WebElement ElementCartProTabletr;
	private static String BasePathCartList;
	/*这个cDriver一开始就要被初始化*/
	private static WebDriver cDriver = null;
	private static String PathCartProTableWap;
	private static WebElement ElementCartProTableWap;
	private static WebElement ElementCartProTabletrWap;
	
	
	/**
	 * 构造函数，用于初始化ElementPageCart,因为需要先初始化很多BasePath,才能使用相对路径寻找元素；
	 * @param cartDriver
	 */
	public ElementPageCart(WebDriver cartDriver){
		
		/*先选中内容后，再利用Ctr+command+/可以款苏使用这样的注释*/
		
		/*构造器主要完成了两件事，第一件是把driver初始化了。这样方法调用本类的方法时，本类方法可以直接调用本类的driver作为参数。*/
		/*在这里初始化一个driver后，下面的方法里，可以省去不再使用cartDriver参数。*/				
		this.cDriver = cartDriver;
				
		/*第二件事，就是用于初始化ElementPageCart,因为需要先初始化很多BasePath,才能使用相对路径寻找元素；*/
		ElementCartList = this.getBasePathElementCartList();
	

		try{
			ElementCartProTable = this.getPathCartProTable();
		    ElementCartProTabletr = this.getPathCartProTabletr();	
		}catch(Exception e){
			ElementCartProTableWap = this.getPathCartProTableWap();    
		    ElementCartProTabletrWap = this.getPathCartProTabletrWap();
		}
			
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


	
	/**
	 * 获取从购物车去结算页的元素
	 * @param cartDriver
	 * @return
	 */
	public static WebElement getButtonCartToOrder(WebDriver cartDriver) {
		// TODO Auto-generated method stub
		
		ButtonCartToOrder = cartDriver.findElement(By.xpath(".//*[@id='linkToPayPage']"));
		message = "元素名称是："+ButtonCartToOrder.getText()+"  "+"获取的元素路径是："+".//*[@id='linkToPayPage']";
		printLog(message);
		return ButtonCartToOrder;
	};
	
	
	/**
	 * 购物车的basepath:cartList
	 */
	public WebElement getBasePathElementCartList() {
		// TODO Auto-generated method stub
		BasePathCartList = ".//div[@id='cartList']";
		ElementCartList = cDriver.findElement(By.xpath(BasePathCartList));
		message = "元素名称是："+ElementCartList.getAttribute("class")+"  "+"获取的元素路径是："+BasePathCartList;
		printLog(message);
//		return BasePathElementCartList;
		return ElementCartList;
	}	

	
	
	/**
	 * 购物车的商品List:table
	 */
	public WebElement getPathCartProTable() {
		// TODO Auto-generated method stub
		/*相对路径的时候，不需要点*/
		PathCartProTable = BasePathCartList + "//table[@class = 'gridtable']";
		ElementCartProTable = cDriver.findElement(By.xpath(PathCartProTable));
		message = "元素名称是："+ElementCartProTable.getAttribute("class")+"  "+"获取的元素路径是："+PathCartProTable;
		printLog(message);
//		return PathCartProTable;
		return ElementCartProTable;
	}
	
	public WebElement getPathCartProTableWap() {
		// TODO Auto-generated method stub
		/*相对路径的时候，不需要点*/
		PathCartProTableWap = BasePathCartList + "//table[@class = 'cart gridtable']";
		ElementCartProTableWap = cDriver.findElement(By.xpath(PathCartProTableWap));
		message = "元素名称是："+ElementCartProTableWap.getAttribute("class")+"  "+"获取的元素路径是："+PathCartProTableWap;
		printLog(message);
//		return PathCartProTable;
		return ElementCartProTableWap;
	}	
	
	
	/**
	 * 购物车的商品tbody_tr
	 */
	public WebElement getPathCartProTabletr() {
		// TODO Auto-generated method stub
		int i = 2;
		PathCartProTabletr = PathCartProTable + "//tr["+i+"]";
		ElementCartProTabletr = cDriver.findElement(By.xpath(PathCartProTabletr));
		message = "元素名称是："+ElementCartProTabletr.getText()+"  "+"获取的元素路径是："+PathCartProTabletr;
		printLog(message);
//		return PathCartProTabletr;
		return ElementCartProTabletr;
	}
	
	public WebElement getPathCartProTabletrWap() {
		// TODO Auto-generated method stub
		int i = 2;
		PathCartProTabletr = PathCartProTableWap + "//tr["+i+"]";
		ElementCartProTabletr = cDriver.findElement(By.xpath(PathCartProTabletr));
		message = "元素名称是："+ElementCartProTabletr.getText()+"  "+"获取的元素路径是："+PathCartProTabletr;
		printLog(message);
//		return PathCartProTabletr;
		return ElementCartProTabletr;
	}
	
	/**
	 * 那个+号
	 * @param cartDriver
	 * @return
	 */
	public WebElement getButtonIncrease() {
		// TODO Auto-generated method stub
		String PathButtonIncrease = PathCartProTabletr+"//a[@class = 'cart-add']";
		ButtonIncrease = cDriver.findElement(By.xpath(PathButtonIncrease));
		message = "元素名称是："+ButtonIncrease.getAttribute("class")+"  "+"获取的元素路径是："+PathButtonIncrease;
		printLog(message);
		return ButtonIncrease;
	}


	/**
	 * 那个-号
	 * @param cartDriver
	 * @return
	 */
	public WebElement getButtoDecrease() {
		// TODO Auto-generated method stub	
		String PathButtonDecrease = PathCartProTabletr+"//a[@class = 'cart-sub']";
		ButtonDecrease = cDriver.findElement(By.xpath(PathButtonDecrease));
		message = "元素名称是："+ButtonDecrease.getAttribute("class")+"  "+"获取的元素路径是："+PathButtonDecrease;
		printLog(message);
		return ButtonDecrease;
	}

	

}

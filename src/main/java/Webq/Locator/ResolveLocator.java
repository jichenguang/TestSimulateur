package Webq.Locator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import Webq.Base.WebqBasePage;
import Webq.utils.Log;
import Webq.utils.WebqxmlUtils;


/**
 * 功能：从xml文件解析path string出来
 * @author 700sfriend
 *
 */

public class ResolveLocator  {
	
	protected WebDriver driver;
	/*locatorMap写在哪个类里，记载元素路径的外部文件名，就是这个类名*/
	public static HashMap<String, WebqLocator> locatorMap;
	String path;
	protected Log log = new Log(this.getClass());
	
	public ResolveLocator(){		
	}
	
	public ResolveLocator(WebDriver driver) throws Exception{
		this.driver = driver;
		log.debug(this.getClass().getCanonicalName());
		log.info(System.getProperty("user.dir"));
		// locatorMap = ReadExcelUtil.getLocatorMap();
		path = System.getProperty("user.dir")
				+ "/src/main/java/Webq/Locator/"
				+ this.getClass().getSimpleName() + ".xml";
		log.info(path);
		
		/**
		 * @author 700sfriend
		 * 从外部文件获取元素的定位位置
		 */
		locatorMap = WebqxmlUtils.readXMLDocument(path, this.getClass()
				.getCanonicalName());
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

	/**
	 * @author 700sfriend
	 * 返回一个对象,且是WebElement对象
	 * @param 一个对象
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, final WebqLocator locator) {
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver){
						try {
							return getElement(driver, locator);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							log.error("can't find element "
									+ locator.getElement());
							return null;
						}

					}

				});
		return element;

	}
	public WebElement getElement(WebqLocator locator) throws IOException {
		return getElement(this.getDriver(), locator);
	}
	
	/**
	 * get by parameter
	 * 返回一个WebElement对象
	 * @author Young
	 * @param driver
	 * @param locator
	 * @return
	 * @throws IOException
	 */
//	--Locator locator其实是传入的一个locator对象，根据这个对象的element属性,即名称，将给出元素路径
	public WebElement getElement(WebDriver driver, WebqLocator locator)
			throws IOException {
//		第一件事
//		locator.getElement() 获取元素的名称，即locatorname
//		getLocator()  将返回一个新的locator对象，这个对象是从locatormap中获取，获取依赖locatorname
		
		String locatorname =locator.getElement();
		WebqLocator newwebqlocator = getLocator(locatorname);
		log.debug("！元素名称是："+locatorname);
		log.debug("! 元素的路径是："+newwebqlocator.getElement());
		
		
//		第二件事
		WebElement e;
//		获取locator对象的元素类型，即xpath
		switch (newwebqlocator.getBy()) {
		case xpath:
			log.debug("find element By xpath");
//			--locator.getElement()
//			似乎是返回了一个字符串
//			该字符串是常规的元素名称	
			e = driver.findElement(By.xpath(newwebqlocator.getElement()));
			break;
		case id:
			log.debug("find element By id");
//			--这个locator.getElement将返回一个String,即元素路径
			e = driver.findElement(By.id(newwebqlocator.getElement()));
			break;
		case name:
			log.debug("find element By name");
			e = driver.findElement(By.name(newwebqlocator.getElement()));
			break;
		case cssSelector:
			log.debug("find element By cssSelector");
			e = driver.findElement(By.cssSelector(newwebqlocator.getElement()));
			break;
		case className:
			log.debug("find element By className");
			e = driver.findElement(By.className(newwebqlocator.getElement()));
			break;
		case tagName:
			log.debug("find element By tagName");
			e = driver.findElement(By.tagName(newwebqlocator.getElement()));
			break;
		case linkText:
			log.debug("find element By linkText");
			e = driver.findElement(By.linkText(newwebqlocator.getElement()));
			break;
		case partialLinkText:
			log.debug("find element By partialLinkText");
			e = driver.findElement(By.partialLinkText(newwebqlocator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(newwebqlocator.getElement()));
		}
		return e;
	}


	/**
	 * @author Young
	 * 返回一个locator对象,此时的locator对象是新的，包含了element=元素路径信息
	 * 1、传入一个参数，该参数描述了 元素定位信息的名称
	 * 2、根据这个名称，从外部文件获取对应的路径，返回给调用者
	 * @param locatorName
	 * @return
	 * @throws IOException
	 */
	public WebqLocator getLocator(String locatorName) throws IOException {

		WebqLocator locator;
		// for (int i = 0; i < locatorMap.length; i++) {
		// if (locatorMap[i][0].endsWith(locatorName)) {
		// return locator = new Locator(locatorMap[i][1]);
		// }
		// }
		// return locator = new Locator(locatorName);
		locator = locatorMap.get(locatorName);
		if (locator == null) {
			locator = new WebqLocator(locatorName);
		}
		return locator;
	}


	
	
}

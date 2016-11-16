package Webq.utils;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Webq.Locator.WebqLocator;

/**
 * @author 700sfriend
 *  外部传入driver,本类直接调用
 * @author 700sfriend
 * @author 700sfriend 该类描述了对元素的操作方法、日志、元素定位文本xml；继承这个类，就可以直接使用这里的方法
 */
public class BasePage {

	protected WebDriver driver;
	// protected String[][] locatorMap;
	public static HashMap<String, Locator> locatorMap;
	String path;
	protected Log log = new Log(this.getClass());

	
	/**
	 * @author 700sfriend
	 * @param 外部获取元素信息文件
	 * path为拼写的文件路径
	 * @param driver
	 * @throws Exception
	 */
	public BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		log.debug(this.getClass().getCanonicalName());
		log.info(System.getProperty("user.dir"));
		// locatorMap = ReadExcelUtil.getLocatorMap();
		path = System.getProperty("user.dir")
				+ "/src/main/java/Webq/Page/"
				+ this.getClass().getSimpleName() + ".xml";
		log.info(path);
		
		
		
		/**
		 * @author 700sfriend
		 *  从外部文件获取元素的定位位置
		 */
		locatorMap = xmlUtils.readXMLDocument(path, this.getClass()
				.getCanonicalName());
	}

	/**
	 * @author 700sfriend
	 * 一个action 方法，用于找到元素，并传输给元素一个值
	 * @param locator
	 * @param values
	 * @throws Exception
	 * 
	 */
	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + values);
		e.sendKeys(values);
	}

	/**
	 * This Method is for set value use javascript
	 * 
	 * @author Young
	 * @param locator
	 * @param values
	 * @throws Exception
	 */
	protected void typeQuick(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + values);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=\"" + values + "\"", e);

	}

	/**
	 * @author Young
	 * @param locator
	 * @param text
	 */
	protected void setRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", e);
	}

	/**
	 * @author Young
	 * @param locator
	 * @param text
	 * @return
	 */
	protected String getRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = (String) js.executeScript(
				"arguments[0].getInnerHTML()", e);
		return result;
	}

	/**
	 * @author Young
	 * @param locator
	 */
	protected void scrollToElement(Locator locator) {
		WebElement e = findElement(driver, locator);
		log.info("scroll view element");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// roll down and keep the element to the center of browser
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}

	/**
	 * @author 700sfriend 重新封装的click方法
	 * @param  locator：一个对象。 一个已知的元素的DOM位置
	 * @param  driver:  一个已知的driver,  是从最外层调用的方法传进来的。 
	 * ！！！使用JS技术点击，弹出层的元素
	 * 结果：定位元素并“点击”
	 * @throws Exception
	 */
	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("click button");
//		e.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",e);
	}
	
	protected void clickwap(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("click button");
//		e.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",e);
		
	}

	protected void select(Locator locator, String value) throws Exception {
		WebElement e = findElement(driver, locator);
		Select select = new Select(e);

		try {
			log.info("select by Value " + value);
			select.selectByValue(value);
		} catch (Exception notByValue) {
			log.info("select by VisibleText " + value);
			select.selectByVisibleText(value);
		}
	}

	protected void alertConfirm() {
		Alert alert = driver.switchTo().alert();
		try {
			alert.accept();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	protected void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		try {
			alert.dismiss();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	protected String getAlertText() {
		Alert alert = driver.switchTo().alert();
		try {
			return alert.getText();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	
//	鼠标悬停在当前位置，既不点击并且不释放
	protected void clickAndHold(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		Actions actions = new Actions(driver);
		actions.clickAndHold(e).perform();
	}
	
	

	

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(Locator locator) throws IOException {
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
	public WebElement getElement(WebDriver driver, Locator locator)
			throws IOException {
//		第一件事
//		locator.getElement() 获取元素的名称，即locatorname
//		getLocator()  将返回一个新的locator对象，这个对象是从locatormap中获取，获取依赖locatorname
		
		String locatorname =locator.getElement();
		Locator newlocator = getLocator(locatorname);
		
		log.debug("！元素名称是："+locatorname);
		log.debug("! 元素的路径是："+newlocator.getElement());
		
		
//		第二件事
		WebElement e;
//		获取locator对象的元素类型，即xpath
		switch (newlocator.getBy()) {
		case xpath:
			log.debug("find element By xpath");
//			--locator.getElement()
//			似乎是返回了一个字符串
//			该字符串是常规的元素名称	
			e = driver.findElement(By.xpath(newlocator.getElement()));
			break;
		case id:
			log.debug("find element By id");
//			--这个locator.getElement将返回一个String,即元素路径
			e = driver.findElement(By.id(newlocator.getElement()));
			break;
		case name:
			log.debug("find element By name");
			e = driver.findElement(By.name(newlocator.getElement()));
			break;
		case cssSelector:
			log.debug("find element By cssSelector");
			e = driver.findElement(By.cssSelector(newlocator.getElement()));
			break;
		case className:
			log.debug("find element By className");
			e = driver.findElement(By.className(newlocator.getElement()));
			break;
		case tagName:
			log.debug("find element By tagName");
			e = driver.findElement(By.tagName(newlocator.getElement()));
			break;
		case linkText:
			log.debug("find element By linkText");
			e = driver.findElement(By.linkText(newlocator.getElement()));
			break;
		case partialLinkText:
			log.debug("find element By partialLinkText");
			e = driver.findElement(By.partialLinkText(newlocator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(newlocator.getElement()));
		}
		return e;
	}

	public boolean isElementPresent(WebDriver driver, Locator myLocator,
			int timeOut) throws IOException {
		final Locator locator = getLocator(myLocator.getElement());
		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		
//		判断是否找到当前页面
//		http://my.oschina.net/u/928852/blog/98885?fromerr=kDYHyP3N
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver newdriver) {
				return findElement(newdriver, locator);
			}
		}).isDisplayed();
		return isPresent;
	}

	/**
	 * This Method for check isPresent Locator
	 * 判断当前页面是否为true
	 * @param locator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public boolean isElementPresent(Locator locator, int timeOut)
			throws IOException {
		return isElementPresent(driver, locator, timeOut);
	}
	

	/**
	 * @author 700sfriend
	 * 返回一个对象,且是WebElement对象
	 * @param 一个对象
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, final Locator locator) {
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver) {
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

	/**
	 * @author Young
	 * 返回一个locator对象,此时的locator对象是新的，包含了element=元素路径信息
	 * 1、传入一个参数，该参数描述了 元素定位信息的名称
	 * 2、根据这个名称，从外部文件获取对应的路径，返回给调用者
	 * @param locatorName
	 * @return
	 * @throws IOException
	 */
	public Locator getLocator(String locatorName) throws IOException {

		Locator locator;
		// for (int i = 0; i < locatorMap.length; i++) {
		// if (locatorMap[i][0].endsWith(locatorName)) {
		// return locator = new Locator(locatorMap[i][1]);
		// }
		// }
		// return locator = new Locator(locatorName);
		locator = locatorMap.get(locatorName);
		if (locator == null) {
			locator = new Locator(locatorName);
		}
		return locator;
	}
/**
 * @author 700sfriend
 *  检查知乎首页是否已打开
 * @param URL
 * @return
 */
	public int open(String URL)
	{
		if(URL==null ||URL.equals(""))
		{
			log.error("invlid URL");
			return -1;
		}
		int responseStatus = 200;
	    CloseableHttpClient httpclient = HttpClients.createDefault();  
	    try {  
	            // 创建httpget.    
	            HttpGet httpget = new HttpGet(URL);  
	            log.info("executing request " + httpget.getURI());  
	            // 执行get请求.    
	            CloseableHttpResponse response = httpclient.execute(httpget);  
	            try {  
	                // 获取响应实体    
	                HttpEntity entity = response.getEntity();  
	                log.info("--------------------------------------");  
	                // 打印响应状态    
	                log.info(response.getStatusLine().toString());  
	                if (entity != null) {  
	                    // 打印响应内容长度    
	                    log.info("Response content length: " + entity.getContentLength());  
	                    // 打印响应内容    
//	                    log.info("Response content: " + EntityUtils.toString(entity));  
	                }  
	                log.info("------------------------------------");  
	            } finally {  
	                response.close();  
	            }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                httpclient.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	  	return responseStatus;
	}

}

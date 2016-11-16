package Webq.Base;

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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Webq.Element.ElementPageHome;
import Webq.Locator.ResolveLocator;
import Webq.Locator.WebqLocator;
import Webq.utils.Locator;
import Webq.utils.Log;
import Webq.utils.WebqxmlUtils;
import Webq.utils.xmlUtils;

/**
 * @version 这完全是一个抽象出来的类，其他页面类可以继承它。该类包含了很多所有页面，记住，所有页面，共有的东西。
 * @author 700sfriend
 *  外部传入driver,本类直接调用
 * @author 700sfriend
 * @author 700sfriend 该类描述了对元素的操作方法、日志、元素定位文本xml；继承这个类，该类的对象就可以直接使用这里的方法
 * @since 但是，对于某div的对象来讲，就需要先定位到元素，才能使用这里的方法了。
 */
public class WebqBasePage extends ResolveLocator{

	protected WebDriver driver;
	ResolveLocator resLocator = null;
	// protected String[][] locatorMap;
	public static HashMap<String, WebqLocator> locatorMap;
	String path;
	protected Log log = new Log(this.getClass());

	
	/**
	 * @author 700sfriend
	 * @param 外部获取元素信息文件
	 * path为拼写的文件路径
	 * @param driver
	 * @throws Exception
	 */
	public WebqBasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		resLocator =  new ResolveLocator(this.driver);
		log.debug(this.getClass().getCanonicalName());
		
	}
	
	

	
	/**
	 * @author 700sfriend
	 * 一个action 方法，用于找到元素，并传输给元素一个值
	 * @param locator
	 * @param values
	 * @throws Exception
	 * 
	 */
	protected void type(WebqLocator locator, String values) throws Exception {
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
	protected void typeQuick(WebqLocator locator, String values) throws Exception {
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
	protected void setRichTextBox(WebqLocator locator, String text) {
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
	protected String getRichTextBox(WebqLocator locator, String text) {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = (String) js.executeScript(
				"arguments[0].getInnerHTML()", e);
		return result;
	}

	
	/**
	 * 获取页眉页脚的基础方法
	 * 
	 */
	public String getPageHead(WebqLocator locator) {
		WebElement e =  findElement(driver, locator);
		log.info("type value is:  " + driver.getTitle());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String result = (String) js.executeScript(
//				"arguments[0].getInnerHTML()", e);
		return driver.getTitle();
	}
	
	
	/**
	 * 获取页面AD图标大小的方法
	 * Dimension 的对象可以将元素的尺寸封装成一个对象。
	 * 
	 */
	public void getLogoSize(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		Dimension LogoDim = e.getSize();
		int valh = LogoDim.height;
		int valw = LogoDim.width;
		log.error("logo高度hight："+valh);
		log.error("logo宽度wight："+valw);
	}
	
	
	/**
	 * 获取页面Per周边节点的方法
	 * 这个节点下面包含了三个子节点
	 * @return 
	 */
	
	public WebElement getDivPer(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		return e;
	}
	
	public String getPerTitle(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		String PerTitle = e.getText();
		log.error("PerTtile的标题："+PerTitle);
		return PerTitle;
	}
	
	public String getPerbtnUrl(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		String PerbtnUrl = e.getAttribute("href");
		log.error("PerBtn的链接是："+PerbtnUrl);
		return PerbtnUrl;
	}

	
	
	
	/**
	 * @author Young
	 * @param locator
	 */
	protected void scrollToElement(WebqLocator locator) {
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
	protected void click(WebqLocator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("click button");
//		e.click();
//			在弹出层上单击
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",e);
	}

	protected void select(WebqLocator locator, String value) throws Exception {
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
	protected void clickAndHold(WebqLocator locator) throws IOException {
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

	public WebElement getElement(WebqLocator locator) throws IOException {
		return resLocator.getElement(this.getDriver(), locator);
	}



	public boolean isElementPresent(WebDriver driver, Locator myLocator,
			int timeOut) throws IOException {
		final WebqLocator locator = resLocator.getLocator(myLocator.getElement());
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
	//public WebElement findElement(WebDriver driver, final WebqLocator locator) {		  
	//	  WebElement element = findElement(driver, locator);			
	//	  return element;
	//}


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

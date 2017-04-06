package Webq.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import org.testng.Assert;

import Webq.Element.ElementPageHome;
import Webq.Locator.ResolveLocator;
import Webq.Locator.WebqLocator;
import Webq.utils.Locator;
import Webq.utils.Log;
import Webq.utils.UrlUtil;
import Webq.utils.WebqxmlUtils;
import Webq.utils.xmlUtils;


/**
 * base64解析
 */
import org.apache.commons.codec.binary.Base64;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import sun.misc.BASE64Encoder;
/**
 * @version 这完全是一个抽象出来的类，其他页面类可以继承它。该类包含了很多所有页面，记住，所有页面，共有的东西。
 * @author 700sfriend
 *  外部传入driver,本类直接调用
 * @author 700sfriend
 * @author 700sfriend 该类描述了对元素的操作方法、日志、元素定位文本xml；继承这个类，该类的对象就可以直接使用这里的方法
 * @since 但是，对于某div的对象来讲，就需要先定位到元素，才能使用这里的方法了。
 */
public class WapBasePage extends ResolveLocator{

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
	public WapBasePage(WebDriver driver) throws Exception {
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
	
	public String getPerTitleWap(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		String PerTitle = e.getText();
		log.error("PerTtile的标题："+PerTitle);
		return PerTitle;
	}
	
	public String getPerbtnUrlWap(WebqLocator locator){
		WebElement e = resLocator.findElement(driver,locator);
		String PerbtnUrl = e.getAttribute("href");
		log.error("PerBtn的链接是："+PerbtnUrl);
		return PerbtnUrl;
	}

	/**
	 * WAP版首页的横排五个ICON的父节点
	 * @author 700sfriend  
	 **/
	public WebElement getDivMenuBar(WebqLocator locator){
		WebElement DivMenuBar = resLocator.findElement(driver, locator);		
		Assert.assertNotNull(DivMenuBar);
		return DivMenuBar;			
	}
	
	/*遍历出来每个子元素*/
	/**
	 * 每个子元素，都有一个a标签。
	 * 先设置一个List,获取所有父元素下面，所有的a标签元素。
	 * 
	 */
	
	 /*
	  * 两种获取子节点集合的findelements:
	  * 1、driver+绝对路径（父+子）；
	  * 2、父元素+相对路径（子）
	  * 二选一即可
	  */
	public void getSubDivMenuBar(WebElement DivMenuBar) {
		// TODO Auto-generated method stub
		
		 List<WebElement> SubDivs = new ArrayList<WebElement>();
//		 SubDivs = driver.findElements(By.xpath(PathDivMenuBar+"/a"));
		 SubDivs = DivMenuBar.findElements(By.xpath("./a"));
		 
		 /*AssertTrue的使用格式：判断条件+失败信息*/
		 Assert.assertTrue(SubDivs.size()>=0, "未获取MenuBar节点的集合。");		 

		 /*这个角标要从0开始*/
		 for (int i = 0;i<SubDivs.size();i++){		 
			 /*子元素的名称*/
			 System.err.println("名称:"+SubDivs.get(i).getText());
			 String[] document = {"城市自行车","潮流装备","大牌尖货","限时促销","领券中心"};
			 System.err.println("预期名称："+document[i]);
			 Assert.assertEquals(SubDivs.get(i).getText(),document[i],"告警：icon的名称与预期不一致！");
			
			 /*子元素的标签*/
			 System.err.println("标签:"+SubDivs.get(i).getTagName());
			 
			 /*子元素的href*/	
			 String str = SubDivs.get(i).getAttribute("href");
			 String newStr =  UrlUtil.getURLDecoderString(str);
			 System.err.println("URL:"+newStr);
			 
			 String UrlTxt = null;
			 String filePath = System.getProperty("user.dir")+"/Menu-bar-Url.txt";
			 UrlTxt = getUrl(filePath,i);//把循环下标传给数据数组，这样可以按顺序比对。
			 Assert.assertEquals(newStr, UrlTxt,"告警：URL链接错误！");		 
			 
			 /*获取子元素ICON：*/
			 WebElement tsSpan = SubDivs.get(i).findElement(By.xpath("./p[1]"));
			 
			 
			 /*子元素ICon的CSS样式*/
			 String CssValue = tsSpan.getCssValue("width");
			 System.err.println(CssValue);
			 
			 /*子元素的图片及名称*/
			 String pName =  tsSpan.getAttribute("class").toString();
			 System.err.println("icon图片的名称是："+ pName);
			 
			 /*子元素的ICON尺寸*/
			 Dimension DimSpan = tsSpan.getSize();
			 System.err.println("子元素ICON的尺寸:"+DimSpan.getHeight());
			 System.err.println("子元素ICON的尺寸:"+DimSpan.getWidth());
			 Assert.assertEquals(DimSpan.getHeight(), 131,"告警：ICON高度错误。");
//			 Assert.assertEquals(DimSpan.getWidth(), 270,"告警：ICON宽度错误。");
			 
			 
			 /*循环结果的分割行*/
			 System.err.println("****************************************************");
			 System.err.println("****************************************************");
			 
		 }
	}
	
	/**
	 * 把文件的内容，写入一个数组。
	 * 从一个txt文件读取URL信息，然后逐行存入一个数组中。
	 * 调用数组【n】，与实际URL进行对比。
	 * @param filePath
	 * @param n
	 * @return
	 */
	public String getUrl(String filePath,int n) {
		// TODO Auto-generated method stub
		
		 String encoding="UTF-8";
		 String UrlLineTxt = null;
		 try {	
			 File file = new File(filePath);
			 String sss = null;
			 if(file.isFile() && file.exists()){ //判断文件是否存在
				 InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式 
				 BufferedReader bufferedReader = new BufferedReader(read); 
				 int m = 0;
				 String[] ttt = new String[20];
				 while((sss = bufferedReader.readLine()) != null){
					 /*先把文件的内容，按行读入输入，再从数组中取出来*/
					 //	System.out.println(sss);
						ttt[m] = sss; 
						m++;
						UrlLineTxt = ttt[n];
					}
					read.close(); 
				}else{
					System.out.println("找不到指定的文件");
					}
					} catch (Exception e) { 
						System.out.println("读取文件内容出错"); 
						e.printStackTrace();
					} 
		return UrlLineTxt;
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

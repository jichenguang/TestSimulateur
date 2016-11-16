package Webq.Matter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Div 元素类：商品详情页的二级导航
 * @author 700sfriend
 *
 */
public class  MatterCrumb  {
		
	 private String pathmatterCrumb;
	 private WebDriver driver;
	 private WebElement matterCrumb;
	 private String path;

	/**
	 * 构造函数：MatterNavigitionOfPageProduct
	 * @param driver
	 * @param path
	 */
	  public MatterCrumb(WebDriver driver,String path){
		  this.driver = driver;
		  this.path = path; 
		  this.getMatterCrumb();
		  
	  }
	  
	  /**
	   * 方法：getMatterNavigition
	   * 获取二级导航的WebElement
	   * @return
	   */
	  public WebElement getMatterCrumb() {
			//		  location	
		  	 pathmatterCrumb = path + "//div[@class = 'crumb-trail']";
//		  	 pathmatterCrumb =  
		  	 matterCrumb =  driver.findElement(By.xpath(pathmatterCrumb));
			 System.out.println(matterCrumb.getText());
			 return matterCrumb;
	  }
	  
	  /**
	   * 方法：获取导航栏的a节点
	   * @return
	   */  
	  public List<WebElement> getAdiv() {		  		
		List<WebElement> matterCrumbA = matterCrumb.findElements(By.tagName("a"));
		System.out.println("二级导航的节点数量为："+(matterCrumbA.size()+1));
		System.out.println(matterCrumbA.get(1).getText());
		return matterCrumbA;		  
	  }
	  
	   
	  
}

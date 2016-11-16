package Webq.Matter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Webq.Element.ElementPageProduct;
import Webq.Locator.WebqLocator;


/**
 * MatterClass:获取Product页面中部的元素
 * @author 700sfriend
 *
 */
public class MatterMiddle {
	
	
	private WebDriver driver;


	private WebElement matterMiddleDiv;

	private String pathmatterMiddleDiv;
	
	ElementPageProduct elementPageProduct = new ElementPageProduct(driver);


	/**
	 * 构造函数
	 */
	public  MatterMiddle(WebDriver driver){
		this.driver = driver;	
		this.getMatterMiddleDiv();
//		System.out.println("123排错排错排错排错排错排错排错排错");
		this.getCrumb();
//		this.getMainList();
//		this.getSideNav();
	}
	

	
	
	/**
	 * 获取div:页面中间的Div
	 * @return
	 */
	private WebElement getMatterMiddleDiv() {
		// TODO Auto-generated method stub
		pathmatterMiddleDiv = this.getPathMiddleDiv();
		matterMiddleDiv = driver.findElement(By.xpath(pathmatterMiddleDiv));
		return  matterMiddleDiv;
	}
	
	

	/**
	 * 页面中间Div的路径
	 */
	//private  String strMiddleDiv = ".//div[@class = 'content-holder graybg product-detail-page']";
	WebqLocator sssloc = new WebqLocator("MiddleDiv");	
	private String strMiddleDiv = sssloc.getElement();
	
	/*
	 * 设置中间Div元素的Path
	 * 
	 */
	public   String setPathMiddleDiv(String path){	
		String pathMiddleDiv = path;			
		return pathMiddleDiv;
	}
	
	
	/*
	 * 获取中间Div元素的Path
	 * 
	 */
	public   String getPathMiddleDiv(){			
		return this.setPathMiddleDiv(strMiddleDiv);
	}
	
	

				
	
	/**
	 * 获取div:面包屑导航
	 * @return 
	 */
	public MatterCrumb getCrumb() {
		// TODO Auto-generated method stub
		
	  /*
	   * 以前的写法
	    String pathmatterNavigition = pathmatterMiddleDiv + "//div[@]";
		matterNavigition = driver.findElement(By.xpath(pathmatterNavigition));
		return  matterNavigition;
		*/
		return new MatterCrumb(driver,pathmatterMiddleDiv);
	}
	
	

	
	private void getSideNav() {
		// TODO Auto-generated method stub
		
	}

	private void getMainList() {
		// TODO Auto-generated method stub
		
	}
	
}
